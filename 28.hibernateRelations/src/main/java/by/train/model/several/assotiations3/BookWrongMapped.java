package by.train.model.several.assotiations3;

import by.train.model.several.assotiations.Book;

import javax.persistence.*;

@Entity
@Table(name = "B3_BookWrongMapped")
public class BookWrongMapped implements Book {
	@Id
	@Column(name = "iD")
	Long id;
	String title;

	@ManyToOne(
			optional = false
			, fetch = FetchType.LAZY,   // in this way not working for this type of association :(
			cascade = {CascadeType.ALL}
	)

	AuthorWrongMapped theAuthor;

	public BookWrongMapped() {
	}

	public BookWrongMapped(long id, String title) {
		this.id = id;
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AuthorWrongMapped getAuthor() {
		return theAuthor;
	}

	public void setAuthor(AuthorWrongMapped author) {
		this.theAuthor = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + "]";
	}

}
