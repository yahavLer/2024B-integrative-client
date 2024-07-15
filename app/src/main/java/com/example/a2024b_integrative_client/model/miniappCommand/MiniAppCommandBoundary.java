package com.example.a2024b_integrative_client.model.miniappCommand;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class MiniAppCommandBoundary {

	private CommandId commandId;
	private String command;
	private TargetObject targetObject;
	private Date invocationTimestamp;
	private CreatedBy invokedBy;
    private Map<String, Object> commandAttributes;
	
	public MiniAppCommandBoundary() {}

	public MiniAppCommandBoundary(String command, TargetObject targetObject, CreatedBy invokedBy) {
		this.commandId = new CommandId("","","");
		this.command = command;
		this.targetObject = targetObject;
		this.invokedBy = invokedBy;
		this.commandAttributes = new HashMap<>();
		this.invocationTimestamp = new Date();
	}


	public CommandId getCommandId() {
		return commandId;
	}


	public void setCommandId(CommandId commandId) {
		this.commandId = commandId;
	}


	public String getCommand() {
		return command;
	}


	public void setCommand(String command) {
		this.command = command;
	}


	public TargetObject getTargetObject() {
		return targetObject;
	}


	public void setTargetObject(TargetObject targetObject) {
		this.targetObject = targetObject;
	}


	public Date getInvocationTimestamp() {
		return invocationTimestamp;
	}


	public void setInvocationTimestamp(Date invocationTimestamp) {
		this.invocationTimestamp = invocationTimestamp;
	}


	public CreatedBy getInvokedBy() {
		return invokedBy;
	}


	public void setInvokedBy(CreatedBy invokedBy) {
		this.invokedBy = invokedBy;
	}


	public Map<String, Object> getCommandAttributes() {
		return commandAttributes;
	}


	public void setCommandAttributes(Map<String, Object> commandAttributes) {
		this.commandAttributes = commandAttributes;
	}


	@Override
	public String toString() {
		return "MiniAppCommandBoundary{" +
				"commandId=" + commandId +
				", command='" + command + '\'' +
				", targetObject=" + targetObject +
				", invocationTimeStamp=" + invocationTimestamp +
				", invokedBy=" + invokedBy +
				", commandAttributes=" + commandAttributes +
				'}';
	}
	
}