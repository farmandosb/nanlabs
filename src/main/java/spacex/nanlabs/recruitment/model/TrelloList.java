package spacex.nanlabs.recruitment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TrelloList {
	String id;
	String name;
	boolean closed;
	String idBoard;
	
	@JsonIgnore
	String pos;
	
	
	public TrelloList() {
		super();
	}


	public TrelloList(String id, String name, boolean closed, String idBoard) {
		super();
		this.id = id;
		this.name = name;
		this.closed = closed;
		this.idBoard = idBoard;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public boolean isClosed() {
		return closed;
	}


	public void setClosed(boolean closed) {
		this.closed = closed;
	}


	public String getIdBoard() {
		return idBoard;
	}


	public void setIdBoard(String idBoard) {
		this.idBoard = idBoard;
	}


	@Override
	public String toString() {
		return "TrelloList [id=" + id + ", name=" + name + ", closed=" + closed + ", idBoard=" + idBoard + "]";
	}
	
	
	
	
	
	


}
