package gofish_assn;

import java.util.ArrayList;

import gofish_assn.Card.Suits;
import java.util.Random;

public class Deck {
	ArrayList<Card> deck = new ArrayList<Card> ();
	final int NUM_CARDS = 52;  //for this kind of deck
	
	//creates a new sorted deck
	public Deck() {
		// 4 suits
		for(Card.Suits s : Card.Suits.values()){
			// ace is 1
			for(int r = 1; r<=13; r++){
				Card newCard = new Card(r, s);
				deck.add(newCard);
			}
		}
	}
	
	public void shuffle() {
		Random random = new Random();
		for(int i = 0; i< deck.size(); i++){
			// random positions
			int pos1 = random.nextInt(deck.size() - i);
			int pos2 = random.nextInt(deck.size() - i);
			// swap
			Card temp = deck.get(pos1);
			deck.set(pos1, deck.get(pos2));
			deck.set(pos2, temp);
		}
	}
	
	
	public void printDeck() {
		for (int i = 0; i < deck.size(); i++){
			System.out.println(deck.get(i).toString());
		}
	}
	
	
	public Card dealCard() {
		
		Card c = new Card();
		try {
			c = deck.get(0);
			deck.remove(0);
		}catch (Exception e){
			throw e;
		}
		return c;
		
	}

	public int getDeckSize(){
		return deck.size();
	}

}
