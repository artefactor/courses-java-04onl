package train.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Event{");
		sb.append("id=").append(id);
		sb.append(", title='").append(title).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
