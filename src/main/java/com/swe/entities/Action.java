package com.swe.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Action {

	@Id   
    @GeneratedValue(strategy=GenerationType.AUTO)    
	@Column(name="action_id", unique=true)
	private int actionID;
	
	private int storeID, collaboratorID, productID;
	private String actionType;                // add - edit - delete
	private boolean accepted;
	
	public Action(int actionID, int storeID, int collaboratorID, int productID, String actionType) {
		super();
		this.actionID = actionID;
		this.storeID = storeID;
		this.collaboratorID = collaboratorID;
		this.productID = productID;
		this.actionType = actionType;
		this.accepted = false;
	}
	
	public Action(int storeID, int collaboratorID, int productID, String actionType) {
		super();
		this.actionID = 0;
		this.storeID = 0;
		this.collaboratorID = collaboratorID;
		this.productID = productID;
		this.actionType = actionType;
		this.accepted = false;
	}
	
	public Action() {
		super();
		this.actionID = 0;
		this.collaboratorID = 0;
		this.productID = 0;
		this.actionType = "";
		this.accepted = false;
	}

	public int getActionID() {
		return actionID;
	}

	public void setActionID(int actionID) {
		this.actionID = actionID;
	}

	public int getCollaboratorID() {
		return collaboratorID;
	}

	public void setCollaboratorID(int collaboratorID) {
		this.collaboratorID = collaboratorID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public int getStoreID() {
		return storeID;
	}

	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}
	
}
