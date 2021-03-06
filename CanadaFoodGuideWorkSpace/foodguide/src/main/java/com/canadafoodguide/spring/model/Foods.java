package com.canadafoodguide.spring.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Document(collection="foods")
public class Foods {

	//@Id
	@Field("_id")
	private String _id;


	@Field("fgid")
	private String fgid;
	
	@Field("fgcat_id")
	private String fgcat_id;
	
	@Field("srvg_sz")
	private String srvg_sz;
	

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	
	@Field("food")
	private String food;

	public String getFgid() {
		return fgid;
	}

	public void setFgid(String fgid) {
		this.fgid = fgid;
	}

	public String getFgcat_id() {
		return fgcat_id;
	}

	public void setFgcat_id(String fgcat_id) {
		this.fgcat_id = fgcat_id;
	}

	public String getSrvg_sz() {
		return srvg_sz;
	}

	public void setSrvg_sz(String srvg_sz) {
		this.srvg_sz = srvg_sz;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}
	
	//@Field("cliCountry")
	//private String cliCountry;

	// Getters and Setters

	
}
