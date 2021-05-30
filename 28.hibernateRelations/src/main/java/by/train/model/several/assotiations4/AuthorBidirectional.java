package by.train.model.several.assotiations4;

import by.train.model.several.assotiations.Author;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "A4_AuthorBidirectional")
public class AuthorBidirectional implements Author {
	@Id
	@Column(name = "a4_ID")
	Long id;
	String name;

	@OneToMany(fetch = FetchType.EAGER,
			mappedBy = "theAuthor",
			cascade = {CascadeType.ALL}
	)
	Set<BookBidirectional> books = new HashSet<BookBidirectional>();

	public AuthorBidirectional() {
	}

	public AuthorBidirectional(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<BookBidirectional> getBooks() {
		return books;
	}

	public void setBooks(Set<BookBidirectional> books) {
		this.books = books;
	}

	public void addBook(BookBidirectional book1) {
		books.add(book1);
		book1.setAuthor(this);
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + "]";
	}

}
