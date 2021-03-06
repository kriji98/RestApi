package bg.elsys.ip.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import bg.elsys.ip.rest.data.Book;
import bg.elsys.ip.rest.data.BookData;
import bg.elsys.ip.rest.data.Filter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/books")
@Api("book")
public class BookResource {
	
	@GET
	@ApiOperation(value = "get list of books", response = Book.class, responseContainer = "List")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBooks(@QueryParam("name") final String name,
			@QueryParam("authorName") final String authorName,
			@QueryParam("genre") final String genre,
			@QueryParam("yearIssue") final int yearIssue,
			@QueryParam("bookNumber") final int bookNumber,
			@QueryParam("newPage") final int newPage) {

		List<Book> books = BookData.getData().getBookData();

		if (name != null && !("".equals(name))) {
			books = Filter.filterName(name, books);
		}

		if (authorName != null && !("".equals(authorName))) {
			books = Filter.filterAuthor(authorName, books);
		}

		if (genre != null && !("".equals(genre))) {
			books = Filter.filterGenre(genre, books);
		}

		if (yearIssue > 0) {
			books = Filter.filterYearIssue(yearIssue, books);
		}
		
		System.out.println(newPage);
		System.out.println(bookNumber);
		

		int start = Math.min(bookNumber * (newPage - 1), books.size());
		int end = Math.min(bookNumber * newPage, books.size());

		books = books.subList(start, end);
		System.out.println(newPage);
		System.out.println(bookNumber);
		return Response.ok(books).build();
	}

	@POST
	@ApiOperation(value = "create new book", response = Book.class)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createBook(Book book) {
		BookData.getData().addBook(book);
		return Response.status(Status.CREATED).build();
	}
}
