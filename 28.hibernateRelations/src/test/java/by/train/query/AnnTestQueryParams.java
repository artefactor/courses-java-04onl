package by.train.query;

import by.train.model.one.Track;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * querying with param
 *
 * @author Artsiom_Zolatau
 * @see Track
 */
public class AnnTestQueryParams {

	private static final Logger log = LogManager.getLogger(AnnTestQueryParams.class);
	private static SessionFactory sessionFactory;

	@BeforeClass
	public static void setUp()  {
		Configuration cfg = new Configuration().configure();
		sessionFactory = cfg.buildSessionFactory();
		insertSeveralTracks();
	}

	private static  void insertSeveralTracks() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(createTrack("Somebody to Love", "Queen", 1976));
		session.save(createTrack("You’re My Best Friend", "Queen", 1976));
		session.save(createTrack("We Are the Champions", "Queen", 1977));
		session.save(createTrack("Nothing else matters", "Metallica", 1991));
		session.save(createTrack("Smells Like Teen Spirit", "Nirvana", 1991));
		session.save(createTrack("The Show Must Go On", "Queen", 1991));
		session.save(createTrack("About a Girl", "Nirvana", 1994));
		session.save(createTrack("It’s My Life", "Bon Jovi", 2000));
		session.flush();
		session.close();
	}

	@AfterClass
	public static void tearDown() {
		// TODO 0 implement data cleaning
		Session session = sessionFactory.openSession();
		session.createSQLQuery("delete from TRACK").executeUpdate();
		session.close();
		sessionFactory.close();
	}

	// test found tracks only of 90-th
	@Test
	public void searchByYearShouldWork() {
		log.info("start");
		Session session = sessionFactory.openSession();
		// TODO 1 write working  query
		String queryString = "from Track track"
				+ " where track.title like :search"
				+ " and track.added <= :minDate";

		Query q = session.createQuery(queryString)
				.setDate("minDate", date(1990, 01,01))
				.setDate("maxDate", date(2000, 01,01));
		List list = q.list();
		log.info("found:" + list.size());
		session.close();
		log.info("Succsess!");
		assertEquals(4, list.size());
	}

	@Test
	public void searchByArtistNameShouldWork() {
		log.info("start");
		Session session = sessionFactory.openSession();
		// TODO 2 write working  query
		String queryString = "from Track track"
				+ " where track.name like :search"
				+ " and track.added <= :minDate";


		String searchString = "%irvana";

		Query q = session.createQuery(queryString)
				.setString("search", searchString);
		List list = q.list();
		log.info("found:" + list.size());
		session.close();
		log.info("Succsess!");
		assertEquals(2, list.size());
	}

	@Test
	public void searchByExampleShouldWork() {
		log.info("start");
		Session session = sessionFactory.openSession();

		Track exampleEntity = createTrack("You’re My Best Friend", "Queen", 1976);

		// TODO 3 write working  Example usage
		List list = session.createCriteria(Track.class)
				.add(Example.create(exampleEntity)
						)
				.list();

		log.info("found:" + list.size());
		session.close();
		log.info("Succsess!");
		assertEquals(2, list.size());
	}

	@Test
	public void searchByNamedQueryShouldWork() {
		log.info("start");
		Session session = sessionFactory.openSession();
		// TODO 4 write working  named query
		String searchString = "%My%";
		Query q = session.getNamedQuery("findTracksByTitle").setString("title", searchString);
		List list = q.list();

		log.info("found:" + list.size());
		session.close();
		log.info("Succsess!");
		assertEquals(2, list.size());
	}


	private static Track createTrack(String title, String artist, int year) {
		Track track = new Track();
		track.setCreated(date(year, 10, 10));
		track.setTitle(title);
		track.setArtist(artist);
		return track;
	}

	private static Date date(int year, int month, int dayOfMonth) {
		return Date.from(LocalDate.of(year, month, dayOfMonth).atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

}
