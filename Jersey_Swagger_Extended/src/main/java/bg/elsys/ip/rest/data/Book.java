package bg.elsys.ip.rest.data;

public class Book {

	private static int idCount = 0;
	private int id;
	private String name;
	private String authorName;
	private String genre;
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
