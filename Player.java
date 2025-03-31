/**
 * A class that represents a player in a game, which could be either human or computer.
 * Each player has a name, a mark (symbol used in the game), and a flag indicating
 * whether the player is controlled by the computer.
 * 
 * @author Metehan Kutay
 * @author Elif Bozkurt
 */
public class Player {
    private final String name;
    private final char mark;
    private final boolean isComputer;

    /**
     * Constructs a Player object with the given name, mark, and computer status.
     *
     * @param name        The name of the player.
     * @param mark        The mark (e.g., 'X' or 'O') associated with the player.
     * @param isComputer  Whether the player is a computer-controlled player.
     */
    public Player(String name, char mark, boolean isComputer) {
        this.name = name;
        this.mark = mark;
        this.isComputer = isComputer;
    }

    /**
     * Default constructor for Player. Creates a computer player with no name and null mark.
     */
    public Player() {
        this(null, '\0', true);
    }

    // Getters

    /**
     * Returns whether this player is a computer.
     *
     * @return {@code true} if the player is a computer; {@code false} otherwise.
     */
    public boolean isComputer() {
        return isComputer;
    }

    /**
     * Gets the name of the player.
     *
     * @return The player's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the mark (e.g., 'X' or 'O') assigned to the player.
     *
     * @return The player's mark.
     */
    public char getMark() {
        return mark;
    }

    /**
     * For computer players: generates a move.
     * 
     * @return An array containing the row and column of the move.
     * Default implementation returns {0, 0} as a placeholder.
     */
    public int[] takeTurn() {
        // Doldurulacak
        return new int[] {0, 0}; // Example: always returns (0, 0)
    }

    /**
     * For human players: accepts a move provided by the user.
     *
     * @param row The row index of the move.
     * @param col The column index of the move.
     * @return An array containing the row and column of the move.
     */
    public int[] takeTurn(int row, int col) {
        return new int[] {row, col}; // Example: always returns (row, col)
    }
}