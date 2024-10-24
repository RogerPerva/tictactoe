import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToeNormal extends Game {

    public TicTacToeNormal(int size, int typeGame) {
        super(size);
        this.player1 = new Player(Symbol.X);
        this.player2 = new Player(Symbol.O);
        this.currentPlayer = player1;
        this.typeGame = typeGame; // added the type of the game so we can change between games
    }

    public TicTacToeNormal() {
    super();
    }

    @Override
    boolean isGameOver() {
        // Comprobar si hay un ganador
        if (isWinner()) {
            if (getTypeGame() == 1) {
                System.out.println("Player " + currentPlayer.getSymbol() + " is Winner.");
                if(currentPlayer == player1){
                    player1.setGamesWonX();  // adding a counter to X
                }
                return true;

            } else {
                switchPlayer();
                System.out.println("Player " + currentPlayer.getSymbol() + " is Winner.");
                if(currentPlayer == player2){
                    player2.setGamesWonO(); //Adding a counter to O
                }
                return true;
            }
        }

        // Comprobar si el tablero está lleno
        if (isBoardFull()) {
            System.out.println("It's a tie!");
            return true;
        }
        return false;
    }

    //Creating the class for score
    @Override
    String gamesScore() { // I opted to create a method with array of int because I cannot return 2 values, so that why i did it that way... finally I changed to string.
//        player1.getGamesWon();
//        String message = (player1.gamesWonX > player2.gamesWonO) ? "The winner is: X" : (player1.gamesWonX < player2.gamesWonO) ? "The winner is: O" : "Its a draw!";
//        return ("Player X: " + player1.gamesWonX + "\n" + " Player O: " + player2.gamesWonO + "\n" + message);
       // return new int[]{Integer.parseInt(player1.getGamesWon()), Integer.parseInt(player2.getGamesWon())};

        return ("Working on it...\n Please choose another option");
    }

    @Override
    boolean nextTurn() {
        int x, y;
        boolean ejecutado = false;
        Scanner input = new Scanner(System.in);
        if(!ejecutado){
            board.drawBoard();  // commented this line because it is duplicating the board.
            ejecutado = true; // instead of commenting i created a conditional just to appear once
        }
        System.out.println("Player " + currentPlayer.getSymbol() + " turn, enter the row and column: ");
        String rowInput = input.next();
        String colInput = input.next();

        if (isNumeric(rowInput) && isNumeric(colInput)) {
            x = Integer.parseInt(rowInput) - 1;
            y = Integer.parseInt(colInput) - 1;

            if (board.validateMove(x, y)) {
                board.updateBoard(x, y, currentPlayer.getSymbol());
                board.drawBoard();
                if (isGameOver()) {
                    //Created a new game to start over and to send the player to the main menu
                    Tictactoe newGame = new Tictactoe();
                    return true;
                }
                switchPlayer();
            } else {
                System.out.println("Invalid move, try again.");
            }
        } else {
            System.out.println("Invalid input, please enter numbers only for row and column.");
        }
        return false;
    }

    private boolean isNumeric(String number) {
        return number.matches("\\d");
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private boolean isWinner() {
        // Check rows
        for (int i = 0; i < board.size; i++) {
            char player = board.board[i][0];
            if (player != Symbol.EMPTY.getSymbol() && allEqual(player, board.board[i])) {
                return true;
            }
        }
        // Check columns
        for (int i = 0; i < board.size; i++) {
            char player = board.board[0][i];
            if (player != Symbol.EMPTY.getSymbol() && allEqual(player, getColumn(i))) {
                return true;
            }
        }
        // Check diagonals
        char player = board.board[0][0];
        if (player != Symbol.EMPTY.getSymbol() && allEqual(player, getDiagonal(true))) {
            return true;
        }

        player = board.board[0][board.size - 1];
        if (player != Symbol.EMPTY.getSymbol() && allEqual(player, getDiagonal(false))) {
            return true;
        }

        return false;
    }

    private static boolean allEqual(char player, char[] line) {
        for (char cell : line) {
            if (cell != player) {
                return false;
            }
        }
        return true;
    }

    private char[] getColumn(int col) {
        char[] column = new char[board.size];
        for (int i = 0; i < board.size; i++) {
            column[i] = board.board[i][col];
        }
        return column;
    }

    private char[] getDiagonal(boolean mainDiagonal) {
        char[] diagonal = new char[board.size];
        for (int i = 0; i < board.size; i++) {
            diagonal[i] = mainDiagonal ? board.board[i][i] : board.board[i][board.size - 1 - i];
        }
        return diagonal;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < board.size; i++) {
            for (int j = 0; j < board.size; j++) {
                if (board.board[i][j] == Symbol.EMPTY.getSymbol()) return false;
            }
        }
        return true;
    }

    // Created the getter for the typeGame
    public int getTypeGame() {
        return this.typeGame;
    }

}