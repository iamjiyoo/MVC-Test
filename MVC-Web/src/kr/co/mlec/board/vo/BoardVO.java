package kr.co.mlec.board.vo;

public class BoardVO {

	private int no;
	private String title;
	private String writer;
	private String content;
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	private String regDate;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public BoardVO() {
		super();
	}

	public BoardVO(String title, String writer) {
		super();
		this.title = title;
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	
}
