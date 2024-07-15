package com.example.a2024b_integrative_client.model.miniappCommand;

public class TargetObject {

	private ObjectId objectId;
	public TargetObject() {}

	public TargetObject(ObjectId objectId) {
		this.objectId = objectId;
	}

	public ObjectId getObjectId() {
		return objectId;
	}

	public void setObjectId(ObjectId objectId) {
		this.objectId = objectId;
	}

	@Override
	public String toString() {
		return "TargetObject{" +
				objectId.toString() +
				'}';
	}

	
}
