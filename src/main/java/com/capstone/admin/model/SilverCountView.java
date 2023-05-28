package com.capstone.admin.model;

public class SilverCountView implements Comparable<SilverCountView>{

	private Silver silver;
	private int silverCount;
	private boolean register;
	public Silver getSilver() {
		return silver;
	}
	public void setSilver(Silver silver) {
		this.silver = silver;
	}
	public int getSilverCount() {
		return silverCount;
	}
	public void setSilverCount(int silverCount) {
		this.silverCount = silverCount;
	}
	public boolean isRegister() {
		return register;
	}
	public void setRegister(boolean register) {
		this.register = register;
	}
	@Override
	public int compareTo(SilverCountView o) {
		return this.silverCount - o.silverCount;
	}
	
}
