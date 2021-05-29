package by.train.hibernate;

import by.train.model.Event;

/**
 * Proxy класс сгенерированный нашим hibernate прототипом.
 * В hibernate такие классы - общие и генерируются динамически
 */
public class ProxyEvent extends Event {
	/**
	 * поля копируются
	 */
	private long id;
	private String title;
	private String topic;
	/**
	 * ссылка на сессию
	 */
	private final Session session;
	/**
	 * флаг прочитано или нет
	 */
	private boolean notReaded;

	/**
	 * объект, который мы проксируем
	 */
	private Event target;

	public ProxyEvent(Session session, long id) {
		this.session = session;
		this.id = id;
	}

	@Override
	public String getTitle() {

		if (notReaded) {
			if (session.isClosed()) {
				throw new RuntimeException("could not initialize proxy [train.model.Event#1] - no Session");
			}
			target = session.readFromDB(id);
			if (target == null) {
				throw new RuntimeException("object not found");
			}
			notReaded = true;
		}
		return target.getTitle();
	}

	@Override
	public String getTopic() {
		//TODO  - метод сейчас неправильно написан. каким он должен быть?
		if (notReaded) {
			session.readFromDB(id);
			notReaded = true;
		}
		return super.getTopic();
	}

	@Override
	public void setTopic(String topic) {
		super.setTopic(topic);
	}


	@Override
	public void setTitle(String new_event) {
		super.setTitle(new_event);
	}

	@Override
	public void setId(Long id) {
		super.setId(id);
	}
}

