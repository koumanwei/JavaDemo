package com.koumanwei.reflect;

public class ReflectPoint {
	private int x;
	public int y;
	public String str1 = "ball";
	public String str2 = "basketball";
	public String str3 = "itcast";

	public ReflectPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	@Override
	public String toString() {
		return "ReflectPoint [str1=" + str1 + ", str2=" + str2 + ", str3=" + str3 + "]";
	}

}
