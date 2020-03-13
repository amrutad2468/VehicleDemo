package com.test.vehicledemo.model;

import java.util.UUID;

public class Result {

	private UUID uid;
	private String vin;
	
	public UUID getUid() {
		return uid;
	}
	public void setUid(UUID uuid) {
		this.uid = uuid;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	
	@Override
	public String toString() {
		return "Result [uid=" + uid + ", vin=" + vin + "]";
	}
	
	
	
}
