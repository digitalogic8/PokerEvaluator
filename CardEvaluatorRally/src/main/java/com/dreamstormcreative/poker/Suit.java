package com.dreamstormcreative.poker;

public enum Suit {
	DIAMOND("d", 0), HEART("h", 1), CLUB("c", 2), SPADE("s", 3);
	String suitName;
	int asNum;

	private Suit(String s, int num) {
		suitName = s;
		asNum = num;
	}

	public String getSuitName() {
		return suitName;
	}

	public void setSuitName(String suitName) {
		this.suitName = suitName;
	}

	public String toString() {
		return getSuitName();
	}

	public int getAsNum() {
		return asNum;
	}

	public void setAsNum(int asNum) {
		this.asNum = asNum;
	}

}
