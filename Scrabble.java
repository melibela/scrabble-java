package scrabble;

import java.util.Scanner;

public class Scrabble {

	ScrabbleBoard board = new ScrabbleBoard();
	ScrabblePlayer[] players;
	ScrabbleWord letters = new ScrabbleWord();
	int turn, player;
	String[] words; 
	int[] startPos;
	boolean down = false, across = false;
	Scanner input = new Scanner(System.in);
	
	//constructor initializes turn and players
	public Scrabble(int P, int t, int p)
	{
		
		players = new ScrabblePlayer[P];
		for(int i=0; i<P; i++)
		{
			players[i] = new ScrabblePlayer(i+1, 0, letters.generateLetter(7));
		}
		turn = t;
		player = p;
		
		
		//check whats in the players array
		/*for(int i=0; i<P; i++)
		{
			System.out.println("players id = "+players[i].player+" turn = "+turn+" score = "+players[i].score+" letters = ");
			for(String letter : players[i].letters)
				System.out.print(" "+letter);
		}*/
		//System.out.println(players.length);
		
	}
	
	public void buildBoard()		//prints the contents of each index of letters
	{
		for(int column=0; column<board.column(); column++)
			System.out.printf("%4d", column+1);
		System.out.println();
		for(int row=0; row<board.row(); row++)
		{
			for(int column=0; column<board.row(); column++)
				System.out.printf("%4s", board.getIndex(row,column));
			System.out.printf("%4d\n", row+1);
		}
	}
	
	
	public void play()
	{
		System.out.println("Player "+players[player].getPlayer()+"'s turn");
		System.out.println("Your letters are :");
			for(String letter : players[player].letters)
				System.out.print(" "+letter);
			System.out.println();
		getWord();
		getStart();
		getEnd();
		for(int i =0; i<letters.distribution.length; i++)
			System.out.print(" " + letters.distribution[i]);
		System.out.println();
		boolean success = writeBox(words, startPos);
		if(success && player == players.length - 1)
			player = 0;
		else if(success)
		{
			player++;
			turn++;
		}
		
		for(int i =0; i<letters.distribution.length; i++)
			System.out.print(" " + letters.distribution[i]);
		System.out.println();
		
	}
	
	public void getWord()
	{
		//get the player's word
		System.out.printf("Enter your word: ");
		String word = input.nextLine();
		while(!validateWord(word))
		{
			System.out.printf("Not a word\nRe-enter your word: ");
			word = input.nextLine();
		}
		formatWord(word);
	}
	
	public void getStart()
	{
		//where the player wants to start writing the word from
		String start;
		if(turn==0)
		{
			start = "8,8";
			System.out.println("The first word starts at 8,8");
	
		}
		else
		{
			System.out.printf("Enter your start coordinates: ");
			start = input.nextLine();
			while(!validateStart(start))
				{
					System.out.printf("Not a valid position\nRe-enter position: ");
					start = input.nextLine();
				}
		}
		formatStart(start);
	}
	
	public void getEnd()
	{
		//where the player wants to finish writing the word (word goes down or to the left?)
		System.out.printf("Down or across?: ");
		String end = input.nextLine();
		end = end.toLowerCase();
		while(!validateEnd(end))
		{
			System.out.printf("Please enter \"down\" or \"across\": ");
			end = input.nextLine();
			end = end.toLowerCase();
		}
		formatEnd(end);
	}
	
	public void formatWord( String word )
	{
		//format word into an array of uppercase characters that can be individually placed on board
		word = word.toUpperCase();
		words = word.split("(?<!^)(?=[A-Z+-])");	//use regex so split doesnt insert empty string in beginning of array
		
	}
	
	public void formatStart(String start)
	{
		//format coordinate, separate x and y coordinates into an array, change from string to int
		String[] place1 = start.split(",");
		startPos = new int[place1.length];
		for(int i=0; i<startPos.length; i++)
			startPos[i] = Integer.parseInt(place1[i]);
	}
	
	public void formatEnd(String end)
	{
		//calculate final position of word
		if(end.equals("across"))
			across = true;
		else if(end.equals("down"))
			down = true;
	}
	
	public boolean writeBox(String[] word, int[] start)			//writes the contents of board when a word is added
	{
		//REMEMBER the indexes of the board are numbered differently than what they actually represent
	
		boolean success = false;
		
		if(checkFits())
		{
			System.out.println("Word is too long to start here");
		}	
		else if(!connected()&&turn!=0)
		{
			System.out.println("Your word has to connect with another word on the board");
		}
		else if(!hasLetters())
		{
			System.out.println("You don't have the letters to play this word");
		}
		else
		{
			int i = start[1] - 1;
			int j = start[0] - 1;
			for(String letter : word)
			{
				board.setIndex(i, j, "[" + letter + "]");
				board.setOccupied(i,j);
				if(players[player].useLetter(letter));
					players[player].setLetters(letters.generateLetter(1));
				if(across)
					j++;
				else if(down)
					i++;
			}
					
			buildBoard();
			
			success = true;
		}
		
		across = false;
		down = false;
		
		return success;
	}
	
	
	
	public boolean connected()
	{
		boolean connects=false;
		int i = startPos[1] - 1;
		int j = startPos[0] - 1;
		for(String letter : words)
		{
			if(board.getOccupied(i, j))
			{	
				if(board.indexMatch(i, j, "[" + letter + "]"))
				{
					connects = true;
				}
				else
				{
					System.out.println("The letters where you're trying to connect the words don't match");
					connects = false;
					break;
				}
			}
			if(across)
				j++;
			else if(down)
				i++;
		
		}
		
		return connects;
	}

	public boolean checkFits() 
	{
		return (words.length+(startPos[0]-1)>15&&across)||(words.length+(startPos[1]-1)>15&&down);
	}
	
	public boolean hasLetters()
	{
		int i = startPos[1] - 1;
		int j = startPos[0] - 1;
		boolean found = false;
	//	String[] lettersUsed = new String[words.length];
		for(String word : words)
		{
			found = false;
			for(String letter : players[player].getLetters())
				if(word.equals(letter))
				{
					found = true;
					break;	
				}
				else if(board.indexMatch(i, j, "[" + word + "]"))
				{
					found = true;
					break;
				}	
			if(!found)
				break;
			
			if(across)
				j++;
			else if(down)
				i++;
		}
		
		return found;
	}
	
	public static boolean validateWord(String word)
	{
		return word.matches("[a-zA-Z]*");
	}
	
	public static boolean validateStart(String pos)
	{
		return pos.matches("\\b([1-9]|1[0-5])\\b,\\b([1-9]|1[0-5])\\b");
	}
	
	public static boolean validateEnd(String end)
	{
		return end.matches("down|across");
	}
	
}
