package com.citrix.saphosynergy.model;

public class JiraBoard {
	
	private int id;
    private String self;
    private String name;
    private String type;
    private JiraBoardLocation location;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSelf() {
		return self;
	}
	public void setSelf(String self) {
		this.self = self;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public JiraBoardLocation getLocation() {
		return location;
	}
	public void setLocation(JiraBoardLocation location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "JiraBoard [id=" + id + ", self=" + self + ", name=" + name + ", type=" + type + ", location=" + location
				+ "]";
	}
    
	
    

}
