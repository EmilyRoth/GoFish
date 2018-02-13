package gofish_assn;

import java.io.PrintWriter;
import java.io.File;

public class GoFishGame {

	public GoFishGame() {
		// TODO Auto-generated constructor stub
	}

	// make method for handing cards
	// initialize Game
	public GoFishGame(Player p1, Player p2){
		System.out.println("Game is starting");
		// make a deck
		Deck deck = new Deck();
		deck.shuffle();
		for (int i = 0; i < 7; i++){
			p1.addCardToHand(deck.dealCard());
			p2.addCardToHand(deck.dealCard());
		}
		// call method to book pairs
		while (p1.checkHandForBook()){
			System.out.println(p1.getName() + " books the "+ p1.book.get(p1.book.size()-1).getRank());
		}
		while (p2.checkHandForBook()){
			System.out.println(p2.getName() + " books the "+ p2.book.get(p2.book.size()-1).getRank());
		}
		// method to play game
		playGame(p1, p2, deck);
	}
	// play game
	public void playGame(Player p1, Player p2, Deck deck){

		int cardsInPairs = 0;
		while (cardsInPairs<52){
			// p1 turn
			turn(p1, p2, deck);
			// p2 turn
			turn(p2, p1, deck);
			// check if all cards are booked
			cardsInPairs = p1.book.size() + p2.book.size();
		}

		if(p1.book.size() > p2.book.size()){
			System.out.println(p1.getName() + " wins with " +p1.getBookSize() +" booked pairs");
			System.out.println(p1.bookToString());
			System.out.println(p2.getName() + " has " +p2.getBookSize()+ " booked pairs");
			System.out.println(p2.bookToString());
		}else if (p1.book.size() < p2.book.size()){
			System.out.println(p2.getName() + " wins with " +p2.getBookSize() +" booked pairs");
			System.out.println(p2.bookToString());
			System.out.println(p1.getName() + " has " +p1.getBookSize()+ " booked pairs");
			System.out.println(p1.bookToString());
		}else{
			// tied
			System.out.println("Players tied");
			System.out.println(p1.getName() + " has " +p1.getBookSize() +" booked pairs");
			System.out.println(p1.bookToString());
			System.out.println(p2.getName() + " has " +p2.getBookSize()+ " booked pairs");
			System.out.println(p2.bookToString());
		}
	}

	public void turn(Player current, Player opponent, Deck deck){
		if(current.getHandSize() == 0){
			if(deck.getDeckSize()  != 0)
				current.addCardToHand(deck.dealCard());
		}else {
			// has a card in hand
			// asks for card
			Card temp = current.chooseCardFromHand();
			System.out.println(current.getName()+ ": do you have a "+temp.getRankAsString()); // iron out later
			if(opponent.rankInHand(temp)){
				System.out.println(opponent.getName() + ": Yes I have a " + temp.getRankAsString());
				current.addCardToHand(opponent.giveRank(temp));
			}else {
				System.out.println(opponent.getName()+ ": Go fish!!!");
				Card deal = deck.dealCard();
				current.addCardToHand(deal);
				System.out.println(current.getName()+" draws " + deal.toString());
			}
			// check books
			if(current.checkHandForBook()){
				System.out.println(current.getName() + " books the "+ current.book.get(current.book.size()-1).getRankAsString());
			}
			System.out.println();
		}
	}
}
