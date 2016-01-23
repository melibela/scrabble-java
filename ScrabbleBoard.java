package scrabble;

public class ScrabbleBoard {

	Board[][] board = new Board[15][15]; 
	
	public ScrabbleBoard ()
	{
		for(int row=0; row<board.length; row++)
			for(int column=0; column<board[row].length; column++)
				board[row][column] = new Board("[_]", 1, 1, false);
		wordMult();
		letterMult();
	}
	
	public int column()
	{
		return board.length;
	}
	
	public int row()
	{
		return board.length;
	}
	
	public String getIndex(int R, int C)
	{
		return board[R][C].getLetter();
	}
	
	public void setIndex(int R, int C, String letter)
	{
		board[R][C].setLetter(letter);
	}
	
	public boolean indexMatch(int R, int C, String letter)
	{
		boolean match = false;
		if(getIndex(R,C).equals(letter))
			match = true;
		return match;
	}
	
	public void setOccupied(int R, int C)
	{
		board[R][C].set(true);
	}
	
	public boolean getOccupied(int R, int C)
	{
		return board[R][C].isSet();
	}
	
	public int getMultLetter(int R, int C)
	{
		return board[R][C].getLetterMult();
	}

	public int getMultWord(int R, int C)
	{
		return board[R][C].getWordMult();
	}
	
	public void letterMult()
	{
		//double letter point spaces
		board[3][0].setLetterMult(2);
		board[11][0].setLetterMult(2);
		board[6][2].setLetterMult(2);
		board[8][2].setLetterMult(2);
		board[0][3].setLetterMult(2);
		board[7][3].setLetterMult(2);
		board[14][3].setLetterMult(2);
		board[2][6].setLetterMult(2);
		board[6][6].setLetterMult(2);
		board[8][6].setLetterMult(2);
		board[12][6].setLetterMult(2);
		board[3][7].setLetterMult(2);
		board[11][7].setLetterMult(2);
		board[2][8].setLetterMult(2);
		board[6][8].setLetterMult(2);
		board[8][8].setLetterMult(2);
		board[12][8].setLetterMult(2);
		board[0][11].setLetterMult(2);
		board[7][11].setLetterMult(2);
		board[14][11].setLetterMult(2);
		board[6][12].setLetterMult(2);
		board[8][12].setLetterMult(2);
		board[3][14].setLetterMult(2);
		board[11][14].setLetterMult(2);
		
		//triple letter point spaces
		board[5][1].setLetterMult(3);
		board[9][1].setLetterMult(3);
		board[1][5].setLetterMult(3);
		board[5][5].setLetterMult(3);
		board[9][5].setLetterMult(3);
		board[13][5].setLetterMult(3);
		board[1][9].setLetterMult(3);
		board[5][9].setLetterMult(3);
		board[9][9].setLetterMult(3);
		board[13][9].setLetterMult(3);
		board[5][13].setLetterMult(3);
		board[9][13].setLetterMult(3);
		
	}
	 
	public void wordMult()
	{
		//double word point spaces
		board[1][1].setWordMult(2);
		board[2][2].setWordMult(2);
		board[3][3].setWordMult(2);
		board[4][4].setWordMult(2);
		board[13][1].setWordMult(2);
		board[12][2].setWordMult(2);
		board[11][3].setWordMult(2);
		board[10][4].setWordMult(2);
		board[1][13].setWordMult(2);
		board[2][12].setWordMult(2);
		board[3][11].setWordMult(2);
		board[4][10].setWordMult(2);
		board[7][7].setWordMult(2);
		board[13][13].setWordMult(2);
		board[12][12].setWordMult(2);
		board[11][11].setWordMult(2);
		board[10][10].setWordMult(2);
		
		//triple word point spaces
		board[0][0].setWordMult(3);
		board[7][0].setWordMult(3);
		board[14][0].setWordMult(3);
		board[0][7].setWordMult(3);
		board[14][7].setWordMult(3);
		board[0][14].setWordMult(3);
		board[7][14].setWordMult(3);
		board[14][14].setWordMult(3);
		
	}
}
