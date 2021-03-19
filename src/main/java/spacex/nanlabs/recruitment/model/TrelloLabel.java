package spacex.nanlabs.recruitment.model;

import org.springframework.stereotype.Component;

@Component
public class TrelloLabel {
	String id;
	String idBoard;
	String name;
	String color;
	
	public TrelloLabel() {
		
	}

	public TrelloLabel(String id, String idBoard, String name, String color) {
		super();
		this.id = id;
		this.idBoard = idBoard;
		this.name = name;
		this.color = color;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdBoard() {
		return idBoard;
	}

	public void setIdBoard(String idBoard) {
		this.idBoard = idBoard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "TrelloLabel [id=" + id + ", idBoard=" + idBoard + ", name=" + name + ", color=" + color + "]";
	}
	
	
	
	
	

}
