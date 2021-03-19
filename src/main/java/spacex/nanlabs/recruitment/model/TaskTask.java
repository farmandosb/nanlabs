package spacex.nanlabs.recruitment.model;

import org.apache.commons.lang3.RandomStringUtils;


public class TaskTask {

	String title = "";
	String description = "";
	Tasktype type = null;
	CategoryEnum[] category = null;
	
	public TaskTask(Tasktype tasktype, String title, String description) {
		this.type = tasktype;
		this.title = title;
		this.description = description;
	}
	
	public TaskTask(Tasktype tasktype, String description) {
		this.type = tasktype;
		this.description = description;
		this.title = String.format("bug-%s-%03d", getRandomAlphanumericString(), getRandomNumber(0, 999));
	}
	

	
	public TaskTask(Tasktype tasktype, String title, CategoryEnum[] category) {
		this.type = tasktype;
		this.title = title;
		this.category = category;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public Tasktype getType() {
		return type;
	}
	public void setType(Tasktype type) {
		this.type = type;
	}
	public String getRandomAlphanumericString() {
	    String generatedString = RandomStringUtils.randomAlphanumeric(10);

	   
	    return generatedString;
	}
	
	public int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
	
	@Override
	public String toString() {
		return "Task [Type="+type+ ", title=" + title + ", description=" + description + "]";
	}
	
	
}
