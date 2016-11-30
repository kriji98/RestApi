package bg.elsys.ip.rest.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Book {
	
	
	private static int idCount = 0;
	@ApiModelProperty(value = "shows ID for the book", example = "5")
	private int id;
	@ApiModelProperty(value = "shows the name of the book", example = "Under the yoke")
	private String name;
	@ApiModelProperty(value = "shows the author's name of the book", example = "Ivan Vazov")
	private String authorName;
	@ApiModelProperty(value = "shows the genre of the book", example = "Novel")
	private String genre;
	@ApiModelProperty(value = "shows year of issue for the book", example = "1888")
	private int yearIssue;

	public Book() {
		this("", "", "", 0);
	}

	public Book(String name, String authorName, String genre,
			int yearIssue) {
		super();
		idCount++;
		this.id = idCount;
		this.name = name;
		this.authorName = authorName;
		this.genre = genre;
		this.yearIssue = yearIssue;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getYearIssue() {
		return yearIssue;
	}

	public void setYearIssue(int yearIssue) {
		this.yearIssue = yearIssue;
	}

}
