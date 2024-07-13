package com.example.a2024b_integrative_client.model.miniappCommand;

public class ObjectId {
	private String superapp;
	private String id;
	
	public ObjectId() {}

	public ObjectId(String superapp, String internalObjectId) {
		this.superapp = superapp;
		this.id = internalObjectId;
	}

	public String getSuperapp() {
		return superapp;
	}

	public void setSuperapp(String superapp) {
		this.superapp = superapp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "SuperAppObjectIdBoundary [superapp=" + superapp + ", internalObjectId=" + id + "]";
	}

	
}
