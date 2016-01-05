package scrabble;

public class ScrabbleTest {
	
	public static void main(String[] args)
	{

		Scrabble myScrabble = new Scrabble(1);
		myScrabble.buildBoard();
		
		while(true)
		{
		myScrabble.play();
		}
	
	}
}
