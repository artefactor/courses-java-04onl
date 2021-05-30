package by.train.model.several.assotiations;

public interface Book {
	default Author getAuthor() {
		return null;
	}
}
