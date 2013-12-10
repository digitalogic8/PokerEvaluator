package com.dreamstormcreative.poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.dreamstormcreative.poker.Card;
import com.dreamstormcreative.poker.Suit;

public class Hand implements Comparable<Hand> {
	List<Card> cards = new ArrayList<Card>();
    
	public Hand() {

	}

	public void addCard(Card card) {
		cards.add(card);
	}

	/**
	 * @return
	 */
	public double getHandValue() {
		ArrayList<Double> possibleHands = new ArrayList<Double>();
		// Straight Flush 00--------------. 
		possibleHands.add(isStraightFlush());
		
		// Four of a kind   00----------.00 
		possibleHands.add(isFourOfAKind());		
		
		// Full House         0000--------.
		possibleHands.add(isFullHouse());	
		
		// Flush                0000000000.
		possibleHands.add(isFlush());
		
		// Straight               00------.  
		possibleHands.add(isStaight(cards));
		
		// Three of a Kind          00----.0000  //fix to consider high card
		possibleHands.add(isThreeOfAKind());
		
		// Two Pair                   0000.00 
		possibleHands.add(isTwoPair());
		
		// Pair                         00.00000000  
		possibleHands.add(isOnePair());
		
		// High Card expressed as         .000000000000
        possibleHands.add(getHighCardValue(cards, 5));
		Double largest = 0.0;
        for(Double x : possibleHands){
			if(x > largest){
				largest = x;
			}
		}
        return largest;
	}
	private double getHighCardValue(List<Card> cards, int numOfCards){
       	Object list_a[] = cards.toArray();  
       	Arrays.sort(list_a);
       	double val = 0.0;
       	
       	for(int i = 0; i < numOfCards && i < cards.size(); i++){
       	 val += (((Card)list_a[i]).getValue().getValueAsNum()) * Math.pow(100,(numOfCards-i-1));	
       	}
       	for(int p = 0 ; p < numOfCards ; p++){
       	 val = val * 0.01;	
       	}
       	return val ;
	}
    private double isThreeOfAKind(){
    	int eachVal[] = new int[15]; 
    	for(Card c : cards){
    		eachVal[c.getValue().getValueAsNum()] ++;
    	}

    	for(int i = 0; i < eachVal.length; i++){
    		if(eachVal[i] > 2){
    	    	List<Card> findHighCardList = new ArrayList<Card>();
    	    	for(Card c : cards){
    	    		if(c.getValue().getValueAsNum() != i){
    	    			findHighCardList.add(c);
    	    		}
    	    	}
    			return (i * 10000) + getHighCardValue(findHighCardList, 2);

    		}
    	}
    	return 0;
    }
    private double isFourOfAKind(){
    	int eachVal[] = new int[15]; 
    	for(Card c : cards){
    		eachVal[c.getValue().getValueAsNum()] ++;
    	}
    	for(int i = 0; i < eachVal.length; i++){
    		if(eachVal[i] > 3){
    	    	List<Card> findHighCardList = new ArrayList<Card>();
    	    	for(Card c : cards){
    	    		if(c.getValue().getValueAsNum() != i){
    	    			findHighCardList.add(c);
    	    		}
    	    	}

    			return (1000000000000.0 * i) + getHighCardValue(findHighCardList, 1);

    		}
    	}
    	return 0;
    }
    private double isOnePair(){
    	int eachVal[] = new int[15]; 
    	for(Card c : cards){
    		eachVal[c.getValue().getValueAsNum()] ++;
    	}
    	for(int i = eachVal.length - 1; i >= 0; i--){
    		if(eachVal[i] > 1){
    	    	List<Card> findHighCardList = new ArrayList<Card>();
    	    	for(Card c : cards){
    	    		if(c.getValue().getValueAsNum() != i){
    	    			findHighCardList.add(c);
    	    		}
    	    	}
    			return i + getHighCardValue(findHighCardList, 3);
    		}
    	}

    	return 0;
    }
    private double isFullHouse(){
    	int eachVal[] = new int[15]; 
    	for(Card c : cards){
    		eachVal[c.getValue().getValueAsNum()] ++;
    	}
    	
    	boolean threeOfAKindExists = false;
    	double tripVal = 0;
    	for(int i = eachVal.length - 1; i >= 0; i--){

    		if(eachVal[i] > 2){
    			threeOfAKindExists = true;
    			//set these values to 0 and look for a pair
    			eachVal[i] = 0;
    			tripVal = i* 100;
    		}
    	}
    	if(threeOfAKindExists){
    	for(int i = eachVal.length - 1; i >= 0; i--){
    		if(eachVal[i] > 1){
    			return (i + tripVal) * 100000000;
    		}
    	}
    	}
    	return 0;
    }
    private double isTwoPair(){
    	int eachVal[] = new int[15]; 
    	for(Card c : cards){
    		eachVal[c.getValue().getValueAsNum()] ++;
    	}
    	boolean firstPairExists = false;
    	double val = 0.0;
    	List<Card> findHighCardList = new ArrayList<Card>();


    	for(int i = eachVal.length - 1; i >= 0; i--){
    		if(eachVal[i] > 1){
    			firstPairExists = true;
    			//set these values to 0 and look for a pair
    			val = 100 * i;
    	    	for(Card c : cards){
    	    		if(c.getValue().getValueAsNum() != i){
    	    			findHighCardList.add(c);
    	    		}
    	    	}
    			eachVal[i] = 0;
    			break;
    		}
    	}
    	if(firstPairExists){
    		for(int i = eachVal.length - 1; i >= 0; i--){
    		if(eachVal[i] > 1){
    	    	List<Card> findHighCardList2 = new ArrayList<Card>();
    	    	for(Card c : findHighCardList){
    	    		if(c.getValue().getValueAsNum() != i){
    	    			findHighCardList2.add(c);
    	    		}
    	    	}
    			return val + i + getHighCardValue(findHighCardList2, 1);
    		}
    	}
    	}
    	return 0;
    }
	private Suit getFlushSuit(){
		int numOfEachSuit[] = new int[4];
		for (Card c : cards) {
			numOfEachSuit[c.getSuit().getAsNum()] ++;
			
			if(numOfEachSuit[c.getSuit().getAsNum()] > 4){
				return c.getSuit();
			}
		}

		return null;
	}
	private double isFlush() {
	Suit flushSuit = getFlushSuit();	
	
      if(flushSuit != null){
    	  List<Card> flushedCards = new ArrayList<Card>();

    	  for(Card c: cards){
       		  if(c.getSuit() == flushSuit){
       			 flushedCards.add(c); 
       		  }
       	  }
 
       	return  this.getHighCardValue(flushedCards, 5) * 10000000000.0;
      }
      
      else return 0;
	}
    private double isStaight(List<Card> cards_p){
    	boolean values[] = new boolean[15];
    	for(Card c : cards_p){
    		values[c.getValue().getValueAsNum()] = true;
    		if(c.getValue().getValueAsNum() == 14){
    			values[1] = true;
    		}
    	}
    	int counter = 0;
    	for(int i = 14; i >= 1; i--){
    		if(values[i]){
    			counter++;
    		} else {
    			counter = 0;
    		}
    		if(counter == 5){
    			return (i+4) * 1000000;
    		}
    	}
    	return 0;
    }
	private double isStraightFlush() {
       Suit flushSuit = getFlushSuit();
       List<Card> flushedCards = new ArrayList<Card>();
       if(flushSuit != null){
    	  for(Card c: cards){
    		  if(c.getSuit() == flushSuit){
    			 flushedCards.add(c); 
    		  }
    	  }
    	  return isStaight(flushedCards) * 100000000.0;
       }
       return 0;
	}


	/**
	 * needs a unittest
	 */
	public int compareTo(Hand handO) {
		if(this.getHandValue() - handO.getHandValue() == 0){
			return 0;
		} else if(this.getHandValue() - handO.getHandValue() < 0){
			return -1;
		} else if(this.getHandValue() - handO.getHandValue() > 0){
			return 1;
		}
		return -1;
	}
    public String getHandName(){
    	// Straight Flush 00--------------. 
		if(isStraightFlush() > 0) return "Straight Flush";
		
		// Four of a kind   00----------.00 
		if(isFourOfAKind() > 0) return "Four of a Kind";		
		
		// Full House         0000--------.
		if(isFullHouse() > 0) return "Full House";	
		
		// Flush                0000000000.
		if(isFlush() > 0) return "Flush";
		
		// Straight               00------.  
		if(isStaight(cards) > 0) return "Straight";
		
		// Three of a Kind          00----.0000  //fix to consider high card
		if(isThreeOfAKind() > 0) return "Three of a kind";
		
		// Two Pair                   0000.00 
		if(isTwoPair() > 0) return "Two Pair";
		
		// Pair                         00.00000000  
		if(isOnePair() > 0) return "Pair";
		
		// High Card expressed as         .000000000000
        if(getHighCardValue(cards, 5) > 0)return "High Card";
        
        return "";
    }
	public String toString() {
		String ret = "[";
		for (Card card : cards) {
			ret += card.toString();
		}
		ret += "] = ";
		ret += getHandName() + " weighted " + getHandValue();
		return ret;
	}


}
