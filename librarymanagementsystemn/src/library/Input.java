package library;

import java.util.Scanner;

public class Input {

	static int id = 1;

	public static Member name() {
		Scanner scanner = new Scanner(System.in);
		Validation validation = new Validation();
		System.out.println("Enter Name of Member");
		String name = scanner.nextLine();
		if (validation.checkName(name)) {
			int idd = id++;
			String memberId = "M00" + idd;
			Member member = new Member(name, memberId);
			return member;
		} else {
			return null;
		}
	}

	public static Book getData() {
		Scanner scanner = new Scanner(System.in);
		Validation validation = new Validation();

		System.out.println("Enter title of the book");
		String title = scanner.nextLine();

		System.out.println("Enter the name of author");
		String author = scanner.nextLine();

		System.out.println("Enter category of the book");
		String category = scanner.next();

		if (validation.checkAll(title, author, category)) {
			Book book = new Book(title, author, category);
			return book;
		} else {
			return null;
		}

	}

}

