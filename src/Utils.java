/*
 * Provides many functions that are called multiple times to reduce complexity in Main.
 */
public class Utils {

	// Wins, Losses, Ties
	private static int wins = 0;
	private static int losses = 0;
	private static int ties = 0;

	/** Delays the program from executing the next line for a given amount of time. */
	public static void wait(int seconds) {
		/**
		 * try-catch statement needed so that the compiler can handle latency issues.
		 */
		try {
			// The sleep method takes a value in milliseconds, thus the seconds parameter
			// needs to be multiplied by 1000.
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException exception) {
			throw new RuntimeException("Unexpected interrupt", exception);
		}
	}

	/** Returns the name of a move based on its integer equivalent. */
	public static String interpretMove(int move) {
		// moveName is null so that the method will return null if the inputted move is
		// not within the accepted range.
		String moveName = null;

		/** Sets moveName based on the parameterized integer. */
		switch (move) {
			case 1:
				moveName = "Scissors";
				// Break needed so that case 5 does not execute for every input (limitation of
				// Java).
				break;
			case 2:
				moveName = "Paper";
				break;
			case 3:
				moveName = "Rock";
				break;
			case 4:
				moveName = "Lizard";
				break;
			case 5:
				moveName = "Spock";
				break;
		}
		// Returns the name of the move.
		return moveName;
	}

	/**
     * Tries a series of selection statements to determine the winner, loser, or if
     * there was a tie based on inputted system and user moves. Updates the game
     * score statistics if parameterized as true.
     */
	public static String getRoundWinner(int userMove, int systemMove, boolean updateStatistics) {
		// Initialized as null to account for a move that might not be within the
		// accepted range.
		String winner = null;
		/** Strings that will be printed based on the selection statements. */
		String user = "user";
		String system = "system";
		String tie = "tie";

		/**
		 * Assigns the round winner based on the precedents determined in the
		 * instructions.
		 */
		if (userMove == 1) {
			if (systemMove == 2 || systemMove == 4)
				winner = user;
			else if (systemMove == userMove)
				winner = tie;
			else
				winner = system;
		} else if (userMove == 2) {
			if (systemMove == 3 || systemMove == 5)
				winner = user;
			else if (systemMove == userMove)
				winner = tie;
			else
				winner = system;
		} else if (userMove == 3) {
			if (systemMove == 1 || systemMove == 4)
				winner = user;
			else if (systemMove == userMove)
				winner = tie;
			else
				winner = system;
		} else if (userMove == 4) {
			if (systemMove == 2 || systemMove == 5)
				winner = user;
			else if (systemMove == userMove)
				winner = tie;
			else
				winner = system;
		} else if (userMove == 5) {
			if (systemMove == 1 || systemMove == 3)
				winner = user;
			else if (systemMove == userMove)
				winner = tie;
			else
				winner = system;
		}

		// If statistics are to be tracked, increment wins, losses, or ties for each
		// round based on the preceding operatons.
		if (updateStatistics) {
			switch (winner) {
				case "user":
					wins++;
					break;
				case "system":
					losses++;
					break;
				case "tie":
					ties++;
					break;
			}
		}

		// Returns the winner.
		return winner;
	}

	/** Provides statistics. */
	public static String getStatistics() {
		// Total rounds played.
		int total = wins + ties + losses;

		// Return the statistics of the rounds played.
		return "Out of the " + total + " games played, " + wins + " were won, "
				+ ties + " were tied, and " + losses + " were lost.";
	}

	/** Outputs in the terminal the rules of the game. */
	public static void getInstructions() {
		System.out.println("Some ground rules for the game:");
		System.out.println(" - Scissors (1) cuts Paper (2)");
		System.out.println(" - Paper (2) covers Rock (3)");
		System.out.println(" - Rock (3) crushes Lizard (4)");
		System.out.println(" - Lizard (4) poisons Spock (5)");
		System.out.println(" - Spock (5) smashes Scissors (1)");
		System.out.println(" - Scissors (1) decapitates Lizard (4)");
		System.out.println(" - Lizard (4) eats Paper (2)");
		System.out.println(" - Paper (2) disproves Spock (5)");
		System.out.println(" - Spock (5) vaporizes Rock (3)");
		System.out.println(" - Rock (3) crushes Scissors (1)");
		System.out.println();
		System.out.println("Input one of the parenthetic numbers above when making a move.");
		System.out.println();
		System.out.println("There will be ten rounds.");
		System.out.println();
	}
}