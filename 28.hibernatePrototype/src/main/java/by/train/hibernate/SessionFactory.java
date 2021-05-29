package by.train.hibernate;

public class SessionFactory {
	private Session currentSession;

	public Session getCurrentSession() {
		// проверки на Closed нет в хибернейте. Здесь она для упрощения логики примера.
		if (currentSession == null || currentSession.isClosed()) {
			currentSession = openSession();
		}
		return currentSession;
	}

	public Session openSession() {
		return new Session();
	}

	public void close() {
		if (currentSession != null) {
			currentSession.close();
		}
		currentSession = null;
	}
}
