/**
 * Name and ID : Imran Ahmed 40172931
 * COMP 249
 * Assignment #0
 * 02-08-2020
 */

//--------------------------------------------------------
//Assignment 0
//Question 1 (Part 2)
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

public class PlayLadderAndSnake {

	public static void main(String[] args) {
		
		//Welcome to my program
		
		//Declaring the scanner
		Scanner keyIn = new Scanner(System.in);
		
		//Prompt user for the numbers of players and check if the input is correct
		System.out.println("Welcome to the Snake and Ladder game!!!");
		int numberofplayers =0;
		int attempts=0;
		do
		{
		System.out.print("Enter the number of players that will play (Number between 2 and 4):");
		numberofplayers = keyIn.nextInt();
			if (numberofplayers < 2 || numberofplayers > 4) {
				System.out.println("Bad attempt "+(attempts+1)+" ! Invalid number of players!");
				attempts++;
			}
			
			if (attempts == 4) {
				System.out.print("You have exhausted all your attempts. Program will terminate!");
				System.exit(0);
				
			}
		
		}while(numberofplayers < 2 || numberofplayers > 4);
		
		LadderAndSnake game = new LadderAndSnake(numberofplayers);
		System.out.println("Game is played by " +game.getnumberofplayers() +" players");
		System.out.println("Now let's decide the order in which player will be starting!");
		
		
		//Prompt each players to flip a dice
		int [] flipdice = new int[numberofplayers];
		String [] names = new String[numberofplayers];
		
		for (int i = 0; i < flipdice.length ; i++) {
			System.out.print("Player "+(i+1)+", Press 1 to flip dice : ");
			int numberinput = keyIn.nextInt();
				if(numberinput == 1) {
					int dicenumber = game.flipdice();
					System.out.println("Player"+(i+1)+" has a value of "+game.getnumberindice(dicenumber));
					flipdice[i] = dicenumber;
					names[i] = "Player"+(1+i);
					}
		}
		
		//Declaring a integer called samenumber which will get the duplicate number from the flipdice array
		int samenumber = game.getduplicatenumber(flipdice);
		
		//Initially there are 0 ties
		int tie = 0;
		
		//Display which players are in a tie if there is a tie
		if(samenumber !=0) {
			for (int i = 0 ; i < names.length ; i++) {
					if(flipdice[i] == samenumber) {
						System.out.print(names[i]+" ");
						tie++;
						}
			}
			System.out.println("are in a tie. Attempting to break tie");
		}
				
		
		//Number of players that are in a tie
		System.out.println("There is a tie between "+tie +" players.");
		
		//If statement if there is a tie between 2 players
		if (tie == 2) {
			samenumber = game.getduplicatenumber(flipdice);
			
		//This for loop will increment  all elements in the flipdice array to 1 if number is greater than the duplicate number
		//and decrement by 1 if number is less than the duplicate number
		for (int i = 0; i < flipdice.length ; i++) {
			if (flipdice[i] > samenumber) {
				flipdice[i]++;
			}
			else if (flipdice[i] < samenumber);
				flipdice[i]--;
			}
		
		//This will determine the order after the 2 players have played each other
		flipdice = game.tiebetween2players(names, flipdice);
		
		}
		//End of the if statement
		
		
		//If statement if there is a tie between 3 players
		if (tie == 3) {
			int[] tiebetween3players = new int[flipdice.length];
			samenumber = game.getduplicatenumber(flipdice);
			
		//This for loop will increment  all elements in the flipdice array to 2 if number is greater than the duplicate number
		//and decrement by 2 if number is less than the duplicate number
		for (int i = 0 ; i < flipdice.length ; i++) {
			if (flipdice[i] > samenumber) {
				flipdice[i] = flipdice[i] +2;
			}
			else if (flipdice[i] < samenumber) {
				flipdice[i] = flipdice[i] -2;
			}
		}
		
		do
		{
		for (int i = 0 ; i < flipdice.length ; i++) {
			if(flipdice[i] == samenumber) {
				tiebetween3players[i] = game.flipdice();
				System.out.println(names[i]+" flips a dice and got a value of" +tiebetween3players[i]);
			}
		}
		}while (game.checktie3(tiebetween3players));
		
		
		
		//If there is a tie between 2 players within the 3 player tie
		int tiebetween2playersin3 = 0;
		int samenumber2 =0;
		for (int i = 0 ; i < tiebetween3players.length ; i++) {
			for (int j = 1+i ; j < tiebetween3players.length ; j++) {
				if (tiebetween3players[i] == tiebetween3players[j]) {
					System.out.println("There is a tie between "+names[i]+" and "+names[j]+" Attempting to break tie");
					samenumber2 = tiebetween3players[i];
					tiebetween2playersin3++;
				}
			}
		}
		
		//This for loop will increment  all elements in the tiebetween3players array to 7 if number is greater than the duplicate number
		//and decrement by -7 if number is less than the duplicate number
		if (tiebetween2playersin3 != 0) {
			for (int i = 0 ; i < tiebetween3players.length; i++) {
				if (tiebetween3players[i] == 0) {
					tiebetween3players[i] = 0;
				}
				else if (tiebetween3players[i] > samenumber2) {
					tiebetween3players[i] = tiebetween3players[i] + 7;
				}
				else if (tiebetween3players[i] < samenumber2) {
					tiebetween3players[i] = tiebetween3players[i] - 7;
				}
			}
		
		//This will determine the order after the 2 players have played each other
		tiebetween3players = game.tiebetween2players(names,tiebetween3players);
		
		
		}
		
		//This will determine the maximum number from the tiebetween3 array
		int max = game.getmaxofarray(tiebetween3players);
		
		//This will determine the minimum number from the tiebetween3 array not 0
		int min = game.getminofarray(tiebetween3players);
		
		//This will increment the flipdice array for the player that got the maximum dice number in the tie of 3
		for (int i = 0 ; i < flipdice.length ; i++) {
			if (tiebetween3players[i] == max) {
				flipdice[i]++;
			}
		}
		
		//This for loop will decrement the flipdice array for the player that got the minimum dice number in the tie of 3 not 0
		for (int i = 0 ; i < flipdice.length ; i++) {
			if(tiebetween3players[i] == min) {
				flipdice[i]--;
			}
		}
		
	}
		
		//Display the order in which players will play
		String [] order = new String [flipdice.length];
		
				
		int j = 0;
		System.out.print("The finalized order is : ");
		int counter = 8;
		while (j < order.length && counter >= -5) {
			for (int i = 0; i < flipdice.length; i++) {
				if(flipdice[i] == counter) {
					System.out.print(names[i]+" ");
					order[j] = names[i];
					flipdice[i] = -5;
					j++;
				}
			}
			counter--;
		}
		System.out.println();
			
		//This will set the finalized order in the PlayLadderAndSnake object
		game.setfinalizedorder(order);
		
		//This for loop will set the player location for each player to 0
		int [] location = new int [flipdice.length];
		for (int i = 0 ; i < location.length ; i++) {
			location[i] =0;
		}
		game.setplayerlocation(location);
		
		
		//This will run the game
		game.play();
		
		}//End of class PlayLadderAndSnake()

}
