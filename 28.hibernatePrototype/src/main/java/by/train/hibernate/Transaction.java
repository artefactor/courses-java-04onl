package by.train.hibernate;

public class Transaction {
	private final Session session;

	public Transaction(Session session) {
		this.session = session;
	}

	/**
	 * когда коммитим транзакцию - записываем все несохраненные изменения в БД
	 *
	 * Commit the current resource transaction,
	 * writing any unflushed changes to the database.
	 * @throws IllegalStateException if <code>isActive()</code> is false
	 * @throws RollbackException if the commit fails
	 */
	public void commit() {
		session.flush();
	}
}
