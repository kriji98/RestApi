package bg.elsys.ip.rest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class User {
	
	@ApiModelProperty(required = true)
	private int id;
	@ApiModelProperty(value = "This will show the name of the user", example = "Pesho")
	private String name;

	public User() {
	}

	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
