/**
 * Represents a simple 2-player Tic-Tac-Toe game.
 * Handles game logic including turn management, board state,
 * move validation, and winner detection.
 * 
 * @author Elif Bozkurt
 * @author Metehan Kutay
 */
public class Game {
    private char[][] board;
    private Player[] players;
    private int turn;

    /**
     * Winner states:
     * -1: Game is still ongoing
     *  0: Draw
     *  1: Player X wins
     *  2: Player O wins
     */
    private int winner;

    /**
     * Constructs a Game with two players.
     *
     * @param player1 First player (usually 'X').
     * @param player2 Second player (usually 'O').
     */
    public Game(Player player1, Player player2) {
        board = new char[3][3];
        players = new Player[] {player1, player2};
        turn = 0;
        winner = -1;
    }

    /**
     * Constructs a default Game with two human players.
     * Player 1 is 'X', Player 2 is 'O'.
     */
    public Game() {
        this(new Player("Player 1", 'X', false), new Player("Player 2", 'O', false));
    }

    /**
     * Returns the mark ('X', 'O', or '\0') at a given position on the board.
     *
     * @param row The row index (0–2).
     * @param col The column index (0–2).
     * @return The mark at the specified board position.
     */
    public char getMark(int row, int col) {
        return board[row][col];
    }

    /**
     * Gets the current board state.
     *
     * @return A 2D array representing the game board.
     */
    public char[][] getBoard() {
        return board;
    }

    /**
     * Gets the winner of the game.
     *
     * @return 1 if Player X wins, 2 if Player O wins, 0 for draw, -1 if game ongoing.
     */
    public int getWinner() {
        return winner;
    }

    /**
     * Takes a turn for the current player by attempting to place their mark on the board.
     *
     * @param row The row index for the move (0–2).
     * @param col The column index for the move (0–2).
     * @return true if the move is valid and applied; false if the cell is already occupied.
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
     * Evaluates the board to check for a win, draw, or ongoing game.
     *
     * @return 1 if Player X wins, 2 if Player O wins, 0 for draw, -1 if the game is ongoing.
     */
    private int checkWinner() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '\0' &&
                board[i][0] == board[i][1] &&
                board[i][1] == board[i][2]) {
                return board[i][0] == 'X' ? 1 : 2;
            }

            if (board[0][i] == board[1][i] &&
                board[1][i] == board[2][i] &&
                board[0][i] != '\0') {
                return board[0][i] == 'X' ? 1 : 2;
            }
        }

        // Check diagonals
        if (board[0][0] == board[1][1] &&
            board[1][1] == board[2][2] &&
            board[0][0] != '\0') {
            return board[0][0] == 'X' ? 1 : 2;
        }

        if (board[0][2] == board[1][1] &&
            board[1][1] == board[2][0] &&
            board[0][2] != '\0') {
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

        return isDraw ? 0 : -1;
    }
}