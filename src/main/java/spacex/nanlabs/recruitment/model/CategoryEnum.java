package spacex.nanlabs.recruitment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CategoryEnum {
	
	@JsonProperty("Maintenance")
	MAINTENANCE("Maintenance"), 
	
	@JsonProperty("Resarch")
	RESEARCH("Research"), 
	
	@JsonProperty("Test")
	TEST("Test"),
	
	@JsonProperty("Bug")
	BUG("Bug");
	
private String name;
	
	private CategoryEnum(String name) {
        this.name=name;
    }
	@JsonValue
	public String getName() {
		return name;
	}

}
