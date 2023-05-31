package ex230518;

public class BoardVO {
	private int bid;
	private String btitle;
	private String bauthor;
	private String bcontent;
	private String bdate;
	
	public BoardVO() {
		// TODO Auto-generated constructor stub
	}

	public BoardVO(int bid, String btitle, String bauthor, String bcontent, String bdate) {
		super();
		this.bid = bid;
		this.btitle = btitle;
		this.bauthor = bauthor;
		this.bcontent = bcontent;
		this.bdate = bdate;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBauthor() {
		return bauthor;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	@Override
	public String toString() {
		return "BoardVO [bid=" + bid + ", btitle=" + btitle + ", bauthor=" + bauthor + ", bcontent=" + bcontent
				+ ", bdate=" + bdate + "]";
	}
	
}
