package bg.elsys.ip.rest.data;

import java.util.ArrayList;
import java.util.List;

public class Filter {

	public static List<Book> filterName(String name, List<Book> currentList) {
		List<Book> helpList = new ArrayList<>();

		for (Book book : currentList) {
			if (book.getName().equals(name)) {
				helpList.add(book);
			}
		}

		return helpList;
	}

	public static List<Book> filterAuthor(String authorName, List<Book> currentList) {
		List<Book> helpList = new ArrayList<>();

		for (Book book : currentList) {
			if (book.getAuthorName().equals(authorName)) {
				helpList.add(book);
			}
		}

		return helpList;
	}

	public static List<Book> filterGenre(String genre, List<Book> currentList) {
		List<Book> helpList = new ArrayList<>();

		for (Book book : currentList) {
			if (book.getGenre().equals(genre)) {
				helpList.add(book);
			}
		}

		return helpList;
	}

	public static List<Book> filterYearIssue(int yearIssue, List<Book> currentList) {
		List<Book> helpList = new ArrayList<>();

		for (Book book : currentList) {
			if (book.getYearIssue() == yearIssue) {
				helpList.add(book);
			}
		}

		return helpList;
	}
}
