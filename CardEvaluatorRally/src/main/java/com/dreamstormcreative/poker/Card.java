package com.dreamstormcreative.poker;

import java.util.Arrays;
import java.util.List;

public enum Card {

	A_D(Suit.DIAMOND, Value.ACE), A_H(Suit.HEART, Value.ACE), A_C(Suit.CLUB, Value.ACE), A_S(Suit.SPADE, Value.ACE),

	K_D(Suit.DIAMOND, Value.KING), K_H(Suit.HEART, Value.KING), K_C(Suit.CLUB, Value.KING), K_S(Suit.SPADE, Value.KING),

	Q_D(Suit.DIAMOND, Value.QUEEN), Q_H(Suit.HEART, Value.QUEEN), Q_C(Suit.CLUB, Value.QUEEN), Q_S(Suit.SPADE, Value.QUEEN),

	J_D(Suit.DIAMOND, Value.JACK), J_H(Suit.HEART, Value.JACK), J_C(Suit.CLUB, Value.JACK), J_S(Suit.SPADE, Value.JACK),

	TEN_D(Suit.DIAMOND, Value.TEN), TEN_H(Suit.HEART, Value.TEN), TEN_C(Suit.CLUB, Value.TEN), TEN_S(Suit.SPADE, Value.TEN),

	NINE_D(Suit.DIAMOND, Value.NINE), NINE_H(Suit.HEART, Value.NINE), NINE_C(Suit.CLUB, Value.NINE), NINE_S(Suit.SPADE, Value.NINE),

	EIGHT_D(Suit.DIAMOND, Value.EIGHT), EIGHT_H(Suit.HEART, Value.EIGHT), EIGHT_C(Suit.CLUB, Value.EIGHT), EIGHT_S(Suit.SPADE, Value.EIGHT),

	SEVEN_D(Suit.DIAMOND, Value.SEVEN), SEVEN_H(Suit.HEART, Value.SEVEN), SEVEN_C(Suit.CLUB, Value.SEVEN), SEVEN_S(Suit.SPADE, Value.SEVEN),

	SIX_D(Suit.DIAMOND, Value.SIX), SIX_H(Suit.HEART, Value.SIX), SIX_C(Suit.CLUB, Value.SIX), SIX_S(Suit.SPADE, Value.SIX),

	FIVE_D(Suit.DIAMOND, Value.FIVE), FIVE_H(Suit.HEART, Value.FIVE), FIVE_C(Suit.CLUB, Value.FIVE), FIVE_S(Suit.SPADE, Value.FIVE),

	FOUR_D(Suit.DIAMOND, Value.FOUR), FOUR_H(Suit.HEART, Value.FOUR), FOUR_C(Suit.CLUB, Value.FOUR), FOUR_S(Suit.SPADE, Value.FOUR),

	THREE_D(Suit.DIAMOND, Value.THREE), THREE_H(Suit.HEART, Value.THREE), THREE_C(Suit.CLUB, Value.THREE), THREE_S(Suit.SPADE, Value.THREE),

	TWO_D(Suit.DIAMOND, Value.TWO), TWO_H(Suit.HEART, Value.TWO), TWO_C(Suit.CLUB, Value.TWO), TWO_S(Suit.SPADE, Value.TWO);

	public Suit suit;
	public Value value;

	private Card(Suit suit, Value value) {
		this.suit = suit;
		this.value = value;
	}
	


	/**
	 * Get the suit of the card, spade, club, heart, or diamond
	 * @return
	 */
	public Suit getSuit() {
		return suit;
	}

	/**
	 * Get the value of a card, values can be interpreted differently
	 * game to game, so a Value object exist to help with this interpretation
	 * @return
	 */
	public Value getValue() {
		return value;
	}

	public static Card findCard(String card) {
		
			for(Card c : Card.getCardsAsList()){
				if(card.substring(0, 1).equalsIgnoreCase(c.getValue().getAbreviation()) && card.substring(1, 2).equalsIgnoreCase(c.suit.toString()))
					return c;
			}
			return null;
		
	}
	
    @Override
	public String toString() {
		return "(" + value.val + "," + suit + ")";
	}

	/**
	 * Get the cards at a list of cards as a convenience
	 * @return
	 */
	public static List<Card> getCardsAsList() {
		return Arrays.asList(new Card[] { A_H, A_S, A_C, A_D, K_H, K_S, K_C, K_D, Q_H, Q_S, Q_C, Q_D, J_H, J_S, J_C, J_D, TEN_H, TEN_S, TEN_C, TEN_D,
				NINE_H, NINE_S, NINE_C, NINE_D, EIGHT_H, EIGHT_S, EIGHT_C, EIGHT_D, SEVEN_H, SEVEN_S, SEVEN_C, SEVEN_D, SIX_H, SIX_S, SIX_C, SIX_D,
				FIVE_H, FIVE_S, FIVE_C, FIVE_D, FOUR_H, FOUR_S, FOUR_C, FOUR_D, THREE_H, THREE_S, THREE_C, THREE_D, TWO_H, TWO_S, TWO_C, TWO_D });
	}
}
