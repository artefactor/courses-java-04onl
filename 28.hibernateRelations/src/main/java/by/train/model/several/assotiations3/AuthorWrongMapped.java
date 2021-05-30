package by.train.model.several.assotiations3;

import by.train.model.several.assotiations.Author;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "A3_AuthorWrongMapped")
public class AuthorWrongMapped implements Author {
	@Id
	@Column(name = "a3_ID")
	Long id;
	String name;

	@OneToMany(fetch = FetchType.EAGER)
	Set<BookWrongMapped> books = new HashSet<BookWrongMapped>();

	public AuthorWrongMapped() {
	}

	public AuthorWrongMapped(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<BookWrongMapped> getBooks() {
		return books;
	}

	public void setBooks(Set<BookWrongMapped> books) {
		this.books = books;
	}

	public void addBook(BookWrongMapped book1) {
		books.add(book1);
		book1.setAuthor(this);
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + "]";
	}

}
