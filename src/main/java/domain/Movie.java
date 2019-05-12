package domain;

import java.util.ArrayList;
import java.util.List;

public class Movie {

	private int id;
	private String title;
	private String info;
	private List<Comment> comment;
	private ArrayList<Integer> grade = new ArrayList<Integer>();
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getInfo() {
		return info;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}
	
	public List<Comment> getComment(){
		return comment;
	}
	
	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	
	public float getGrade(){
		float avg = 0;
		int total = 0;
		for(int i = 0; i<grade.size(); i++)
			total = total+grade.get(i);
		avg = total/grade.size();
		return avg;
	}
	
	public void addGrade(int gradeValue) {
		grade.add(gradeValue);
	}
}
