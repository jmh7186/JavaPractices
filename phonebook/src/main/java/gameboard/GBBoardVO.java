package gameboard;

public class GBBoardVO {
	private int id;
	private String title;
	private String content;
	private String author;
	private String date;
	private int g_id;
	private int s_id;

	public GBBoardVO() {
		// TODO Auto-generated constructor stub
	}

	public GBBoardVO(int id, String title, String content, String author, String date, int g_id, int s_id) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
		this.date = date;
		this.g_id = g_id;
		this.s_id = s_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getG_id() {
		return g_id;
	}

	public void setG_id(int g_id) {
		this.g_id = g_id;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	@Override
	public String toString() {
		return "GBBoardVO [id=" + id + ", title=" + title + ", content=" + content + ", author=" + author + ", date="
				+ date + ", g_id=" + g_id + ", s_id=" + s_id + "]";
	}

}
