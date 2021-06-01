package by.train.model.several.assotiations5;

import by.train.model.several.assotiations.Author;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "A5_AuthorJoinTable")
public class AuthorJoinTable implements Author {
	@Id
	@Column(name = "aa_ID")
	Long id;
	String name;

	@OneToMany(fetch = FetchType.EAGER,
			//mappedBy = "theAuthor",
			cascade = {CascadeType.ALL}
	)
	@JoinTable(name = "A5_Author_Book",
			joinColumns = @JoinColumn(name = "author_id"),
			inverseJoinColumns = @JoinColumn(name = "books_id"))
	Set<BookJoinTable> books = new HashSet<BookJoinTable>();

	//@OrderColumn(name = )
	List<BookJoinTable> booksList;

	public AuthorJoinTable() {
	}


	public AuthorJoinTable(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<BookJoinTable> getBooks() {
		return books;
	}

	public void setBooks(Set<BookJoinTable> books) {
		this.books = books;
	}

	public void addBook(BookJoinTable book1) {
		books.add(book1);
		book1.setAuthor(this);
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + "]";
	}

}
