package by.train.hibernate;

import by.train.model.Event;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Session {
	/**
	 * условно - список наших изменений. В каком виде они хранятся в хибернейте - это надо копать.
	 * для нашего примера будем хранить просто последнюю версию объекта.
	 * по идее нужно еще сохранять операцию для последующего выбора SQL запросов (delete, insert, update)
	 */
	private HashMap<Long, Event> unitOfWork = new HashMap();
	/**
	 * кэш уже вычитанных объектов из БД
	 */
	private HashMap<Long, Event> cache = new HashMap();
	/**
	 * список объектов в состоянии Persistent
	 */
	private Set<Long> persistentObjects = new HashSet<>();
	/**
	 * список объектов в состоянии Detached
	 */
	private Set<Long> detachedObjects = new HashSet<>();

	// TODO вопрос к вам:
	// А почему в этом примере нету списка объектов в состоянии transient?

	private boolean isClosed;

	public Transaction beginTransaction() {
		return new Transaction(this);
	}

	/**
	 * https://www.tutorialspoint.com/difference-between-save-and-persist-in-hibernate
	 * в хибернейте есть методы save() persist()
	 * TODO подумайте как бы вы реализовали в нашем прототипе?
	 * @param event
	 */
	public void create(Event event) {
		if (event.getId() != null) {
			// handle
		} else {
			Long id = getNextId();
			event.setId(id);
		}
		Long id = event.getId();
		// добавляем изменения, чтобы потом их применить
		unitOfWork.put(id, event);
		// добавляем объект в список персистентов
		persistentObjects.add(id);
	}

	public void update(Event event) {
		if (event.getId() == null) {
			// handle
		}
		// проверим, храним ли мы информацию об этом объекте.
		// возможно, он в состоянии, в котором его нельзя сохранить, например, detached, removed

		if (persistentObjects.contains(event.getId())) {
			// handle
		}
		if (detachedObjects.contains(event.getId())) {
			// handle
		}
		// проверяем, есть ли у нас какие-то изменения с этим объектом
		Event cachedObject = unitOfWork.get(event.getId());
		if (cachedObject == null) {
			// изменений нет, это первое изменения
			unitOfWork.put(event.getId(), event);
		} else {
			// обновляем кэшированный объект
			cachedObject.setTitle(event.getTitle());
		}
	}

	/**
	 * Делает синхронизациию объектов памяти с БД. вызывается в нескольких случаях,
	 * смотрите документацию
	 *
	 * Force this session to flush. Must be called at the end of a
	 * unit of work, before committing the transaction and closing the
	 * session (depending on {@link #setFlushMode(FlushMode)},
	 * {@link Transaction#commit()} calls this method).
	 * <p/>
	 * <i>Flushing</i> is the process of synchronizing the underlying persistent
	 * store with persistable state held in memory.
	 *
	 * @throws HibernateException Indicates problems flushing the session or
	 * talking to the database.
	 */
	public void flush() {
		// здесь нужно пробежаться по всем нашим объектов и unitOfWork
		// и выполнить операции remove, insert, update
		// в примере мы только выполним операции update.
		// соберем только измененные поля и составим SQL запрос только по полям,
		// которые изменились
		unitOfWork.forEach((id, object) -> {
			Event cachedObject = cache.get(id);
			Set updatedFields = new HashSet();
			if (cachedObject != null) {
				// пробегаем по всем полям, проверяем, которые поменялись
				if (cachedObject.getTitle().equals(object.getTitle())) {
					updatedFields.add("title");
				}
				if (cachedObject.getTopic().equals(object.getTopic())) {
					updatedFields.add("topic");
				}
			} else {
				// если нет у нас информации, добавляем все поля
				updatedFields.add("title");
				updatedFields.add("topic");
			}
			// строим SQL update используя только те поля, что изменились
			doUpdateOnlyForSelectedFields(object, updatedFields);
		});
		// очищаем историю наших изменений
		unitOfWork.clear();
	}

	/**
	 * Get - по своему описанию:
	 * It returns fully initialized object so this method eager load the object
	 * <p>
	 * It object not found for the given identifier then it will return null object
	 * <p>
	 * It is slower than load() because it return fully initialized object which impact the performance of the application
	 */
	public Event get(Class<Event> eventClass, long id) {
		// возможно, хибернейт запускает flush() перед этим запросом - можно проверить
		boolean ifNeededFlush = false;
		if (ifNeededFlush) {
			flush();
		}
		// get - по описанию должен читать из БД напрямую, но если был вызван load() до этого - возможно происходит не так
		Event event = readFromDB(id);
		if (event != null) {
			// добавляем в кэш
			cache.put(event.getId(), event);
			// добавляем в список персистентов
			persistentObjects.add(id);
		}
		return event;
	}

	/**
	 * Load - по своему описанию:
	 *
	 * It always (по факту получается не всегда) returns proxy object so this method is lazy load the object
	 *
	 * It will throw object not found exception
	 *
	 * It is slightly faster.
	 **/
	public Event load(Class<Event> eventClass, long id) {
		// проверяем в кэше
		Event event = cache.get(id);
		if (event != null) {
			return event;
		}
		// не читаем с БД, а создаем прокси-объект
		ProxyEvent proxyEvent = new ProxyEvent(this, id);
		// кладем его в кэш
		cache.put(event.getId(), proxyEvent);
		// добавляем в список персистентов
		persistentObjects.add(id);
		return event;
	}

	public void close() {
		isClosed = true;
	}

	public boolean isClosed() {
		return isClosed;
	}

	//------------------------------------------------------------------------
	//   ниже методы, которые должны обращаться непосредственно к БД через JDBC
	//------------------------------------------------------------------------
	Event readFromDB(long eventId) {
		// sql specific
		System.out.println("readFromDB");
		Event event = new Event();
		boolean valueExist = true;
		if (valueExist) {
			// читаем все поля и заполняем
			String title = "readedTitle";
			event.setTitle(title);
			event.setTopic("readedTopic");
		}
		return event;
	}

	private Long getNextId() {
		// sql specific
		System.out.println("getNextId");
		return 1L;
	}


	private void doUpdateOnlyForSelectedFields(Event object, Set updatedFields) {
		// sql specific
		System.out.println("doUpdateOnlyForSelectedFields");
	}

}
