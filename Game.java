public class Game {
    private char[][] board;
    private Player[] players;
    private int turn;

    /**
     * Winner states:
     * -1: Game is still ongoing
     * 0: Draw
     * 1: Player X wins
     * 2: Player O wins
     */
    private int winner;

    // Constructors
    public Game(Player player1, Player player2) {
        players[0] = player1;
        players[1] = player2;
        
        board = new char[3][3];
        players = new Player[] {player1, player2};
        turn = 0;
        winner = -1;
    }
    public Game() {
        this(new Player("Player 1", 'X', false), new Player("Player 2", 'O', false));
    }

    // Getters
    public char getMark(int row, int col) {
        return board[row][col];
    }
    public char[][] getBoard() {
        return board;
    }
    public int getWinner() {
        return winner;
    }

    // Mutator
    /**
     * Takes a turn for the current player
     * @param row Row index of the move
     * @param col Column index of the move
     * @return true if the move was successful, false if the move was invalid
     */
    public boolean takeTurn(int row, int col) {
        if (board[row][col] == '\0') {
            board[row][col] = turn % 2 == 0 ? 'X' : 'O';
            turn++;
            winner = checkWinner();
            return true;
        }
        return false; // Invalid move
    }

    /**
     * Checks the current state of the game board to determine if there is a winner or a draw.
     * @return 1 if Player X wins, 2 if Player O wins, 0 if it's a draw, -1 if the game is not over yet.
     */
    private int checkWinner() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '\0' && 
            board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return board[i][0] == 'X' ? 1 : 2;
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                if (board[0][i] == '\0') {
                    continue; // Skip empty column
                }
                return board[0][i] == 'X' ? 1 : 2;
            }
        }

        // Check diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            
            return board[0][0] == 'X' ? 1 : 2;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2] == 'X' ? 1 : 2;
        }

        // Check for draw
        boolean isDraw = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '\0') {
                    isDraw = false;
                    break;
                }
            }
        }
        return isDraw ? 0 : -1; // 0 indicates draw
    }
}