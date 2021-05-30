package by.train.model.several.assotiations2;

import by.train.model.several.assotiations.Author;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "A2_AuthorOneToMany")
public class AuthorOneToMany implements Author {
	@Id
	@Column(name = "a2_ID")
	Long id;
	String name;
	@OneToMany(fetch = FetchType.EAGER)
	Set<Book> books = new HashSet<Book>();

	public AuthorOneToMany() {
	}

	public AuthorOneToMany(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public void addBook(Book book1) {
		books.add(book1);
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + "]";
	}

}
