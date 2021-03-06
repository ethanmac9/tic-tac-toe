//Simple tic-tac-toe.
//Code by Ethan MacDonald on 1/29/16
//A simple tic-tac-toe game. Basic rules, one square, Xs vs Os.
//Sorry, the GUI is shit D:

import java.util.*;
public class gameCode {
	
	static int turn = 0;
	static int player = 0;
	static int updateNum = 0;
	static int gameOver = 0;
	static String choice;
	static int xWins = 0;
	static int oWins = 0;
	static int ties = 0;
	static int total = 0;
	static int run = 1;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String gameBoard[][] = populate("[ ]", 3, 3);
		//Main game loop.
		do {
			if(player == 0){
				//This is code is nearly identical for both players. 
				clearscreen();
				System.out.println("Use 1-9 to place an 'X' in a corresponding square.");
				display(gameBoard);
				System.out.println("The current score is: ");
				System.out.println(xWins +" X wins, "+ oWins +" O wins, and "+ ties +" ties.");
				System.out.println("Out of "+ total +" games.");
				
				updateNum = input.nextInt();
				turn++;
				gameBoard = updateBoard(updateNum, gameBoard, "X");
				player = 1;
				gameOver = checkForWin(gameBoard, "[X]", turn);
				if(gameOver == 1){
					//Win condition
					xWins++;
					clearscreen();
					System.out.println("X has won!");
					display(gameBoard);
					System.out.println("Would you like to play again? (y/n)");
					choice = input.nextLine();
					choice = input.nextLine(); //This addition line fixes a bug where it will not terminate.
					if(choice.equals("n")){
						total++;
						System.out.println(xWins +" X wins, "+ oWins +" O wins, and "+ ties +" ties.");
						System.out.println("Out of "+ total +" games.");
						run = 0;
					}gameBoard = populate("[ ]", 3, 3); total++; turn = 0;
				}
				else if(gameOver == 2){
					ties++;
					clearscreen();
					System.out.println("It's a tie!");
					display(gameBoard);
					System.out.println("Would you like to play again? (y/n)");
					choice = input.nextLine();
					choice = input.nextLine(); //This addition line fixes a bug where it will not terminate.
					if(choice.equals("n")){
						total++;
						System.out.println(xWins +" X wins, "+ oWins +" O wins, and "+ ties +" ties.");
						System.out.println("Out of "+ total +" games.");
						run = 0;
					}gameBoard = populate("[ ]", 3, 3); total++; turn = 0;
				}
			}
			else if(player == 1){
				//This is code is nearly identical for both players. 
				clearscreen();
				System.out.println("Use 1-9 to place an 'O' in a corresponding square.");
				display(gameBoard);
				System.out.println("The current score is: ");
				System.out.println(xWins +" X wins, "+ oWins +" O wins, and "+ ties +" ties.");
				System.out.println("Out of "+ total +" games.");
				
				updateNum = input.nextInt();
				turn++;
				gameBoard = updateBoard(updateNum, gameBoard, "O");
				player = 0;
				gameOver = checkForWin(gameBoard, "[O]", turn);
				if(gameOver == 1){
					//Win condition
					oWins++;
					clearscreen();
					System.out.println("O has won!");
					display(gameBoard);
					System.out.println("Would you like to play again? (y/n)");
					choice = input.nextLine();
					choice = input.nextLine(); //This addition line fixes a bug where it will not terminate.
					if(choice.equals("n")){
						total++;
						System.out.println(xWins +" X wins, "+ oWins +" O wins, and "+ ties +" ties.");
						System.out.println("Out of "+ total +" games.");
						run = 0;
					}gameBoard = populate("[ ]", 3, 3); total++; turn = 0;
				}
				else if(gameOver == 2){
					ties++;
					clearscreen();
					System.out.println("It's a tie!");
					display(gameBoard);
					System.out.println("Would you like to play again? (y/n)");
					choice = input.nextLine();
					choice = input.nextLine(); //This addition line fixes a bug where it will not terminate.
					if(choice.equals("n")){
						total++;
						System.out.println(xWins +" X wins, "+ oWins +" O wins, and "+ ties +" ties.");
						System.out.println("Out of "+ total +" games.");
						run = 0;
					}gameBoard = populate("[ ]", 3, 3); total++; turn = 0;
				}
			}
		}while(run == 1);	
	}
	
	//Updates the game board.
	public static String[][] updateBoard(int i, String a[][], String xo){
		int index = i - 1;
		String array[][] = a;
		switch(index){
			case 0: if(array[0][0].equals("[ ]")){array[0][0] = "[" + xo + "]";}
				break;
			case 1: if(array[0][1].equals("[ ]")){array[0][1] = "[" + xo + "]";}
				break;
			case 2: if(array[0][2].equals("[ ]")){array[0][2] = "[" + xo + "]";}
				break;
			case 3: if(array[1][0].equals("[ ]")){array[1][0] = "[" + xo + "]";}
				break;
			case 4: if(array[1][1].equals("[ ]")){array[1][1] = "[" + xo + "]";}
				break;
			case 5: if(array[1][2].equals("[ ]")){array[1][2] = "[" + xo + "]";}
				break;
			case 6: if(array[2][0].equals("[ ]")){array[2][0] = "[" + xo + "]";}
				break;
			case 7: if(array[2][1].equals("[ ]")){array[2][1] = "[" + xo + "]";}
				break;
			case 8: if(array[2][2].equals("[ ]")){array[2][2] = "[" + xo + "]";}
				break;
		}return array;	
	}
	//Checks if someone has won, or if a tie has been reached.
	public static int checkForWin(String a[][], String xo, int i){
		String array[][] = a;
		String check = xo;
		int gameOver = 0;
		if	   (array[0][0].equals(check) && array[1][0].equals(check) && array[2][0].equals(check)){gameOver = 1;}
		else if(array[0][1].equals(check) && array[1][1].equals(check) && array[2][1].equals(check)){gameOver = 1;}
		else if(array[0][2].equals(check) && array[1][2].equals(check) && array[2][2].equals(check)){gameOver = 1;}
		else if(array[0][0].equals(check) && array[0][1].equals(check) && array[0][2].equals(check)){gameOver = 1;}
		else if(array[1][0].equals(check) && array[1][1].equals(check) && array[1][2].equals(check)){gameOver = 1;}
		else if(array[2][0].equals(check) && array[2][1].equals(check) && array[2][2].equals(check)){gameOver = 1;}
		else if(array[0][0].equals(check) && array[1][1].equals(check) && array[2][2].equals(check)){gameOver = 1;}
		else if(array[2][0].equals(check) && array[1][1].equals(check) && array[0][2].equals(check)){gameOver = 1;}
		if     (i>8){gameOver = 2;}
		return gameOver;
	}
	//Displays the multidimensional array.
	public static void display(String a[][]){
		for(int row=0; row<a.length; row++){
			for(int column=0; column<a[row].length; column++){
				System.out.print(a[row][column] + "\t");
			} System.out.println();
		}
	} 
	//Creates and populates a multidimensional array based on a given number of rows and columns. 
	public static String[][] populate(String s, int r, int c){
		String array[][]= new String[r][c];
		for(int row = 0; row<r; row++){
			for(int column = 0; column<c; column++){
				array[row][column] = s;
			}
		}return array;
	}
	//Crap way to "clear" the screen. Just prints a bunch of new lines. 
	public static void clearscreen(){
		for(int i=0; i<40; i++){
			System.out.println();
		}
	}
}
