package bg.elsys.ip.rest.data;

import java.util.ArrayList;
import java.util.List;

public class BookData {
	private static BookData data = null;
	private List<Book> bookData;

	public BookData() {
		bookData = new ArrayList<>();
		bookData.add(new Book("The mortal instruments", "JK", "genre", 2010));
		bookData.add(new Book("Tha fault in out stars", "Jhon green", "genre", 1999));
		bookData.add(new Book("Twilight", "GM", "genre", 2011));
		bookData.add(new Book("Let it snow", "GN", "genre", 1015));
	}

	public static BookData getData() {
		if (data == null) {
			data = new BookData();
		}

		return data;
	}

	public List<Book> getBookData() {
		return bookData;
	}

	public void addBook(Book book) {
		bookData.add(book);
	}

}
