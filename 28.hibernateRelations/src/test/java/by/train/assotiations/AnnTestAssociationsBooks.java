package by.train.assotiations;

import by.train.AnnExampleAssociationsBooks;
import by.train.model.several.assotiations.Author;
import by.train.model.several.assotiations.Book;
import by.train.model.several.assotiations1.AuthorBookTransient;
import by.train.model.several.assotiations1.BookManyToOne;
import by.train.model.several.assotiations5.AuthorJoinTable;
import by.train.model.several.assotiations5.BookJoinTable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.collection.internal.PersistentSet;
import org.junit.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * test associations
 *
 * @author Artsiom_Zolatau
 * @see AuthorBookTransient
 * @see BookManyToOne
 */

public class AnnTestAssociationsBooks {
	private static SessionFactory sessionFactory;
	private static Session session;

	private static List<Serializable> authorIds = new ArrayList<Serializable>();
	private static List<Serializable> bookIds = new ArrayList<Serializable>();

	@BeforeClass
	public static void setUpAll() {
		Configuration cfg = new Configuration().configure();
		sessionFactory = cfg.buildSessionFactory();
		cleanAll(sessionFactory);
		createObjectNetwork();
	}

	@AfterClass
	public static void tearDownAll() {
		sessionFactory.close();

	}

	private static void cleanAll(SessionFactory sessionFactory) {
		AnnExampleAssociationsBooks.cleanAll(sessionFactory);
	}

	@Before
	public void setUp()  {
		session = sessionFactory.openSession();
		System.out.println("Start");
		System.out.println("Begin searching");
	}

	@After
	public void tearDown() {
		session.close();
		System.out.println("Session closed");
	}

	@Test
	public void testSearchAuthorThenBooks() {
		// TODO correct mapping
		Author author = session.get(AuthorJoinTable.class, authorIds.get(0));
		log("3.     author : %s, %s", author.getClass(), author);
		session.close();   // check with LAZY or EAGER
		log("4. author books : %s, %s", author.getBooks().getClass(), author.getBooks());

		assertEquals(AuthorJoinTable.class, author.getClass());
		assertEquals(PersistentSet.class, author.getBooks().getClass());
	}

	/**
	 *
	 */
	@Test
	public void testSearchBookThenAuthor() {
		Book book = session.get(BookManyToOne.class, bookIds.get(0));

		log("1. book: %s, %s", book.getClass(), book);
		log("2. book author: %s, %s", book.getAuthor().getClass(), book.getAuthor());

		AuthorBookTransient author = session.get(AuthorBookTransient.class, book.getAuthor().getId());
		log("3.      author : %s, %s", author.getClass(), author);

		//assert
		assertEquals(BookManyToOne.class, book.getClass());
		assertEquals(author, book.getAuthor());
		assertEquals(AuthorBookTransient.class, author.getClass());
	}

	@Test
	public void testSearchBookThenAuthorThenBooks() {
		Book book = session.get(BookManyToOne.class, bookIds.get(0));

		log("1. book: %s, %s", book.getClass(), book);
		log("2. book author: %s, %s", book.getAuthor().getClass(), book.getAuthor());

		Author author = session.get(AuthorBookTransient.class, book.getAuthor().getId());
		log("3.     author : %s, %s", author.getClass(), author);
		log("4. author books : %s, %s", author.getBooks().getClass(), author.getBooks());

		//assert
		assertEquals(BookManyToOne.class, book.getClass());
		assertEquals(author, book.getAuthor());
		assertEquals(AuthorBookTransient.class, author.getClass());
		assertEquals(PersistentSet.class, author.getBooks().getClass());
	}

	public static void log(String format, Object... args) {
		System.out.println(String.format(format, args));
	}

	private static void createObjectNetwork() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		AuthorJoinTable author1 = new AuthorJoinTable(2, "Harper Lee");
		BookJoinTable book1 = new BookJoinTable(10, "To Kill a Mockingbird");

		AuthorJoinTable author2 = new AuthorJoinTable(4, "Poul Anderson");
		BookJoinTable book2 = new BookJoinTable(30, "The Corridors of Time");
		BookJoinTable book3 = new BookJoinTable(50, "Time Patrol");

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

}
