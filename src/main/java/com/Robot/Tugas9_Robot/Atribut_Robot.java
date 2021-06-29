	package com.Robot.Tugas9_Robot;


import com.Robot.Tugas9_Robot.EnumRobot;

public class Atribut_Robot {
	private Integer x;
	private Integer y;
	private EnumRobot arah;

	public Atribut_Robot(Integer x, Integer y, EnumRobot Direction) {
		super();
		this.x = x;
		this.y = y;
		this.arah = Direction;
	}

	@Override
	public String toString() {
		return x + "," + y + "-" + arah;
	}

	public Atribut_Robot() {
		super();
	}

	public void forward() {
		if (this.arah == EnumRobot.N) {
			this.y++;
		} else if (this.arah == EnumRobot.E) {
			this.x++;
		} else if (this.arah == EnumRobot.W) {
		this.x--;
		} else if(this.arah == EnumRobot.S) {
		this.y--;
		}
	}

	public void left() {
		if(this.arah == EnumRobot.N) {
			this.arah = this.arah.W;
		} else if (this.arah == EnumRobot.E) {
			this.arah = this.arah.N;
		} else if(this.arah == EnumRobot.W) {
			this.arah = this.arah.S;
		} else if(this.arah == EnumRobot.S) {
			this.arah = this.arah.E;
		}
	}

	public void right() {
		if(this.arah == EnumRobot.N) {
			this.arah = this.arah.E;
		} else if(this.arah == EnumRobot.E) {
			this.arah = this.arah.S;
		} else if(this.arah == EnumRobot.W) {
			this.arah = this.arah.N;
		} else if(this.arah == EnumRobot.S) {
			this.arah = this.arah.W;
		}
	}
}
