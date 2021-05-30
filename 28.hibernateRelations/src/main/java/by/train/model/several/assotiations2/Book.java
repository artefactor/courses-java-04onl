package by.train.model.several.assotiations2;

import javax.persistence.*;

@Entity
@Table(name = "B2_BOOK")
public class Book implements by.train.model.several.assotiations.Book {
	@Id
	@Column(name = "iD")
	Long id;
	String title;

	public Book() {
	}

	public Book(long id, String title) {
		this.id = id;
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + "]";
	}

}
