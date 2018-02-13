package gofish_assn;

// @TODO: Write rank to string
public class Card {
	
	public enum Suits {club, diamond, heart, spade};
	
	static int TOP_RANK = 13; //King
	static int LOW_RANK = 1; //Ace
	
	int rank;  //1 is an Ace
	Suits suit;
	
	public Card() {
		rank = 1;
		suit = Suits.spade;
	}
	
	public Card(int r, char s) {
		rank = r;
		if(s == 'c')
			suit = Suits.club;
		if(s == 'd')
			suit = Suits.diamond;
		if(s == 'h')
			suit = Suits.heart;
		if(s == 's')
			suit = Suits.spade;
	}
	
	public Card(int r, Suits s) {
		rank = r;
		suit = s;
	}
	
	private Suits toSuit(char c) {
		return Suits.spade; //dummy
	}
	
	private String suitToString(Suits s)
	{
		if(s == Suits.heart)
			return "heart";
		if(s == Suits.spade)
			return "spade";
		if(s == Suits.diamond)
			return "diamond";
		if(s == Suits.club)
			return "club";
		return "not valid suit"; //dummy
	}
	
	private String rankToString(int r)
	{
		if(r == 1)
			return "Ace";
		else if (r>1 && r < 11){
			return String.valueOf(r);
		} else if (r == 11){
			return "Jack";
		}else if(r == 12)
			return "Queen";
		else if(r == 13)
			return "King";
		else
			return "Not valid rank";
	}

	public int getRank() {
		return rank;
	}
	
	public Suits getSuit() {
		return suit;
	}
	
	public String toString() {
		String s = "";
		
		s = s + rankToString(getRank())+ " " + suitToString(getSuit());
		
		return s;
	}

	public String getRankAsString(){
		return rankToString(rank);
	}
}
