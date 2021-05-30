package by.train.model.several.assotiations5;

import by.train.model.several.assotiations.Author;
import by.train.model.several.assotiations.Book;

import javax.persistence.*;

@Entity
@Table(name = "B5_BookJoinTable")
public class BookJoinTable implements Book {
	@Id
	@Column(name = "iD")
	Long id;
	String title;

	@ManyToOne(
			optional = false
			, fetch = FetchType.LAZY,   // in this way not working for this type of association :(
			cascade = {CascadeType.ALL}
	)
	@JoinTable(name = "A5_Author_Book", joinColumns = @JoinColumn(name = "author_id"), inverseJoinColumns = @JoinColumn(name = "books_id"))
	AuthorJoinTable theAuthor;

	public BookJoinTable() {
	}

	public BookJoinTable(long id, String title) {
		this.id = id;
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AuthorJoinTable getAuthor() {
		return theAuthor;
	}

	public void setAuthor(AuthorJoinTable author) {
		this.theAuthor = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + "]";
	}

}
