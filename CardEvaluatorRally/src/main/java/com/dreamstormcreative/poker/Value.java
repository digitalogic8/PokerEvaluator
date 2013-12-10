package com.dreamstormcreative.poker;

public enum Value {
	ACE("Ace", 14, "A"), KING("King", 13, "K"), QUEEN("Queen", 12, "Q"), JACK("Jack", 11, "J"), TEN("Ten", 10, "10"), NINE("Nine", 9, "9"), EIGHT("Eight", 8, "8"), SEVEN("Seven", 7, "7"), SIX(
			"Six", 6, "6"), FIVE("Five", 5, "5"), FOUR("Four", 4, "4"), THREE("Three", 3, "3"), TWO("Two", 2, "2");

	String val;
	String abreviation;
	int valueAsNum;

	private Value(String val, int valueAsNum, String abreviation) {
		this.val = val;
		this.valueAsNum = valueAsNum;
		this.abreviation = abreviation;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public int getValueAsNum() {
		return valueAsNum;
	}

	public void setValueAsNum(int valueAsNum) {
		this.valueAsNum = valueAsNum;
	}

	public String toString() {
		return val.toUpperCase();
	}

	public String getAbreviation() {
		return abreviation;
	}

	public void setAbreviation(String abreviation) {
		this.abreviation = abreviation;
	}
}
