package library;

import java.util.ArrayList;
import java.util.HashMap;

public class Library {
	private HashMap<String, Book> books;
	private HashMap<String, Member> members;

	public Library() {
		this.books = new HashMap<>();
		this.members = new HashMap<>();
	}

	public void addBook(Book book) {
		books.put(book.getTitle(), book);
	}

	public void removeBook(String bookId) {
		if (books.containsKey(bookId)) {
			books.remove(bookId);
			System.out.println("Remove successfull");
		} else {
			System.out.println("Unable to find book Or Enter correct title...");
		}
	}

	public void updateBook(String bookId, Book updatedBook) {
		boolean test = books.containsKey(bookId);
		if (test) {
			books.put(bookId, updatedBook);
			System.out.println("Update successfull");
		} else {
			System.out.println("Unsuccessfull");
		}
	}

	public Book searchBookByTitle(String title) {
		boolean test = books.containsKey(title);
		if (test) {
			System.out.println("Book found");
			return books.get(title);
		} else {
			System.out.println("Book not found");
			return null;
		}
	}

	public ArrayList<Book> searchBookByAuthor(String author) {
		ArrayList<Book> result = new ArrayList<>();
		for (Book book : books.values()) {
			if (book.getAuthor().equals(author)) {
				result.add(book);
			}
		}
		return result;
	}

	public ArrayList<Book> searchBookByCategory(String category) {
		ArrayList<Book> result = new ArrayList<>();
		for (Book book : books.values()) {
			if (book.getCategory().equals(category)) {
				result.add(book);
			}
		}
		return result;
	}

	public void addMember(Member member) {
		members.put(member.getMemberId(), member);
	}

	public void removeMember(String memberId) {
		boolean test = members.containsKey(memberId);
		if (test) {
			members.remove(memberId);
			System.out.println("Update successfull");
		} else {
			System.out.println("Enter Valid Member ID");
		}
	}

	public void updateMember(String memberId, Member updatedMember) {
		if (members.containsKey(memberId)) {
			// Get the old member associated with memberId
			Member oldMember = members.get(memberId);

			// Remove the old key-value pair from the HashMap
			members.remove(memberId);

			// Add the new key-value pair with updated memberId
			members.put(updatedMember.getMemberId(), updatedMember);
		} else {
			System.out.println("Member Id no found");
		}
	}

	public Member getMemberById(String memberId) {
		return members.get(memberId);
	}

	public boolean borrowBook(String memberId, String bookId) {
		Member member = members.get(memberId);
		Book book = books.get(bookId);
		if (member != null && book != null && book.isAvailability()) {
			member.borrowBook(book);
			book.setAvailability(false);
			return true;
		} else {
			return false;
		}
	}

	public boolean returnBook(String memberId, String bookId) {
		Member member = members.get(memberId);
		Book book = books.get(bookId);
		if (member != null && book != null && !book.isAvailability()) {
			member.returnBook(book);
			book.setAvailability(true);

			return true;
		} else {

			return false;
		}
	}

	public void displayAllBooks() {
		System.out.println("All Books:");
		for (Book book : books.values()) {
			System.out.println("Title     : " + book.getTitle());
			System.out.println("Author    : " + book.getAuthor());
			System.out.println("Category  : " + book.getCategory());
			System.out.println("Available : " + book.isAvailability());

			System.out.println();
		}
	}

	public void displayAllMembers() {
		System.out.println("All Members:");
		for (Member member : members.values()) {
			System.out.println("Name: " + member.getName() + "\nID: " + member.getMemberId());
		}
	}
}
