package domain;

public class Comment {
	
	private int id;
	private String content;
	private static int currentId = 1;
	
	public void setId() {
		this.id = currentId++;
	}
	
	public int getId() {
		return id;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

}
