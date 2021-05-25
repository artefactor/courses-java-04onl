package train.dao;

import train.model.Event;

public class EventDao extends AbstractDao<Event> {

	protected Class<Event> getEntityClass() {
		return Event.class;
	}
}
