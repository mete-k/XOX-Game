import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
/**
 * A GUI frame for the Tic-Tac-Toe game.
 * Handles the visual layout and user interaction using Java Swing components.
 * Connects to the game logic through the Game class.
 * 
 * This frame displays the board, manages buttons for moves,
 * shows status messages (e.g. current player, winner), and provides a restart button.
 * 
 * @author Elif Bozkurt
 * @author Metehan Kutay
 */
public class GameFrame extends JFrame {
    private Game game;
    private JPanel boardPanel;
    private JButton[][] buttons;
    private JLabel statusLabel;
    private JButton resetButton;

    /**
     * Constructs a GameFrame, initializes the game board, and sets up the UI.
     */
    public GameFrame() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Tic Tac Toe");
        this.setSize(500,500);
        this.setLocationRelativeTo(null);

        this.game = new Game();
        JPanel resetPanel = new JPanel();
        this.statusLabel = new JLabel(game.getPlayers()[0].getName() + "'s Turn", SwingConstants.CENTER);

        this.resetButton = new JButton("Restart");
        this.resetButton.setBackground(Color.LIGHT_GRAY);
        this.resetButton.addActionListener(_ -> {
            this.dispose();
            new GameFrame();
        });

        initBoardPanel();
        this.add(statusLabel, BorderLayout.NORTH);
        resetPanel.add(resetButton);
        this.add(resetPanel, BorderLayout.SOUTH);
        this.add(boardPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }

    /**
     * Initializes the Tic-Tac-Toe board panel with a 3x3 grid of buttons.
     * Each button represents a cell in the game board.
     */
    private void initBoardPanel() {
        this.boardPanel = new JPanel();
        this.buttons = new JButton[3][3];

        boardPanel.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final int row = i;
                final int col = j;

                buttons[i][j] = new JButton();

                final JButton b = buttons[row][col];
                b.setFont(new Font("Arial", Font.PLAIN,40));
        
                b.addActionListener(elfim -> {
                    if (game.takeTurn(row, col)) {
                        b.setText(Character.toString(game.getMark(row, col)));
                        if (game.getMark(row, col) == 'X') statusLabel.setText("Player 2's Turn");
                        else if (game.getMark(row, col) == 'O') statusLabel.setText("Player 1's Turn");

                        if (game.getWinner() != -1)
                            endGame();

                        this.repaint();
                        this.revalidate();
                    }
                    
                });
                
                buttons[i][j].setBackground(Color.WHITE);
                boardPanel.add(b);
            }
        }   
    }

    /**
     * Ends the game by disabling all buttons and displaying the result.
     * If a player wins, a message is shown. If it's a draw, a draw message appears.
     */
    private void endGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setEnabled(false);
            }
        }

        // Display the winner or draw message
        if (game.getWinner() > 0) {
            statusLabel.setText("Player " + game.getWinner() + " won!");
            JOptionPane.showMessageDialog(null, "Player " + game.getWinner() + " wins!");
        } else {
            JOptionPane.showMessageDialog(null,"Draw!");
        }
    }

    /**
     * The main method that launches the Tic-Tac-Toe game.
     * 
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        new GameFrame();
    }
}