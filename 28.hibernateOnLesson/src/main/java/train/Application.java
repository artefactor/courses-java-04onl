package train;

import train.dao.EventDao;
import train.dao.HibernateUtils;
import train.model.Event;

import java.util.List;

public class Application {

	public static void main(String[] args) {
		EventDao eventDao = new EventDao();

		Event event = new Event();
		event.setTitle("new event");
		//create
		eventDao.create(event);
		//get
		Event event2 = eventDao.getById(1L);
		//update
		event2.setTitle("new title");
		eventDao.update(event2);
		//delete
		eventDao.delete(event);
		//getAll
		List<Event> list = eventDao.getAll();

		System.out.println(list);

		HibernateUtils.getSessionFactory().close();
	}
}
