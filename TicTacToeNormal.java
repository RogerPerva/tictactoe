package TicTacToe;

import java.util.Scanner;

public class TicTacToeNormal extends Game {
    private int size;
    private int gameType;
    final char[][] board;

    public TicTacToeNormal(int size, int gameType, char[][] board ) {
        this.size = size;
        this.gameType = gameType;
        this.board = board; //Initialize the board
    }

    @Override
    public int[] getPlayerMove(char currentPlayer) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Player " + currentPlayer + ", enter your movement (row and column): ");

        int row = scanner.nextInt() - 1; // Change 0-index
        int col = scanner.nextInt() - 1; // Change 0-index
        return new int[]{row, col};
    }

    @Override
    public boolean isWinner(int size) {
        // Check rows
        for (int i = 0; i < size; i++) {
            char player = board[i][0];
            if (player != '-' && allEqual(player, board[i])) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < size; i++) {
            char player = board[0][i];
            if (player != '-' && allEqual(player, getColumn(i))) {
                return true;
            }
        }

        // Check diagonals
        char player = board[0][0];
        if (player != '-' && allEqual(player, getDiagonal(true))) {
            return true;
        }

        player = board[0][size - 1];
        if (player != '-' && allEqual(player, getDiagonal(false))) {
            return true;
        }

        return false;
    }

    private boolean allEqual(char player, char[] line) {
        for (char cell : line) {
            if (cell != player) {
                return false;
            }
        }
        return true;
    }

    private char[] getColumn(int col) {
        char[] column = new char[board.length];
        for (int i = 0; i < board.length; i++) {
            column[i] = board[i][col];
        }
        return column;
    }

    private char[] getDiagonal(boolean mainDiagonal) {
        char[] diagonal = new char[board.length];
        for (int i = 0; i < board.length; i++) {
            diagonal[i] = mainDiagonal ? board[i][i] : board[i][board.length - 1 - i];
        }
        return diagonal;
    }
}