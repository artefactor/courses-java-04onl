package by.train.model.one;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.GenericGenerator;

@Entity
@NamedQueries({
		@NamedQuery(
				name = "findUsersByName",
				query = "select u from User u where u.name like :name"
		),
})
public class User {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "USER_ID")
	private String id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PASS")
	private String password;

	public User(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
