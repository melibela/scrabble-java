package scrabble;

public class Board {
	
	private String letter;
	private int letterMultiplier;
	private int wordMultiplier;
	private boolean set;
	
	public Board(String l, int m1, int m2, boolean s)
	{
		letter = l;
		letterMultiplier = m1;
		wordMultiplier = m2;
		set = s;
	}
	
	public String getLetter()
	{
		return letter;
	}

	public void setLetter(String l)
	{
		letter = l;
	}
	
	public int getLetterMult()
	{
		return letterMultiplier;
	}

	public void setWordMult(int m)
	{
		wordMultiplier = m;
	}
	
	public int getWordMult()
	{
		return wordMultiplier;
	}

	public void setLetterMult(int m)
	{
		letterMultiplier = m;
	}
	
	public boolean isSet()
	{
		return set;
	}

	public void set(boolean s)
	{
		set = s;
	}
	
}
