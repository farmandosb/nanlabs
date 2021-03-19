package spacex.nanlabs.recruitment.service;

import org.springframework.http.ResponseEntity;

import spacex.nanlabs.recruitment.model.TrelloLabel;
import spacex.nanlabs.recruitment.model.TrelloList;
import spacex.nanlabs.recruitment.model.TrelloMember;

public interface  ITaskService {

	public TrelloLabel[]  getLabels();
	public TrelloList[] getLists();
	public TrelloMember[] getMembers();
	
	public TrelloList createList(String name);
	public TrelloLabel createLabel(String name);
	
	

	public ResponseEntity<String> createCard(String idList, String name, String desc, String[] idMembers, String[] idLabels);
}
