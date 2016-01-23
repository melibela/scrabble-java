package scrabble;

public class ScrabblePlayer {

	int player;		//unique player id
	int score;		//player's total score
	String[] letters = new String [7];		//random letters array, from ScrabbleWord
	//Stack words;		//all the words the player has created
	
	public ScrabblePlayer(int p, int s, String[] l)
	{
		player = p;
		score = s;
		letters = l;
	}
	
	public int getPlayer()
	{
		return player;
	}
	
	public void setScore(int s)
	{
		score+=s;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public String[] getLetters()
	{
		return letters;
	}
	
	public void setLetters(String[] l)
	{
		for(String letter : l)
			for(int i = 0; i<letters.length; i++)
			{
				if(letters[i].equals("null"))
					letters[i]=letter;
			}
	}
	
	public boolean useLetter(String l)
	{
		boolean used = false;
		for(int i = 0; i<letters.length; i++)
		{
			if(letters[i].equals(l))
			{
				letters[i]="null";
				used = true;
			}
			if(used)
				break;
		}
		return used;
	}
	
/*	public void setLetters(String[] l)
	{
		//find the next empty index in letters array to place the new letters
		letters
	}*/
}
