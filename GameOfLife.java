import java.util.Scanner;

/**
 * Project 6.9 The Game of Life
 * This program runs through the mathematical game of life by accepting an original configuration
 * from the user of a user-defined size and subjecting it to the rules of the game. It will show the 
 * generation specified by the user.
 */

/**
 * @author Caleb Burke
 *
 */
public class GameOfLife {

	/**
	 * @param args
	 */

	final static int LONELY = 1;			//These final integers serve as the rules for the game, with numbers
	final static int LIVE = 2;			//referring to the amount of neighbors.
	final static int BIRTH = 3;
	final static int CROWDED = 4;

	/** getInteger
	 *  Accepts an integer from the user, and calls itself
	 *  recursively to ensure it is successful if an integer is not entered. It is used to decide the 
	 *  amount of rows and columns in the array.
	 * @return
	 */
	public static int getInteger() {
		Scanner get = new Scanner(System.in);
		int userEntry;
		if (get.hasNextInt()) {
			userEntry = get.nextInt(); // assign user input to the return value
		} else {
			System.out.println("Not an integer. Please enter an integer: ");
			userEntry = getInteger(); // recall the method if an integer is not entered
		}
		return userEntry; // returns, where the entered number is assigned to n
	}

	/**checkStringValidity
	 * This method examines the line entered by the user (check) to determine if it is compatible with the game.
	 * If the line is not the correct length or has something other than spaces and o's, it returns false, 
	 * and action is taken accordingly.
	 * 
	 * @param check
	 * @param columns
	 * @return
	 */
	public static boolean checkStringValidity(String check, int columns) {
		boolean toReturn = true;
		int j;
		if (check.length() == columns) {
			for (j = 0; j < columns; j++) {
				if (check.charAt(j) == ' ') {
					j++;
				} else if (check.charAt(j) == 'o') {
					j++;
				} else {
					toReturn = false;
				}
			}
			return toReturn;
		} else {
			toReturn = false;
			return toReturn;
		}
	}

	/**getBoard
	 * This method accepts the original configuration from the user. It utilizes checkStringValidity to
	 * ensure proper construction. It returns a 2-dimensional char array of the specified size containing
	 * spaces and o's, with o's representing life.
	 * @param rows
	 * @param columns
	 * @return
	 */
	public static char[][] getBoard(int rows, int columns) {
		Scanner in = new Scanner(System.in);
		char[][] toReturn = new char[rows][columns];
		boolean valid;
		for (int i = 0; i < rows; i++) {
			String temp = in.nextLine();
			valid = checkStringValidity(temp, columns);
			if (!valid) {
				System.out.println("Sorry, there is a problem with that row. Enter it again: ");
				i--;  			//Rewinds to re-enter that row.
			} else {
				toReturn[i] = temp.toCharArray();		//Assigns values to the array one row at a time.
			}
		}
		return toReturn;
	}

	/**checkNeighbors
	 * This method checks the surrounding spaces in the array to determine whether the cell will
	 * be filled after this generation or not. It returns the character to be placed in the passed slot.
	 * @param habitat
	 * @param i
	 * @param j
	 * @param rows
	 * @param columns
	 * @return
	 */
	public static char checkNeighbors(char[][] habitat, int i, int j, int rows, int columns) {
		int neighbors = 0;
		char toReturn = ' ';
		ROWLOOP: for (int rowIndex = i - 1; rowIndex < i + 2; rowIndex++) {		
			if (rowIndex < 0) {						//i + 2 is limit since we must check i + 1
				rowIndex++;
			}
			if (rowIndex >= rows) {
				continue ROWLOOP;			//Prevents outside index errors.
			}
			COLUMNLOOP: for (int columnIndex = j - 1; columnIndex < j + 2; columnIndex++) {
				if (columnIndex < 0) {
					columnIndex++;
				}
				if (columnIndex >= columns) {
					continue COLUMNLOOP;		//Prevents outside index errors.
				}
				if (habitat[rowIndex][columnIndex] == 'o') {
					neighbors++;				//Increment neighbors if a space is inhabited.
				}
			}
		}
		if (habitat[i][j] == 'o') {
			neighbors--;						//Corrects if the cell itself was inhabited.
		}
		if (neighbors <= LONELY) {
			toReturn = ' ';
		}
		if (neighbors == LIVE) {
			toReturn = habitat[i][j];			//2 neighbors does not change the cell.
		}
		if (neighbors == BIRTH) {
			toReturn = 'o';
		}
		if (neighbors >= CROWDED) {
			toReturn = ' ';
		}
		return toReturn;
	}

	/**nextGeneration
	 * This method uses the previous array to calculate the next generation, utilizing the checkNeighbors
	 * method.
	 * @param habitat
	 * @param rows
	 * @param columns
	 * @return
	 */
	public static char[][] nextGeneration(char[][] habitat, int rows, int columns) {
		char[][] returnArray = new char[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				returnArray[i][j] = checkNeighbors(habitat, i, j, rows, columns);
			}								//Builds out the array according to the rules of the game.
		}
		return returnArray;
	}
/**printBoard
 * This method simply prints the contents of the game's board, or the "habitat," as I've called it.
 * @param habitat
 * @param rows
 * @param columns
 */
	public static void printBoard(char[][] habitat, int rows, int columns) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(habitat[i][j]);
			}
			System.out.print("\n");
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to the Game of Life!\n");
		int rows = 0;				//Declaring/initializing some needed variables
		int columns = 0;
		int generation = 0;
		int gencount = 0;
		Scanner console = new Scanner(System.in);
		System.out.println("How many rows would you like?");		//Used to specify the size of the array
		rows = getInteger();
		System.out.println("How many columns will there be?");
		columns = getInteger();
		System.out.println("Please enter the starting configuration \nusing spaces and o's, one row at a time: ");
		char[][] habitat = getBoard(rows, columns);    //Sets up the initial array based on user input
		System.out.println("Generation 0: ");
		printBoard(habitat, rows, columns);
		while (true) {						//Operating loop, where the user can see whichever gen they want.
			System.out.println("Enter how many generations to progress\n or q to quit:");
			if (console.hasNextInt()) {
				gencount = console.nextInt();
				generation = generation + gencount;
				for (int i = 0; i < gencount; i++) {		//Loop to get to the desired generation.
					habitat = nextGeneration(habitat, rows, columns);
				}
				System.out.println("Generation " + generation + ":");
				printBoard(habitat, rows, columns);
			} else if (console.next().contains("q")) {
				break;
			} else {
				System.out.println("I didn't understand that.");
			}

		}
		System.out.println("The o's are now extinct, thank you.");
	}

}
