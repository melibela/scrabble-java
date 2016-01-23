package scrabble;
import java.util.Random;

public class ScrabbleWord {

	String[] letters = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	String[] vowels = {"A", "E", "I", "O", "U"};
	int[] distribution = {9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1};
	int[] score = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
	Random rand = new Random();
	
	/*public int wordScore(int mult, int length)
	{
		
		return
	}*/
	
	public String[] generateLetter(int i)
	{
		//int i is how many letters to generate, 7 if the games just starting, or however many letters a player uses in a turn
		String[] letters = new String[i];
		
		int letter;
		int chance;

		for(int j = 0; j<i; j++)
		{
			//try to make it more random
			chance = rand.nextInt(6);
			if(chance<3)
				letter = chance * rand.nextInt(9);
			else
				letter = rand.nextInt(26);

			while(distribution[letter]==0)
			{
				letter = rand.nextInt(26);
			}
			
			
			
			letters[j] = this.letters[letter];
			setDist(letter);
		}
		
		return letters;
	}
	
	public int getDist(int i)
	{
		return distribution[i];
	}
	
	public void setDist(int i)
	{
		distribution[i]--;
	}
	
	public boolean gameOver()
	{
		boolean noTiles = false;
		for(int dist : distribution)
			if(dist==0)
				noTiles = true;
			else
				noTiles = false;
		return noTiles;
				
	}
}
