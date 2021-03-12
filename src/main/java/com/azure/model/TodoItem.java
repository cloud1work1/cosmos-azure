package com.azure.model;

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;

@Document
public class TodoItem {

	private String id;
	private String description;
	private String owner;
	private boolean finished;
	
	
	
	public TodoItem() {
		super();
	}
	
	
	public TodoItem(String id, String description, String owner, boolean finished) {
		super();
		this.id = id;
		this.description = description;
		this.owner = owner;
		this.finished = finished;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public boolean isFinished() {
		return finished;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	
	
}
