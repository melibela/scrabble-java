package scrabble;

public class Scrabble {

	String[][] letters = new String [15][15]; 
	int players;
	
	//constructor initializes letters[][] and players
	public Scrabble(int P)
	{
		players = P;
		
		for(int row=0; row<letters.length; row++)
			for(int column=0; column<letters[row].length; column++)
				letters[row][column] = "[_]";
		
	}
	
	public void buildBoard()		//prints the contents of each index of letters
	{
		for(int row=0; row<letters.length; row++)
			System.out.printf("%4d", row+1);
		System.out.println();
		for(int row=0; row<letters.length; row++)
		{
			for(int column=0; column<letters[row].length; column++)
				System.out.printf("%4s", letters[row][column]);
			System.out.printf("%4d\n", row+1);
		}
	}
	
	public void writeBox()			//writes the contents of each index of letters
	{
		
		//REMEMBER the indexes of the board are numbered differently than what they actually represent
		letters[0][0] = "";
		
	}
	
	public void getMove()
	{
		
	}
	
}
