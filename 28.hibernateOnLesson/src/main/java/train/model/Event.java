package train.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "lesson")
public class Event implements IEntity {
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	Long id;

	@Column(name = "lesson_name")
	String title;

	@Column(name = "lesson_to")
	String topic;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EVENT_DATE")
	private Date date;

	public Event() {
	}

	public Event(String title, Date date) {
		this.title = title;
		this.date = date;
	}

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Event{");
		sb.append("id=").append(id);
		sb.append(", title='").append(title).append('\'');
		sb.append(", topic='").append(topic).append('\'');
		sb.append(", date=").append(date);
		sb.append('}');
		return sb.toString();
	}
}
