package spacex.nanlabs.recruitment.model;

import java.util.Arrays;

public class CommonTask extends ManagedTask implements ITrelloCard {
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
		this.title =name;
		
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
		return "CommonTask [title=" + title + ", description=" + description + ", idList=" + idList + ", idMembers="
				+ Arrays.toString(idMembers) + ", idLabels=" + Arrays.toString(idLabels) + "]";
	}
	
	
	
	
}