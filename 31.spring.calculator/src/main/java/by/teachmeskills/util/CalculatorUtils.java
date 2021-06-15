package by.teachmeskills.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class CalculatorUtils {
	private CalculatorUtils() {
	}

	public static int readIntValue(String message) {
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

	public static String readStringValue(String message) {
		String result;
		while (true) {
			final Scanner scanner = new Scanner(System.in);
			System.out.println(message);
			result = scanner.nextLine();
			break;
		}
		return result;
	}

	static public boolean readBooleanValue(String message) {
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
