package com.example.a2024b_integrative_client.model.miniappCommand;

public class TargetObject {

	private SuperAppObjectIdBoundary objectId;
	public TargetObject() {}

	public TargetObject(SuperAppObjectIdBoundary objectId) {
		this.objectId = objectId;
	}

	public SuperAppObjectIdBoundary getObjectId() {
		return objectId;
	}

	public void setObjectId(SuperAppObjectIdBoundary objectId) {
		this.objectId = objectId;
	}

	@Override
	public String toString() {
		return "TargetObject [objectId=" + objectId + "]";
	}

	
}
