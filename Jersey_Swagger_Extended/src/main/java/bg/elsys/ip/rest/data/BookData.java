package bg.elsys.ip.rest.data;

import java.util.ArrayList;
import java.util.List;

public class BookData {
	private static BookData data = null;
	private List<Book> bookData;

	public BookData() {
		bookData = new ArrayList<>();
		bookData.add(new Book("The mortal instruments", " Cassandra Clare", "	Fantasy", 2007));
		bookData.add(new Book("Tha fault in out stars", "John green", "Young adult novel", 2012));
		bookData.add(new Book("Let it snow", "John Green", "Young Adult Fiction", 2011));
		bookData.add(new Book("Beautiful creatures", "Kami Garcia", "fantasy", 2013));
		
		bookData.add(new Book("Beautiful creatures", "Kami Garcia", "fantasy", 2013));
		bookData.add(new Book("Beautiful creatures", "Kami Garcia", "ggggggg", 1999));
		bookData.add(new Book("Beautiful creatures", "Kami Garcia", "fantasy", 2012));
		bookData.add(new Book("abvgdejzi", "Kami Garcia", "fantasy", 2010));
		bookData.add(new Book("Beautiful creatures", "Kami Garcia", "fantasy", 2011));
		bookData.add(new Book("Beautiful creatures", "Kami Garcia", "ggggggg", 2015));
		bookData.add(new Book("Beautiful creatures", "Kami Garcia", "fantasy", 2016));
		bookData.add(new Book("Beautiful creatures", "Kami Garcia", "fantasy", 2009));
		bookData.add(new Book("Beautiful creatures", "Kami Garcia", "fantasy", 2003));
		bookData.add(new Book("Beautiful creatures", "Kami Garcia", "fantasy", 1998));
		bookData.add(new Book("Beautiful creatures", "Kami Garcia", "fantasy", 1997));
		bookData.add(new Book("Beautiful creatures", "Kami Garcia", "fantasy", 1995));
		bookData.add(new Book("Beautiful creatures", "Kami Garcia", "fantasy", 1896));
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
