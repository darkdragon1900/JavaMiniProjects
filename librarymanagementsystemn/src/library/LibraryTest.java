package library;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryTest {
	public static void main(String[] args) {
		// Create books
		Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "Classic");
		Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "Classic");
		Book book3 = new Book("1984", "George Orwell", "Dystopian");
		Member member1 = new Member("John Doe", "M101");
		Member member2 = new Member("Jane Smith", "M202");
		Library library = new Library();
		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		library.addMember(member1);
		library.addMember(member2);
		Member member = null;
		Book book;
		Transaction transaction = new Transaction();
		Book resultBook;
		Scanner scanner = new Scanner(System.in);
		boolean exit = true;
		int ch;

		while (exit) {
			System.out.println("-------Library-------");
			System.out.println("1. Book");
			System.out.println("2. Member");
			System.out.println("3. To Generate (Borrow List and Transaction Record)");
			System.out.println("4. Exit");

			ch = scanner.nextInt();
			boolean exit2 = true;
			switch (ch) {
			case 1: {

				while (exit2) {
					System.out.println("-------Books-------");
					System.out.println("1. Add Book");
					System.out.println("2. Remove Book");
					System.out.println("3. Update Book");
					System.out.println("4. Search");
					System.out.println("5. Display All Books");
					System.out.println("6. Exit");
					int chh = scanner.nextInt();

					switch (chh) {
					case 1: {
						System.out.println("To Add Book please enter following Details");
						System.out.println();

						book = Input.getData();

						if (book == null) {
							System.out.println("Enter valid inputs....");
						} else {
							System.out.println("Successfull");
							library.addBook(book);
						}
						System.out.println();
						break;
					}
					case 2: {
						scanner.nextLine();
						System.out.println("To Remove Book please enter following Details");
						System.out.println("Enter the title of book");
						String title = scanner.nextLine();
						library.removeBook(title);
						System.out.println();
						break;
					}
					case 3: {

						scanner.nextLine();
						System.out.println("To Update Book please enter following Details");
						System.out.println("Enter the ID(Title) of book");
						String title = scanner.nextLine();
						Book updateBook;
						updateBook = Input.getData();
						if (updateBook == null) {
							System.out.println("Enter valid inputs....");
						} else {
							library.updateBook(title, updateBook);
						}
						System.out.println();
						break;
					}
					case 4: {
						boolean exit3 = true;
						int choice = 0;
						do {
							System.out.println("-------------Search-------------");
							System.out.println("1. Search Book By Title");
							System.out.println("2. Search Book By Author");
							System.out.println("3. Search Book By Category");
							System.out.println("0. Exit");
							choice = scanner.nextInt();

							switch (choice) {
							case 1: {
								scanner.nextLine();
								System.out.println("To Search Book By Title please enter following Details");
								System.out.println("Enter the ID(Title) of book");
								String title = scanner.nextLine();
								resultBook = library.searchBookByTitle(title);
								if (resultBook != null) {
									System.out.println("Title     : " + resultBook.getTitle());
									System.out.println("Author    : " + resultBook.getAuthor());
									System.out.println("Category  : " + resultBook.getCategory());
									System.out.println("Available : " + resultBook.isAvailability());
								} else {
									System.out.println("Try again");
								}
								break;
							}
							case 2: {
								scanner.nextLine();
								System.out.println("To Search Book By Author please enter following Details");
								System.out.println("Enter the Author of book");
								String author = scanner.nextLine();
								ArrayList<Book> result = new ArrayList<>();
								result = library.searchBookByAuthor(author);
								Boolean test = result.isEmpty();
								if (!test) {
									for (Book book4 : result) {
										System.out.println("Title     : " + book4.getTitle());
										System.out.println("Author    : " + book4.getAuthor());
										System.out.println("Category  : " + book4.getCategory());
										System.out.println("Available : " + book4.isAvailability());
									}
								} else {
									System.out.println("Try again");
								}
								break;
							}

							case 3: {
								scanner.nextLine();
								System.out.println("To Search Book By Category please enter following Details");
								System.out.println("Enter the Category of book");
								String category = scanner.nextLine();
								ArrayList<Book> result = new ArrayList<>();
								result = library.searchBookByCategory(category);
								Boolean test = result.isEmpty();
								if (!test) {
									for (Book book4 : result) {
										System.out.println("Title     : " + book4.getTitle());
										System.out.println("Author    : " + book4.getAuthor());
										System.out.println("Category  : " + book4.getCategory());
										System.out.println("Available : " + book4.isAvailability());
									}
								} else {
									System.out.println("Try again");
								}
								break;
							}
							case 0: {
								exit3 = false; // Set flag to exit outer loop
								System.out.println("Exiting");
								break;
							}
							default:
								System.out.println("Invalid Data...");
								break;
							}

						} while (exit3);

						break;
					}
					case 5: {
						library.displayAllBooks();
						break;
					}
					case 6: {
						System.out.println("Exiting....");
						exit2 = false;
						break;
					}
					default:
						System.out.println("Invalid choice....");
					}
				}

				break;
			}
			case 2: {
				Boolean test = true;
				scanner.nextLine();
				while (test) {
					System.out.println("1. Add Member");
					System.out.println("2. Remove Member");
					System.out.println("3. Update Member");
					System.out.println("4. Borrow Book");
					System.out.println("5. Return Book");
					System.out.println("6. Display All Members");
					System.out.println("7. Exit");
					int choice = scanner.nextInt();

					switch (choice) {
					case 1:
						System.out.println("To Add Member please enter following Details");
						System.out.println();

						member = Input.name();

						if (member == null) {
							System.out.println("Enter valid inputs....");
						} else {
							System.out.println("Successfull");
							library.addMember(member);
						}
						System.out.println();
						break;

					case 2:
						scanner.nextLine();
						System.out.println("To Remove Member please enter following Details");
						System.out.println("Enter the Member ID");
						String memberID = scanner.nextLine();

						library.removeMember(memberID);

						break;

					case 3:
						System.out.println("To Add Member please enter following Details");
						System.out.println("Enter Member ID");
						scanner.nextLine();
						String memberId = scanner.next();
						member = Input.name();

						if (member == null) {
							System.out.println("Enter valid inputs....");
						} else {
							System.out.println("Successfull");
							library.updateMember(memberId, member);
						}
						System.out.println();
						break;

					case 4:
						System.out.println("To Borrow Book please enter following Details");
						System.out.println("Enter Member ID");
						memberId = scanner.next();
						scanner.nextLine();
						System.out.println("Enter the ID(Title) of book");
						String title = scanner.nextLine();
						boolean d = library.borrowBook(memberId, title);
						if (d == true) {
							transaction.recordBorrowTransaction(memberId, title);
							System.out.println("Borrow Book successfull");
						} else {
							System.out.println("Invalid member ID or book ID, or book is already available.");
						}

						break;

					case 5:
						System.out.println("To Return Book please enter following Details");
						System.out.println("Enter Member ID");
						memberId = scanner.next();
						scanner.nextLine();
						System.out.println("Enter the ID(Title) of book");
						title = scanner.nextLine();
						d = library.returnBook(memberId, title);
						if (d == true) {
							transaction.recordReturnTransaction(memberId, title);
							System.out.println("Return Book successfull");
						} else {
							System.out.println("Invalid member ID or book ID, or book is already available.");
						}
						break;

					case 6:
						library.displayAllMembers();
						break;

					case 7:
						test = false;
						System.out.println("Exiting...");
						break;
					default:
						System.out.println("INVALID INPUT...");
						break;
					}

				}
				break;
			}
			case 3: {
				System.out.println("-----------------------Borrowed Books List-----------------------");
				ArrayList<Book> borrowedBooks = member.getBorrowedBooks();
				for (Book book4 : borrowedBooks) {
					System.out.println("Title     : " + book4.getTitle());
					System.out.println("Author    : " + book4.getAuthor());
					System.out.println("Category  : " + book4.getCategory());
					System.out.println("Available : " + book4.isAvailability());
				}
				System.out.println("------------------------Transaction Record------------------------");
				transaction.displayTransactions();

				break;
			}
			case 4: {
				System.out.println("Exiting....");
				exit = false;
				break;
			}
			default:
				System.out.println("Invalid choice....");
			}

		}

	}
}
