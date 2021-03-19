package spacex.nanlabs.recruitment.model;

import java.util.Arrays;

import org.apache.commons.lang3.RandomStringUtils;

public class BugTask extends ManagedTask implements ITrelloCard{
	
	String title="";
	String description="";
	String idList="";
	String[] idMembers = new String[0];
	String[] idLabels= new String[0];
	
	@Override
	public String getName() {
		
		return this.title;
	}
	@Override
	public void setName(String name) {
		this.title =String.format("bug-%s-%03d", getRandomAlphanumericString(), getRandomNumber(0, 999));
		
	}
	
	
	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return this.description;
	}
	@Override
	public void setDesc(String desc) {
		this.description = desc;
		
	}
	@Override
	public String getIdList() {
		
		return this.idList;
	}
	@Override
	public void setIdList(String idList) {
		this.idList = idList;
		
	}
	@Override
	public String[] getIdMembers() {
		// TODO Auto-generated method stub
		return this.idMembers;
	}
	@Override
	public void setIdMembers(String[] idMembers) {
		this.idMembers = idMembers;
		
	}
	@Override
	public String[] getIdLabels() {

		return this.idLabels;
	}
	@Override
	public void setIdLabels(String[] idLabels) {
		this.idLabels = idLabels;
		
	}
	
	
	@Override
	public String toString() {
		return "BugTask [title=" + title + ", description=" + description + ", idList=" + idList + ", idMembers="
				+ Arrays.toString(idMembers) + ", idLabels=" + Arrays.toString(idLabels) + "]";
	}
	public String getRandomAlphanumericString() {
	    String generatedString = RandomStringUtils.randomAlphanumeric(10);

	   
	    return generatedString;
	}
	
	public int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}
	
	
	
	
	
	
	
}