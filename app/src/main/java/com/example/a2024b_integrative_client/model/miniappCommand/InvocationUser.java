package com.example.a2024b_integrative_client.model.miniappCommand;


import com.example.a2024b_integrative_client.model.user.UserId;

public class InvocationUser {
	private UserId userId;
	
	public InvocationUser() {}

	public InvocationUser(UserId userId) {
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
