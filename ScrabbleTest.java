package scrabble;
import java.util.Scanner;
public class ScrabbleTest {
	
	public static void main(String[] args)
	{		
		Scanner input = new Scanner(System.in);

		//ScrabbleBoard myBoard = new ScrabbleBoard();
		System.out.print("How many players? 1 - 4 : ");
		int players = input.nextInt();
		while(!(players<=4)||!(players>=1))
		{
			System.out.printf("1 - 4 players! Try again: ");
			players = input.nextInt();
		}
		
		Scrabble myScrabble = new Scrabble(players,0,0);
		
		while(true)
		{
			myScrabble.play();
		}
	   
	}
}
