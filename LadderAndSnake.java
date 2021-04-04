/**
 * Name and ID : Imran Ahmed 40172931
 * COMP 249
 * Assignment #0
 * 02-08-2020
 */

//--------------------------------------------------------
//Assignment 0
//Question 1 (Part 1)
//Written by : Imran Ahmed 40172931
//---------------------------------------------------------

/* This program will simulate a game of Snakes and Ladders. This game is played by a minimum of 2 and maximum
 * of 4 players. At the beginning of the game, each player will roll the dice. The turns will be determined by
 * which player obtained the the highest number, starting from the highest to the lowest. After, each player 
 * will flip the dice according to the order to move their locations. Each players starts at square 0 and the number 
 * obtained from the dice roll will make them move by x numbers of square (depending on the number obtained).
 * If player reaches at a square which is the bottom of a ladder, then the player moves up to the square where there is the top the ladder.
 * If the player reaches the head of snake, then the player moves down to the square where the tail of the snake is located.
 * The winner is declared if a player reaches square 100. If a player is close to 100 and the number of their
 * dice roll exceed the necessary amount, then the player moves backward with the remaining amounts. 
 */

import java.util.Scanner;

public class LadderAndSnake {
	
	private int[][]board;
	private int number_of_players;
	private int number_in_dice;
	private String [] finalizedorder;
	private int [] player_location;
	
	/**
	 * The default constructor of the Snake and Ladder game. Initializes the board, the number of players, the numbers in dice
	 * ,the finalized order and the players location to 0 or null
	 */
	public LadderAndSnake() {
		int [][] board = new int[10][10];
		number_of_players =0;
		number_in_dice=0;
		String [] finalizedorder= new String[number_of_players];
		int [] playerlocation= new int [number_of_players];
		
	}
	
	/**
	 * Parameterized constructor which takes a parameters of number of players and assigns it to the instance variable of number of players
	 * All other instance variables are assigned 0 or null.
	 * @param number_of_players
	 */
	
	public LadderAndSnake(int number_of_players) {
		int [] board = new int[101];
		this.number_of_players = number_of_players;
		number_in_dice=0;
		String [] finalizedorder= new String[number_of_players];
		int [] playerlocation= new int [number_of_players];
		
	}
	
	
	/**
	 * Mutator method which sets the references of the player location to the array of locations passed.
	 * @param locations
	 */
	public void setplayerlocation(int[] locations) {
		this.player_location = locations;
	}
	
	/**
	 * Accessor method which returns the player_location array
	 * @return the array of player locations
	 */
	public int[] getplayerlocation() {
		return player_location;
	}
	
	/**
	 * Accessor method which gets the number of players in the game
	 * @return the number of players in the game
	 */
	public int getnumberofplayers() {
		return number_of_players;
	}
	
	/**
	 * Accesor method to get the number in dice
	 * @param number_in_dice
	 * @return the number in the dice after it is flipped
	 */
	public int getnumberindice (int number_in_dice) {
		return number_in_dice;
	}
	
	/**
	 * Mutator method that sets the reference of the finalized order to the String of names passed
	 * @param Player names of the game
	 */
	public void setfinalizedorder(String [] names) {
		this.finalizedorder = names;
		
	}
	
	/**
	 * Accessor method to get the finalized order of the game
	 * @return the order of the game
	 */
	public String[] getfinalizedorder() {
		return finalizedorder;
	}
	
	/**
	 * Method which will flip a dice and return the number generated 
	 * @return the number in the dice after it is flipped
	 */
	public int flipdice() {
		int number_in_dice = (int)(Math.random() * (6 - 1 + 1) + 1);
		return number_in_dice;
	}
	
	/**
	 * Method which will get the duplicate number of a array 
	 * @param somearray, will take a array of integers
	 * @return will return the duplicate number of the array
	 */
	public int getduplicatenumber (int [] somearray) {
		int samenumber = 0;
		for (int i = 0 ; i < somearray.length ; i++) {
			for (int j = 1+i ; j < somearray.length ; j++) {
				if (somearray[i] == somearray[j]) {
					samenumber = somearray[i];
				}
			}
		}
		return samenumber;
	}
	
	/**
	 * Method that will determine the order of the game if there is a tie between 2 players
	 * @param arrayofnames, will take a array of strings which are the names
	 * @param arrayofdicenumbers. will take a array of number which are the dice numbers for each player
	 * @return the new order after the tie is broken between the 2 players
	 */
	public int[] tiebetween2players (String[] arrayofnames , int [] arrayofdicenumbers) {
		int dicenumber1;
		int dicenumber2;
		
		for (int i = 0 ; i < arrayofdicenumbers.length ; i++) {
			for (int j = 1+i ; j < arrayofdicenumbers.length ; j++) {
					if (arrayofdicenumbers[i] == arrayofdicenumbers[j]) {
						do
						{
						dicenumber1 = flipdice();
						System.out.println(arrayofnames[i]+" has a value of "+getnumberindice(dicenumber1));
							
						dicenumber2 = flipdice();
						System.out.println(arrayofnames[j]+" has a value of "+getnumberindice(dicenumber2));
						}
						while (dicenumber1 == dicenumber2);
							
						if (dicenumber1 > dicenumber2) {
							System.out.println(arrayofnames[i] + " Wins ");
							arrayofdicenumbers[i]++;
						}
						else if (dicenumber2 > dicenumber1) {
							System.out.println(arrayofnames[j]+ " Wins ");
							arrayofdicenumbers[j]++;
						}
				}
			}
		}
		int [] neworder = new int [arrayofdicenumbers.length];
		for (int i = 0 ; i < neworder.length ; i++) {
			neworder[i] = arrayofdicenumbers[i];
		}
		
		return neworder;
	}
	
	/**
	 * Method which returns the maximum number in a array of numbers
	 * @param arrayofnumbers
	 * @return maximum number
	 */
	public int getmaxofarray(int []arrayofnumbers) {
		int max=arrayofnumbers[0];
		for (int i = 0 ; i < arrayofnumbers.length ; i++) {
			if (arrayofnumbers[i] > max) {
				max = arrayofnumbers[i];
			}
		}
		return max;
	}
	
	/**
	 * Method which returns the minimum number in array of numbers (not 0)
	 * @param arrayofnumbers
	 * @return minimum number not 0
	 */
	
	public int getminofarray(int [] arrayofnumbers) {
		int min=arrayofnumbers[0];
		for (int i = 0 ; i < arrayofnumbers.length ; i++) {
			if (arrayofnumbers[i] < min && arrayofnumbers[i] != 0) {
				min = arrayofnumbers[i];
			}
		}
		return min;
	}
	
	/**
	 * Method will check if the dice numbers are the same for the 3 players that are in tie 
	 * @param arrayofnumbers
	 * @return true if the dice numbers are same for all 3 players or false otherwise
	 */
	
	public boolean checktie3 (int [] arrayofnumbers) {
		 int samenumber = getduplicatenumber(arrayofnumbers);
		 int ties=0;
		 for (int i = 0 ; i < arrayofnumbers.length ; i++) {
			 if (arrayofnumbers[i] == samenumber) {
				 ties++;
			 }
		 }
		 if (ties == 3) {
			 return true;
		 }
		 else
			 return false;
		}
	
	
	/**
	 * Play method which will run the game until there is a winner
	 */
	public void play() {
		boolean gameisrunning = true;
		
		while (gameisrunning == true) {
		Scanner keyIn = new Scanner (System.in);
		for(int i = 0 ; i < finalizedorder.length ; i++) {
		System.out.print(finalizedorder[i]+", press 1 to flip a dice ");
		int numberinput = keyIn.nextInt();
		if (numberinput == 1) {
			int dice = flipdice();
			System.out.println(finalizedorder[i]+" got a value of "+getnumberindice(dice));
			player_location[i] = dice + player_location[i];
			switch (player_location[i]) {
			case 1 : 
				System.out.println(finalizedorder[i]+" went from square 1 to square 38 ");
				player_location[i] = 38;
				break;
			case 16:
				System.out.println(finalizedorder[i]+"went from square 16 to 6");
				player_location[i] = 6;
				break;
			case 4 :
				System.out.println(finalizedorder[i]+" went from square 4 to square 14 ");
				player_location[i] = 14;
				break;
			case 9 :
				System.out.println(finalizedorder[i]+" went from square 9 to square 31 ");
				player_location[i] = 31;
				break;
			case 21 :
				System.out.println(finalizedorder[i]+" went from square 21 to 42 ");
				player_location[i] = 42;
				break;
			case 28 :
				System.out.println(finalizedorder[i]+" went from square 28 square 84");
				player_location[i] = 84;
				break;
			case 36 :
				System.out.println(finalizedorder[i]+ " went from square 36 to 44");
				player_location[i] = 44;
				break;
			case 48 :
				System.out.println(finalizedorder[i]+ " went from square 48 to 30");
				player_location[i] = 30;
				break;
			case 51 :
				System.out.println(finalizedorder[i]+ " went from sqaure 51 to 67");
				player_location[i] = 67;
				break;
			case 64 :
				System.out.println(finalizedorder[i]+ " went from square 64 to 60");
				player_location[i] = 60;
				break;
			case 71:
				System.out.println(finalizedorder[i]+ " went from square 71 to 91");
				player_location[i]= 91;
				break;
			case 79:
				System.out.println(finalizedorder[i]+ " went from square 79 to 19");
				player_location[i] = 19;
				break;
			case 80:
				System.out.println(finalizedorder[i]+ " went from square 80 to 100");
				player_location[i] = 100;
				System.out.println(finalizedorder[i]+" Wins! The game is over");
				gameisrunning= false;
				System.exit(0);
				break;
			case 93 :
				System.out.println(finalizedorder[i]+ " went from square 93 to 68");
				player_location[i] = 68;
				break;
			case 95 :
				System.out.println(finalizedorder[i]+ " went from square 95 to 24");
				player_location[i] = 24;
				break;
			case 97 :
				System.out.println(finalizedorder[i]+ " went from square 97 to 76");
				player_location[i]=76;
				break;
			default :
				if (player_location[i] > 100) {
					int newlocation = player_location[i] - 100;
					player_location[i] = 100 - newlocation;
					System.out.println("You have exceed maximum possible moves, you are at locaiton "+player_location[i]);
				}
				else if (player_location[i] == 100) {
					System.out.println(finalizedorder[i]+ " Wins! The game is over ");
					gameisrunning = false;
					System.exit(0);
					break;
					}
				else
					System.out.println(finalizedorder[i]+" moves to square "+player_location[i]);
					}	
				}
			}
			System.out.println("Game is not over. Flipping again.");
		}
	}

}//End of class LadderAndSnake
