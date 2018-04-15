package com.swe.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Inheritance(strategy=InheritanceType.JOINED)	
@Entity
public class Panel {
	
	@Id   
    @GeneratedValue(strategy=GenerationType.AUTO)      
	@Column(name="id", unique=true)    
	protected int panelid;
	protected String panelstorename,
		   productname,
		   panelstoreaddress;
	protected int numberofproductsold,
	   productid;
		  
	
	public Panel(int panelid, String panelstorename, int numberofproductsold, int productid, String productname, String panelstoreaddress) {
		super();
		this.panelid = panelid;
		this.panelstorename = panelstorename;
		this.numberofproductsold = numberofproductsold;
		this.productid = productid;
		this.productname = productname;
		this.panelstoreaddress = panelstoreaddress;
		
	}
	
	public Panel() {
		super();
		this.panelid = 0;
		this.panelstorename = "";
		this.numberofproductsold = 0;
		this.productid = 0;
		this.productname = "";
		this.panelstoreaddress = "";
		
	}

	public int getpanelid() {
		return panelid;
	}

	public void setpanelid(int panelid) {
		this.panelid = panelid;
	}

	public String getpanelstorename() {
		return panelstorename;
	}

	public void setpanelstorename(String panelstorename) {
		this.panelstorename = panelstorename;
	}

	public int getnumberofproductsold() {
		return numberofproductsold;
	}

	public void setnumberofproductsold(int numberofproductsold) {
		this.numberofproductsold = numberofproductsold;
	}

	public int getproductid() {
		return productid;
	}

	public void setproductid(int productid) {
		this.productid = productid;
	}

	public String getproductname() {
		return productname;
	}

	public void setproductname(String productname) {
		this.productname = productname;
	}

	public String getpanelstoreaddress() {
		return panelstoreaddress;
	}

	public void setAddress(String panelstoreaddress) {
		this.panelstoreaddress = panelstoreaddress;
	}

}

