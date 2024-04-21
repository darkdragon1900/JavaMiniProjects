package library;

public class Validation {

	public boolean checkTitle(String title) {
		if (title.matches("[A-Za-z0-9 ]+") || title.matches("[A-Za-z ]+") || title.matches("[A-Z]+")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkAuthor(String author) {
		if (author.matches("[A-Za-z ]+") || author.matches("[a-z ]+") || author.matches("[A-Z ]+")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkCategory(String category) {
		if (category.matches("[A-Za-z]+") || category.matches("[A-Z]+") || category.matches("[A-Z]+")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkAll(String title,String author,String category) {
		if (!checkTitle(title)) {
			return false;
		} else if (!checkAuthor(author)) {
			return false;
		} else if (!checkCategory(category)) {
			return false;
		} else {
			return true;
		}
	}

	public boolean checkName(String name) {
		if (name.matches("[A-Za-z]+") || name.matches("[A-Z]+") || name.matches("[A-Z]+")) {
			return true;
		} else {
			return false;
		}
	}
	
}
