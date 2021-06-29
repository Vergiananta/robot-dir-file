package com.Robot.Tugas9_Robot;

public enum EnumRobot {
	N("North"), 
	W("West"), 
	E("East"), 
	S("South");
	
	private String value;
	
	EnumRobot(String value){
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
