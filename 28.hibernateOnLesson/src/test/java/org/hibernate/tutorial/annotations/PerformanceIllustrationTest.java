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
import train.model.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Illustrates the use of Hibernate native APIs.  The code here is unchanged from the {@code basic} example, the
 * only difference being the use of annotations to supply the metadata instead of Hibernate mapping files.
 *
 * @author Steve Ebersole
 */
public class PerformanceIllustrationTest extends TestCase {
	private SessionFactory sessionFactory;

	@Override
	protected void setUp() throws Exception {
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
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


	public void testPerformance() throws InterruptedException {
		boolean readOnly = false;
		int count = 3000;

		insertManyEvents(count);
		System.gc();
		Session session = sessionFactory.openSession();
		System.gc();
		printMemory();
		System.gc();
		Thread.sleep(1000);

		session.setDefaultReadOnly(readOnly);
		List<Product> list = session.createQuery("from Product").setReadOnly(readOnly).list();
		System.out.println("readed " + list.size() + " objects with readOnly mode  " + readOnly + " :");
		System.gc();
		printMemory();
		List<Product> updatedList = new ArrayList<>();

		System.out.println("update objects");
		list.forEach(t -> {
//			t.setTitle("new Title" + Math.random() + t.getTopic());
			Product e = session.get(Product.class, t.getId());
			e.setB((long) (Math.random() * 100000L));
			updatedList.add(e);
//			System.out.println(t.getId());
		});
		System.out.println(updatedList.size());

		printMemory();
	}

	private void printMemory() {
		Runtime rt = Runtime.getRuntime();
		long total = rt.totalMemory() / 1024 / 1024;
		long free = rt.freeMemory() / 1024 / 1024;
		String format = String.format("Total: %s mb, Free: %s , Usage: %s ,  mb", total, free, total - free);
		System.out.println(format);
	}

	private void insertManyEvents(int count) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		for (int i = 0; i < count; i++) {
			Event object = new Event("very long " +
					"name of this event." + Math.random() +
					" very long name of this event" +
					". very long name " + i +
					"of this event. Event_" + i, new Date());
			object.setTopic("very long topic of this event. " +
					"very long topic of this event. " + i +
					"very long topic of this event.");
			session.save(object);
		}
		session.getTransaction().commit();
		session.close();
	}

	private void insertManyProducts(int count) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		for (int i = 0; i < count; i++) {
			Product object = new Product();
			object.setB((long) (Math.random() * 100000));
			session.save(object);
		}
		session.getTransaction().commit();
		session.close();
	}
}
