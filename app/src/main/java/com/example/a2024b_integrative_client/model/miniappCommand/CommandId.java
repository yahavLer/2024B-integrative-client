package com.example.a2024b_integrative_client.model.miniappCommand;

public class CommandId {

	private String superapp;
	private String miniapp; 
	private String id;
	
	public CommandId() {}

	public CommandId(String superapp, String miniapp, String internalCommandId) {
		this.superapp = superapp;
		this.miniapp = miniapp;
		this.id = internalCommandId;
	}

	public String getSuperapp() {
		return superapp;
	}

	public void setSuperapp(String superapp) {
		this.superapp = superapp;
	}

	public String getMiniapp() {
		return miniapp;
	}

	public void setMiniapp(String miniapp) {
		this.miniapp = miniapp;
	}

	public String getInternalCommandId() {
		return id;
	}

	public void setInternalCommandId(String internalCommandId) {
		this.id = internalCommandId;
	}

	@Override
	public String toString() {
		return "CommandId:/n "
				+ "{superApp=" + superapp + "/n"
				+ ", miniApp=" + miniapp
				+ "/n, id=" + id + "}";
	}
	
}
