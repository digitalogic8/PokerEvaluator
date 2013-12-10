package com.dreamstormcreative.poker;

import com.dreamstormcreative.poker.Card;

import junit.framework.TestCase;

public class HandTest extends TestCase {

	public void testHand() {
		Hand h = new Hand();
		assert (h != null);
	}

	public void testAddCard() {
		Hand h = new Hand();
		assert (h.cards.size() == 0);
		h.addCard(Card.A_C);
		assert (h.cards.size() == 1);
	}

	public void testVariableSized() {
		Hand h = new Hand();
		h.addCard(Card.A_C);
		System.out.println(h);
		assertEquals(.14, h.getHandValue());

		h = new Hand();
		h.addCard(Card.A_C);
		h.addCard(Card.A_C);
		System.out.println(h);

		h = new Hand();
		h.addCard(Card.A_C);
		h.addCard(Card.A_C);
		h.addCard(Card.A_C);
		System.out.println(h);

		h = new Hand();
		h.addCard(Card.A_C);
		h.addCard(Card.A_C);
		h.addCard(Card.A_C);
		h.addCard(Card.A_C);
		System.out.println(h);

		h = new Hand();
		h.addCard(Card.A_C);
		h.addCard(Card.A_C);
		h.addCard(Card.A_C);
		h.addCard(Card.A_C);
		h.addCard(Card.A_C);
		System.out.println(h);

		h = new Hand();
		h.addCard(Card.TEN_C);
		h.addCard(Card.TEN_C);
		h.addCard(Card.A_C);
		h.addCard(Card.A_C);
		h.addCard(Card.A_C);
		h.addCard(Card.A_C);
		System.out.println(h);

		h = new Hand();
		h.addCard(Card.A_C);
		h.addCard(Card.K_C);
		h.addCard(Card.Q_C);
		h.addCard(Card.J_C);
		h.addCard(Card.TEN_C);
		System.out.println(h);

		h = new Hand();
		h.addCard(Card.A_C);
		h.addCard(Card.FOUR_C);
		h.addCard(Card.THREE_C);
		h.addCard(Card.SIX_C);
		h.addCard(Card.NINE_C);
		System.out.println(h);

		h = new Hand();
		h.addCard(Card.A_C);
		h.addCard(Card.K_C);
		h.addCard(Card.Q_S);
		h.addCard(Card.J_C);
		h.addCard(Card.TEN_C);
		System.out.println(h);

	}

	public void testAllHands() {
		int handCount = 0;
		int straightFlushCount = 0;
		int fullHouseCount = 0;
		int flushCount = 0;
		int straightCount = 0;
		int threeOfAKindCount = 0;
		int twoPairCount = 0;
		int pairCount = 0;
		int highCardCount = 0;
		int fourOfAKindCount = 0;
		for (int i = 0; i < Card.getCardsAsList().size(); i++) {
			for (int j = i + 1; j < Card.getCardsAsList().size(); j++) {
				for (int k = j + 1; k < Card.getCardsAsList().size(); k++) {
					for (int l = k + 1; l < Card.getCardsAsList().size(); l++) {
						for (int m = l + 1; m < Card.getCardsAsList().size(); m++) {
							Hand h = new Hand();
							h.addCard(Card.getCardsAsList().get(i));
							h.addCard(Card.getCardsAsList().get(j));
							h.addCard(Card.getCardsAsList().get(k));
							h.addCard(Card.getCardsAsList().get(l));
							h.addCard(Card.getCardsAsList().get(m));
							straightFlushCount += (h.getHandName().equalsIgnoreCase("Straight Flush") ? 1 : 0);
							fourOfAKindCount += (h.getHandName().equalsIgnoreCase("Four of a Kind") ? 1 : 0);
							fullHouseCount += (h.getHandName().equalsIgnoreCase("Full House") ? 1 : 0);
							flushCount += (h.getHandName().equalsIgnoreCase("Flush") ? 1 : 0);
							straightCount += (h.getHandName().equalsIgnoreCase("Straight") ? 1 : 0);
							threeOfAKindCount += (h.getHandName().equalsIgnoreCase("Three of a kind") ? 1 : 0);
							twoPairCount += (h.getHandName().equalsIgnoreCase("Two Pair") ? 1 : 0);
							pairCount += (h.getHandName().equalsIgnoreCase("Pair") ? 1 : 0);
							highCardCount += (h.getHandName().equalsIgnoreCase("High Card") ? 1 : 0);
							handCount++;
							h.getHandValue();
						}
					}
				}
			}
		}
		System.out.println("handCount " + handCount);
		System.out.println("straightFlushCount " + straightFlushCount);
		System.out.println("fourOfAKindCount " + fourOfAKindCount);
		System.out.println("fullHouseCount " + fullHouseCount);
		System.out.println("flushCount " + flushCount);
		System.out.println("straightCount " + straightCount);
		System.out.println("threeOfAKindCount " + threeOfAKindCount);
		System.out.println("twoPairCount " + twoPairCount);
		System.out.println("pairCount " + pairCount);
		System.out.println("highCardCount " + highCardCount);

	}

	public void testGetHandValue() {
		// Test Straight Flush
		Hand h = new Hand();
		h.addCard(Card.A_C);
		h.addCard(Card.A_S);
		h.addCard(Card.Q_D);
		h.addCard(Card.A_D);
		h.addCard(Card.K_D);
		h.addCard(Card.TEN_D);
		h.addCard(Card.J_D);
		System.out.println(h);
		assertEquals(1400000000000000.0, h.getHandValue());

		// Test four of a kind
		h = new Hand();
		h.addCard(Card.A_C);
		h.addCard(Card.A_S);
		h.addCard(Card.A_H);
		h.addCard(Card.A_D);
		h.addCard(Card.K_D);
		h.addCard(Card.TEN_D);
		h.addCard(Card.J_D);
		System.out.println(h);
		assertEquals(14000000000000.13, h.getHandValue());

		// Test Full house
		h = new Hand();
		h.addCard(Card.A_C);
		h.addCard(Card.A_S);
		h.addCard(Card.Q_D);
		h.addCard(Card.A_D);
		h.addCard(Card.Q_H);
		h.addCard(Card.TEN_D);
		h.addCard(Card.J_D);
		System.out.println(h);
		assertEquals(141200000000.0, h.getHandValue());

		// Test Flush
		h = new Hand();
		h.addCard(Card.A_C);
		h.addCard(Card.A_S);
		h.addCard(Card.Q_D);
		h.addCard(Card.A_D);
		h.addCard(Card.TWO_D);
		h.addCard(Card.TEN_D);
		h.addCard(Card.J_D);
		System.out.println(h);
		assertEquals(1412111002.0, h.getHandValue());

		// Test Straight
		h = new Hand();
		h.addCard(Card.A_C);
		h.addCard(Card.A_S);
		h.addCard(Card.Q_S);
		h.addCard(Card.A_D);
		h.addCard(Card.K_C);
		h.addCard(Card.TEN_D);
		h.addCard(Card.J_D);
		System.out.println(h);
		assertEquals(14000000.0, h.getHandValue());

		// Test three of a kind
		h = new Hand();
		h.addCard(Card.A_C);
		h.addCard(Card.A_S);
		h.addCard(Card.A_H);
		h.addCard(Card.THREE_D);
		h.addCard(Card.K_D);
		h.addCard(Card.TEN_D);
		h.addCard(Card.J_D);
		System.out.println(h);
		assertEquals(140000.1311, h.getHandValue());

		// Test two Pair
		h = new Hand();
		h.addCard(Card.A_C);
		h.addCard(Card.A_S);
		h.addCard(Card.THREE_H);
		h.addCard(Card.THREE_D);
		h.addCard(Card.K_D);
		h.addCard(Card.TEN_D);
		h.addCard(Card.J_D);
		System.out.println(h);
		assertEquals(1403.13, h.getHandValue());

		// Test one Pair
		h = new Hand();
		h.addCard(Card.A_C);
		h.addCard(Card.A_S);
		h.addCard(Card.THREE_H);
		h.addCard(Card.SEVEN_D);
		h.addCard(Card.K_D);
		h.addCard(Card.TEN_D);
		h.addCard(Card.J_D);
		System.out.println(h);
		assertEquals(14.131110, h.getHandValue());

		// Test highcard
		h = new Hand();
		h.addCard(Card.A_C);
		h.addCard(Card.EIGHT_S);
		h.addCard(Card.THREE_H);
		h.addCard(Card.SEVEN_D);
		h.addCard(Card.K_D);
		h.addCard(Card.TEN_D);
		h.addCard(Card.J_D);
		System.out.println(h);
		assertEquals(.1413111008, h.getHandValue());
	}

	public void testCompareTo() {
		// Test one Pair
		Hand h2 = new Hand();
		h2.addCard(Card.A_C);
		h2.addCard(Card.A_S);
		h2.addCard(Card.THREE_H);
		h2.addCard(Card.SEVEN_D);
		h2.addCard(Card.K_D);
		h2.addCard(Card.TEN_D);
		h2.addCard(Card.J_D);

		// Test highcard
		Hand h = new Hand();
		h.addCard(Card.A_C);
		h.addCard(Card.EIGHT_S);
		h.addCard(Card.THREE_H);
		h.addCard(Card.SEVEN_D);
		h.addCard(Card.K_D);
		h.addCard(Card.TEN_D);
		h.addCard(Card.J_D);

		assert (h.compareTo(h2) == -1);
	}

	public void testToString() {
		Hand h = new Hand();
		h.addCard(Card.A_C);
		h.addCard(Card.EIGHT_S);
		h.addCard(Card.THREE_H);
		h.addCard(Card.SEVEN_D);
		h.addCard(Card.K_D);
		h.addCard(Card.TEN_D);
		h.addCard(Card.J_D);
		System.out.println(h);
	}

}
