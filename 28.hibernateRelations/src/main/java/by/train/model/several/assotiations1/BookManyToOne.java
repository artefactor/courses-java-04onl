package by.train.model.several.assotiations1;

import by.train.model.several.assotiations.Book;

import javax.persistence.*;

@Entity
@Table(name = "B1_BOOK_many_to_one")
public class BookManyToOne implements Book {
	@Id
	@Column(name = "iD")
	Long id;
	String title;
	@ManyToOne(
			optional = false
			, fetch = FetchType.LAZY,   // in this way not working for this type of association :(
			cascade = {CascadeType.ALL}
	)
	AuthorBookTransient theAuthor;

	public BookManyToOne() {
	}

	public BookManyToOne(long id, String title) {
		this.id = id;
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AuthorBookTransient getAuthor() {
		return theAuthor;
	}

	public void setAuthor(AuthorBookTransient author) {
		this.theAuthor = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + "]";
	}

}
