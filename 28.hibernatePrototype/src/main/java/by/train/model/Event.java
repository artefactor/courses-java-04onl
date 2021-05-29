package by.train.model;


public class Event implements IEntity {
	private Long id;

	private String title;

	private String topic;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Event{");
		sb.append("id=").append(id);
		sb.append(", title='").append(title).append('\'');
		sb.append(", topic='").append(topic).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
