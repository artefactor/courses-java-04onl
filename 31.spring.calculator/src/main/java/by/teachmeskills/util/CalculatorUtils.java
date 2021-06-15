package by.teachmeskills.util;

import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;

//TODO show final
@Component
public final class CalculatorUtils {
	private CalculatorUtils() {
	}

	public int readIntValue(String message) {
		while (true) {
			final Scanner scanner = new Scanner(System.in);
			System.out.println(message);
			try {
				return scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid input, expecting number");
			}
		}
	}

	public String readStringValue(String message) {
		String result;
		while (true) {
			final Scanner scanner = new Scanner(System.in);
			System.out.println(message);
			result = scanner.nextLine();
			break;
		}
		return result;
	}

	public boolean readBooleanValue(String message) {
		while (true) {
			final Scanner scanner = new Scanner(System.in);
			System.out.println(message);
			try {
				return scanner.nextBoolean();
			} catch (InputMismatchException e) {
				System.out.println("Invalid input, expecting boolean");
			}
		}
	}

}
