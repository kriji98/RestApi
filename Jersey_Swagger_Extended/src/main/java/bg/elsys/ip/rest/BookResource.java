package bg.elsys.ip.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import bg.elsys.ip.rest.data.Book;
import bg.elsys.ip.rest.data.BookData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/books")
@Api("books")
public class BookResource {

	@GET
	@ApiOperation(value = "get list of users", response = User.class, responseContainer = "List")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBooks() {
		return Response.ok(BookData.getData().getBookData()).build();
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
