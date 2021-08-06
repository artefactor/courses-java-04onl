package by.tms.springmvctutorial;

public class Greeting {
	private final String name;
	private final String original;
	public Greeting(String name) {
		this.name = name;
		original = "Original value for Alexander";
	}

	public String getName() {
		return name;
	}

	public String getOriginal() {
		return original;
	}
}
