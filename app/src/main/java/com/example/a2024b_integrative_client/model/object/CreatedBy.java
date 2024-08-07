package com.example.a2024b_integrative_client.model.object;


import com.example.a2024b_integrative_client.model.user.UserId;

public class CreatedBy {
	private UserId userId;
	
	public CreatedBy() {}

	public CreatedBy(UserId userId) {
		this.userId = userId;
	}

	public UserId getUserId() {
		return userId;
	}

	public void setUserId(UserId userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "CreatedBy [userId=" + userId + "]";
	}
	
}
