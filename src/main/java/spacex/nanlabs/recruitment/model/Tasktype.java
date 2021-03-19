package spacex.nanlabs.recruitment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Tasktype {
	
	@JsonProperty("issue")
	ISSUE ("issue"),
	
	@JsonProperty("bug")
	BUG("bug"),
	
	@JsonProperty("task")
	TASK ("task");
	
	private String name;
	
	
	private Tasktype(String name) {
        this.name=name;
        
    }

	@JsonValue
	public String getName() {
		return name;
	}


	
}
