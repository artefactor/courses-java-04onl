//package dao;
//
//import model.Event;
//import org.hibernate.Hibernate;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//
//import java.util.List;
//
//public class Dao implements IDao {
//
//	private SessionFactory sessionFactory;
//
//	public void init() {
//		// A SessionFactory is set up once for an application!
//		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//				.configure() // configures settings from hibernate.cfg.xml
//				.build();
//		try {
//			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
//		} catch (Exception e) {
//			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
//			// so destroy it manually.
//			//	StandardServiceRegistryBuilder.destroy(registry);
//			throw new Error("impossible to continue ", e);
//		}
//	}
//
//	public void destroy() {
//		getSessionFactory().close();
//	}
//
//	public void create(Event event) {
//
//		Session session = getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//		session.save(event);
//		session.getTransaction().commit();
//		session.close();
//	}
//
//	private SessionFactory getSessionFactory() {
//		return HibernateUtils.getSessionFactory();
//	}
//
//	public List<Event> getAll() {
//		Session session = getSessionFactory().openSession();
//		List<Event> from_event = session.createQuery("from Event", Event.class).list();
//		return from_event;
//	}
//
//	public Event getById(long id) {
//		return null;
//	}
//
//	public void update(Event event2) {
//
//	}
//
//	public void delete(Event event) {
//
//	}
//}
