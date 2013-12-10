package com.dreamstormcreative.poker;

import com.dreamstormcreative.poker.Card;

public class PokerEvaluator {

	public static void main(String[] args) {
		Hand h = new Hand();
		if(args[0].equalsIgnoreCase("help")){
			giveInstructions();
		}
	    for(String arg : args){
	    	Card c = Card.findCard(arg);
	    	if (c == null) giveInstructions();
	    	h.addCard(c);
	    }
		System.out.println(h.getHandName());

	}
    public static void giveInstructions(){
    	System.out.println("Please enter cards in as a space seperated list like so Ah Ks Qc Jd 6s");
    	System.exit(0);
    }
}
