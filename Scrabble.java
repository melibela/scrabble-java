package scrabble;

import java.util.Scanner;

public class Scrabble {

	String[][] board = new String [15][15]; 
	int players;
	String[] words; 
	int[] startPos;
	boolean down = false, across = false;
	Scanner input = new Scanner(System.in);
	
	//constructor initializes letters[][] and players
	public Scrabble(int P)
	{
		players = P;
		
		for(int row=0; row<board.length; row++)
			for(int column=0; column<board[row].length; column++)
				board[row][column] = "[_]";
		
	}
	
	public void buildBoard()		//prints the contents of each index of letters
	{
		for(int column=0; column<board.length; column++)
			System.out.printf("%4d", column+1);
		System.out.println();
		for(int row=0; row<board.length; row++)
		{
			for(int column=0; column<board[row].length; column++)
				System.out.printf("%4s", board[row][column]);
			System.out.printf("%4d\n", row+1);
		}
	}
	
	
	
	public void play()
	{
		getWord();
		getStart();
		getEnd();
		writeBox(words, startPos);
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
		System.out.printf("Enter your start coordinates: ");
		String start = input.nextLine();
		while(!validateStart(start))
		{
			System.out.printf("Not a valid position\nRe-enter position: ");
			start = input.nextLine();
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
	
	public void writeBox(String[] word, int[] start)			//writes the contents of board when a word is added
	{
		
		//REMEMBER the indexes of the board are numbered differently than what they actually represent
		int i = start[1] - 1;
		int j = start[0] - 1;
		for(String letter : word)
		{
			
			board[i][j] = "[" + letter + "]";
			if(across)
				j++;
			else if(down)
				i++;
			
		}
		across = false;
		down = false;
		
		buildBoard();
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
