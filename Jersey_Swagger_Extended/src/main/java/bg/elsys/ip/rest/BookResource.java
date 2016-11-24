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
@Api("books")
public class BookResource {

	@GET
	@ApiOperation(value = "get list of users", response = User.class, responseContainer = "List")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBooks(@QueryParam("name") final String name,
							 @QueryParam("authorName") final String authorName,
							 @QueryParam("genre") final String genre,
							 @QueryParam("yearIssue") final int yearIssue) {
		
		List<Book> Books = BookData.getData().getBookData();
		if(name != null && !("".equals(name))){
			Books = Filter.filterName(name, Books);
		}
		
		if(authorName != null && !("".equals(authorName))){
			Books = Filter.filterAuthor(authorName, Books);
		}
		
		if(genre != null && !("".equals(genre))){
			Books = Filter.filterGenre(genre, Books);
		}
		
		if(yearIssue >= 0){
			Books = Filter.filterYearIssue(yearIssue, Books);
		}
		return Response.ok(Books).build();
	}

	@POST
	@ApiOperation(value = "create new user", response = User.class)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createBook(Book book) {	
		BookData.getData().addBook(book);
		return Response.status(Status.CREATED).build();
	}
}
