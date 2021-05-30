package by.train.model.several.assotiations1;

import by.train.model.several.assotiations.Author;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "A1_AuthorTransient")
public class AuthorBookTransient implements Author {
	@Id
	@Column(name = "a1_ID")
	Long id;
	String name;
	@Transient
	Set<BookManyToOne> books = new HashSet<BookManyToOne>();

	public AuthorBookTransient() {
	}



	public AuthorBookTransient(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<BookManyToOne> getBooks() {
		return books;
	}

	public void setBooks(Set<BookManyToOne> books) {
		this.books = books;
	}

	public void addBook(BookManyToOne book1) {
		books.add(book1);
		book1.setAuthor(this);
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + "]";
	}

}
