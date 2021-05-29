/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2010, Red Hat Inc. or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.hibernate.tutorial.annotations;

import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import train.model.Event;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotEquals;

/**
 * Illustrates the use of Hibernate native APIs.  The code here is unchanged from the {@code basic} example, the
 * only difference being the use of annotations to supply the metadata instead of Hibernate mapping files.
 *
 * @author Steve Ebersole
 */
public class AnnotationsIllustrationTest extends TestCase {
	private SessionFactory sessionFactory;

	@Override
	protected void setUp() throws Exception {
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg.test.xml") // configures settings from hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			System.out.println(e);
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

	@Override
	protected void tearDown() throws Exception {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}

	@SuppressWarnings({"unchecked"})
	public void testBasicUsage() {
		// create a couple of events...
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(new Event("Our very first event!", new Date()));
		session.save(new Event("A follow up event", new Date()));
		session.getTransaction().commit();
		session.close();

		// now lets pull events from the database and list them
		session = sessionFactory.openSession();
		session.beginTransaction();
		List result = session.createQuery("from Event").list();
		for (Event event : (List<Event>) result) {
			System.out.println("Event (" + event.getDate() + ") : " + event.getTitle());
		}
		session.getTransaction().commit();
		session.close();
	}

	public void testGetWork() {
		// given
		insertTwoObjects();
		//when
		Session session = sessionFactory.openSession();
		Event o1 = session.get(Event.class, 1L);
		System.out.println("loaded1: " + o1.getClass());
		session.close();
		//then
		assertEquals(o1.getClass(), Event.class);
	}

	public void testLoadWork() {
		// given
		insertTwoObjects();
		//when
		Session session = sessionFactory.openSession();
		Event o1 = session.load(Event.class, 1L);
		System.out.println("loaded1: " + o1.getClass());
		session.close();
		//then
		assertNotEquals(o1.getClass(), Event.class);
		assertTrue(o1.getClass().getName().toLowerCase().contains("proxy"));
	}

	public void testGetAfterLoadWork() {
		// given
		insertTwoObjects();
		//when
		Session session = sessionFactory.openSession();
		Event o1 = session.load(Event.class, 1L);
		System.out.println("loaded1: " + o1.getClass());

		Event o2 = session.get(Event.class, 1L);
		System.out.println("loaded2: " + o2.getClass());

		session.close();
		//then
		assertTrue(o2.getClass().getName().toLowerCase().contains("proxy"));
		assertNotEquals(o1.getClass(), Event.class);
		assertNotEquals(o2.getClass(), Event.class);
		assertSame(o1, o2);
	}

	public void testLoadAfterGetWork() {
		// given
		insertTwoObjects();
		//when
		Session session = sessionFactory.openSession();
		Event o1 = session.get(Event.class, 1L);
		System.out.println("loaded1: " + o1.getClass());

		Event o2 = session.load(Event.class, 1L);
		System.out.println("loaded2: " + o2.getClass());

		session.close();
		//then
		assertFalse(o2.getClass().getName().toLowerCase().contains("proxy"));
		assertEquals(o1.getClass(), Event.class);
		assertEquals(o2.getClass(), Event.class);
		assertSame(o1, o2);
	}

	private void insertTwoObjects() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(new Event("First event!", new Date()));
		session.save(new Event("Second event", new Date()));
		session.getTransaction().commit();
		session.close();
	}


}
