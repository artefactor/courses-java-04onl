package by.train;

import by.train.model.several.assotiations1.AuthorBookTransient;
import by.train.model.several.assotiations1.BookManyToOne;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * test associations
 *
 * @author Artsiom_Zolatau
 * @see AuthorBookTransient
 * @see BookManyToOne
 */

public class AnnExampleAssociationsBooks {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		System.out.println("Start");

		List<Serializable> authorIds = new ArrayList<Serializable>();
		List<Serializable> bookIds = new ArrayList<Serializable>();

		cleanAll(sessionFactory);
		createObjectNetwork(sessionFactory, authorIds, bookIds);
		findObjectsNetwork(sessionFactory, authorIds, bookIds);

		System.out.println("Succsess");
		sessionFactory.close();
	}

	public static void cleanAll(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.createQuery("delete  from by.train.model.several.assotiations1.AuthorBookTransient where 1=1").executeUpdate();
		session.createQuery("delete  from by.train.model.several.assotiations1.BookManyToOne where 1=1").executeUpdate();

		session.createQuery("delete  from by.train.model.several.assotiations2.AuthorOneToMany where 1=1").executeUpdate();
		session.createQuery("delete  from by.train.model.several.assotiations2.Book where 1=1").executeUpdate();

		session.createQuery("delete  from by.train.model.several.assotiations3.AuthorWrongMapped where 1=1").executeUpdate();
		session.createQuery("delete  from by.train.model.several.assotiations3.BookWrongMapped where 1=1").executeUpdate();

		session.createQuery("delete  from by.train.model.several.assotiations4.AuthorBidirectional where 1=1").executeUpdate();
		session.createQuery("delete  from by.train.model.several.assotiations4.BookBidirectional where 1=1").executeUpdate();

		session.createQuery("delete  from by.train.model.several.assotiations5.AuthorJoinTable where 1=1").executeUpdate();
		session.createQuery("delete  from by.train.model.several.assotiations5.BookJoinTable where 1=1").executeUpdate();
		tx.commit();
		session.close();
	}

	private static void createObjectNetwork(SessionFactory sessionFactory,
											List<Serializable> authorIds,
											List<Serializable> bookIds
	) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		AuthorBookTransient author1 = new AuthorBookTransient(2, "Harper Lee");
		BookManyToOne book1 = new BookManyToOne(10, "To Kill a Mockingbird");
		AuthorBookTransient author2 = new AuthorBookTransient(4, "Poul Anderson");

		BookManyToOne book2 = new BookManyToOne(30, "The Corridors of Time");
		BookManyToOne book3 = new BookManyToOne(50, "Time Patrol");

/*  simplified
		book1.setAuthor(author1);
		book2.setAuthor(author2);
		book3.setAuthor(author2);
*/
		author1.addBook(book1);
		author2.addBook(book2);
		author2.addBook(book3);


		System.out.println("Begin saving");
		// order is important
		session.save(author1); // may be cascading
		session.save(book1);
		session.save(author2);
		session.save(book2);
		session.save(book3);


		tx.commit();
		session.close();
		System.out.println("Session closed");

		authorIds.add(author1.getId());
		authorIds.add(author2.getId());
		bookIds.add(book1.getId());
		bookIds.add(book2.getId());
		bookIds.add(book3.getId());

	}

	private static void findObjectsNetwork(SessionFactory sessionFactory,
										   List<Serializable> authorIds,
										   List<Serializable> bookIds
	) {
		System.out.println("Begin searching");
		Session session = sessionFactory.openSession();
		BookManyToOne book = session.get(BookManyToOne.class, bookIds.get(0));
		System.out.println("book class: " + book.getClass());
		System.out.println("book: " + book);
		System.out.println("book author: " + book.getAuthor());

		AuthorBookTransient author = session.get(AuthorBookTransient.class, authorIds.get(1));
		System.out.println("author class: " + author.getClass());
		System.out.println("author books: " + author.getBooks());

		session.close();
		System.out.println("Session closed");
	}
}
