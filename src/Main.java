import java.util.Scanner;

/**
 * Main class of a Rock, Paper, Scissors, Lizzard, Spock! game simulator.
 *
 * <p>
 * Calls a utility class to handle many functions.
 */
public class Main {

	// The round of the game.
	private static int round = 1;

	/** Compiler constructor. */
	public static void main(String[] args) {
		/**
		 * Outputs to the terminal introductory messages to inform the user.
		 * Calls methods in Utils.java for abstraction purposes.
		 * The wait(int seconds) method is called to give the user time to read the
		 * statements printed.
		 */
		System.out.println("Welcome to Rock, Paper, Scissors, Lizzard, Spock!");
		System.out.println();
		Utils.wait(2);
		Utils.getInstructions();
		Utils.wait(5);

		// Iterate through 10 rounds, calling a method constructor that handles the
		// game.
		while (round < 11) {
			initiateRound();
			// Increments the rounds by one so that the loop is finite.
			round++;
		}
		/**
		 * After the 10 rounds, print the game statistics and a farewell message in the
		 * terminal
		 */
		System.out.println(Utils.getStatistics());
		Utils.wait(2);
		System.out.println("Thanks for playing!");
	}

	/** 
     * Handles each round of the game, sending and retrieving data from the util
	 * class.
     */
	private static void initiateRound() {
		// Suppresses the scanner warning for runtime purposes.
		@SuppressWarnings("all")
		// Instantiates the scanner object.
		Scanner scanner = new Scanner(System.in);
		// Integer equivalent of the player's move.
		int userMove = 0;

		// Requires the player's move to be within the range of 1-5, inclusive.
		while (userMove < 1 || userMove > 5) {
			System.out.println("Choose a move.");
			// Sets the user move to 0 if the inputted value is not an integer so that
			// another move is requested.
			userMove = scanner.hasNextInt() ? scanner.nextInt() : 0;
		}
		// Sets the system move to an integer between 1 and 5, inclusive, corresponding
		// to a move.
		int systemMove = 1 + (int) (Math.random() * 5);
		// Sets the winner string to an output of the Utils#getRoundWinner method,
		// taking the user and system moves as inputs. Sets the updateStatistics boolean
		// to true so score can be kept track.
		String winner = Utils.getRoundWinner(userMove, systemMove, true);
		// String to be outputted in the terminal.
		String resultMessage = "won";

		/**
		 * Sets resultMessage to 'lost' if the system won and 'tie' when such a result
		 * occurs.
		 */
		if (winner.equals("system"))
			resultMessage = "lost";
		else if (winner.equals("tie"))
			resultMessage = "tied";

		// Ouputs the round winner in the terminal.
		System.out.println("Your opponent threw " + Utils.interpretMove(systemMove) + ". You " + resultMessage + "!");
	}
}