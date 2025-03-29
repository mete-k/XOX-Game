public class Player {
    private final String name;
    private final char mark;
    private final boolean isComputer;


    // Constructors
    public Player(String name, char mark, boolean isComputer) {
        this.name = name;
        this.mark = mark;
        this.isComputer = isComputer;
    }
    public Player() {
        this(null, '\0', true);
    }

    // Getters
    public boolean isComputer() {
        return isComputer;
    }
    public String getName() {
        return name;
    }
    public char getMark() {
        return mark;
    }

    /**
     * For computer players
     * @return An array containing the row and column indices of the move
     */
    public int[] takeTurn() {
        // Doldurulacak
        return new int[] {0, 0}; // Example: always returns (0, 0)
    }
    /**
     * For human players
     * @param row Row index of the move
     * @param col Column index of the move
     * @return An array containing the row and column indices of the move
     */
    public int[] takeTurn(int row, int col) {
        return new int[] {row, col}; // Example: always returns (row, col)
    }
}