package gofish_assn;



public class Main {
	
	public static void main(String args[]) {
		System.out.println("Hello World!");
		
		Player p1 = new Player("Jane");
		System.out.println("Player 1 is " + p1.getName());

		Player p2 = new Player("Jo3");
		System.out.println("Player 2 is " + p2.getName());

		GoFishGame game = new GoFishGame(p1, p2);

	}

}
