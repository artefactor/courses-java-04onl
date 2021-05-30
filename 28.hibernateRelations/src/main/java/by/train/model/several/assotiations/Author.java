package by.train.model.several.assotiations;

import java.util.Set;

public interface Author<B extends Book> {
	Set<B> getBooks();

	Long getId();
}
