package gofish_assn;

import java.util.ArrayList;
import java.util.Random;

public class Player {
	
	ArrayList<Card> hand = new ArrayList<Card>();
	ArrayList<Card> book = new ArrayList<Card>();
	String name;
	
	public Player(String name) {
		this.name = name;
	}
	
	public void addCardToHand(Card c) {
		hand.add(c);
	}
	
	public Card removeCardFromHand(Card c) {
		Card retCard = new Card();
		try{
			retCard = c;
			hand.remove(c);
		}catch (Exception e){
			throw e;
		}
		return retCard;
	}
	
	public String getName() {
		return name;
	}
	
	public String handToString() {
		String s = new String();
		for (int i = 0; i < hand.size(); i++){
			s = s + "\n"+ hand.get(i).toString();
		}
		return s;
	}
	
	public String bookToString() {
		String s = new String();
		for (int i = 0; i < book.size(); i++){
			s = s + book.get(i).toString() + "\n";
		}
		return s;
	}
	
	public int getHandSize() {
		return hand.size();
	}
	
	
	public int getBookSize() {
		// book/2 or book???
		return book.size()/2;
	}
	
	
	//Here are som ideas for additional functionality that you may want/need
	//OPTIONAL
    // comment out if you decide to not use it
    //this function will check a players hand for a pair. 
    //If a pair is found, it moves the cards to the book and returns true

    public boolean checkHandForBook() {
		for(int i = 0; i<hand.size(); i++){
			Card check1 = hand.get(i);
			for(int k = i+1; k<hand.size(); k++){
				Card check2 = hand.get(k);
				if(check1.getRank() == check2.getRank()){
					book.add(check1);
					book.add(check2);
					hand.remove(check1);
					hand.remove(check2);
					return true;
				}
			}
		}
    	return false; //stubbed
    }

    //OPTIONAL
    // comment out if you decide to not use it    
    //Does the player have a card with the same rank as c in her hand?
    public boolean rankInHand(Card c) {
		for(int i = 0; i<hand.size(); i++){
			if(hand.get(i).getRank() == c.getRank())
				return true;
		}
		return false; //stubbed
    }

    public Card giveRank(Card c){
		Card old = new Card();
		for(int i = 0; i<hand.size(); i++){
			if(hand.get(i).getRank() == c.getRank()){
				old = hand.get(i);
				hand.remove(i);
				return old;
			}
		}
		return null;
	}
    
    //uses some strategy to choose one card from the player's
    //hand so they can say "Do you have a 4?"
    public Card chooseCardFromHand() {
    	Card c = new Card();
    	// random
		Random random = new Random();
		int cardPos = random.nextInt(getHandSize());
		c = hand.get(cardPos);
    	return c;
    }
    
    //Does the player have the card c in her hand?
    public boolean cardInHand(Card c) {

    	return false; //stubbed
    }
    

    //OPTIONAL
    // comment out if you decide to not use it    
    //Does the player have a card with the same rank as c in her hand?
    //e.g. will return true if the player has a 7d and the parameter is 7c
    
    public boolean sameRankInHand(Card c) {
    	return false; //stubbed
    }

}
