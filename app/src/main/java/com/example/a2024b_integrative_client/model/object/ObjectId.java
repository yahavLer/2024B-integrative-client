package com.example.a2024b_integrative_client.model.object;

public class ObjectId {
	private String superApp;
	private String id;
	
	
	public ObjectId() {}


	public ObjectId(String superapp, String internalObjectId) {
		this.superApp = superapp;
		this.id = internalObjectId;
	}


	public String getSuperApp() {
		return superApp;
	}


	public void setSuperApp(String superApp) {
		this.superApp = superApp;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "ObjectId [superapp=" + superApp + ", internalObjectId=" + id + "]";
	}
}
