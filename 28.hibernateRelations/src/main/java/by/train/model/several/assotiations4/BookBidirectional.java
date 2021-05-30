package by.train.model.several.assotiations4;

import by.train.model.several.assotiations.Book;

import javax.persistence.*;

@Entity
@Table(name = "B4_BookBidirectional")
public class BookBidirectional implements Book {
	@Id
	@Column(name = "iD")
	Long id;
	String title;
	@ManyToOne(
			optional = false
			, fetch = FetchType.LAZY,   // in this way not working for this type of association :(
			cascade = {CascadeType.ALL}
	)

	AuthorBidirectional theAuthor;

	public BookBidirectional() {
	}

	public BookBidirectional(long id, String title) {
		this.id = id;
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AuthorBidirectional getAuthor() {
		return theAuthor;
	}

	public void setAuthor(AuthorBidirectional author) {
		this.theAuthor = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + "]";
	}

}
