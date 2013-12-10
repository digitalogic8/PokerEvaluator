package com.dreamstormcreative.poker;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

public class Deck implements Iterable<Card> {
    
	//An iterator is used for storing the cards for easily getting the next card
	private Iterator<Card> cardIterator;

	/**
	 * The default constructor for a deck which builds a deck
	 * of 52 cards and shuffles them
	 */
	public Deck() {
		List<Card> cards = Arrays.asList(Card.values());
		cardIterator = shuffle(cards).iterator();
	}

	/**
	 * Get Card pops the next card off the shuffled deck
	 * @return a random one of 52 cards
	 */
	public Card getCard() {
		return cardIterator.next();
	}

	/**
	 * Test that the deck has another card
	 * @return true if the deck has more cards
	 */
	public boolean hasNextCard() {
		return cardIterator.hasNext();
	}


	
	/**
	 * Shuffle a list of cards
	 * @param cards a list of cards to shuffle
	 * @return a shuffled list of cards
	 */
	public List<Card> shuffle(List<Card> cards) {
		Iterator<Card> cardIterator = cards.iterator();
		Card[] shuffledCards = new Card[cards.size()];
		BitSet allDone = new BitSet(cards.size());
		while (allDone.cardinality() < cards.size()) {
			int num = (new Double(Math.random() * 100).intValue()) % cards.size();
			if (!allDone.get(num)) {
				allDone.set(num);
				shuffledCards[num] = cardIterator.next();
			}
		}
		return Arrays.asList(shuffledCards);
	}

	@Override
	public Iterator<Card> iterator() {
		return cardIterator;
	}

}
