//import java.util.Scanner;
//-------------- Commented everything because we don't need it anymore
//public class TicTacToeInverted extends Game{
//
//
//    public TicTacToeInverted(int size) {
//        super(size);
//        this.player1 = new Player(Symbol.X);
//        this.player2 = new Player(Symbol.O);
//        this.currentPlayer = player1;
//    }
//
//    @Override
//    boolean isGameOver() {
//        // Comprobar si hay un ganador
//        if (isLoser()) {
//            System.out.println("Player " + currentPlayer.getSymbol() + " loses!");
//            return true;
//        }
//        // Comprobar si el tablero está lleno
//        if (isBoardFull()){
//            System.out.println("It's a tie!");
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    boolean nextTurn() {
//        int x, y;
//        Scanner input = new Scanner(System.in);
//        board.drawBoard();
//        System.out.println("Player " + currentPlayer.getSymbol() + " turn, enter the row and column: ");
//        String rowInput = input.next();
//        String colInput = input.next();
//
//        if(isNumeric(rowInput) && isNumeric(colInput)){
//            x = Integer.parseInt(rowInput)-1;
//            y= Integer.parseInt(colInput)-1;
//
//            if(board.validateMove(x, y)){
//                board.updateBoard(x, y, currentPlayer.getSymbol());
//                board.drawBoard();
//                if(isGameOver()){
//                    return true;
//                }
//                switchPlayer();
//            }else {
//                System.out.println("Invalid move, try again.");
//            }
//        }else {
//            System.out.println("Invalid input, please enter numbers only for row and column.");
//        }
//        return false;
//    }
//
//    private boolean isNumeric(String number) {
//        return number.matches("\\d");
//    }
//
//    private void switchPlayer(){
//        currentPlayer = (currentPlayer == player1) ? player2 : player1;
//    }
//
//    private boolean isLoser() {
//        // Check rows
//        for (int i = 0; i < board.size; i++) {
//            char player = board.board[i][0];
//            if (player != Symbol.EMPTY.getSymbol() && allEqual(player, board.board[i])) {
//                return true;
//            }
//        }
//        // Check columns
//        for (int i = 0; i < board.size; i++) {
//            char player = board.board[0][i];
//            if (player != Symbol.EMPTY.getSymbol() && allEqual(player, getColumn(i))) {
//                return true;
//            }
//        }
//        // Check diagonals
//        char player = board.board[0][0];
//        if (player != Symbol.EMPTY.getSymbol() && allEqual(player, getDiagonal(true))) {
//            return true;
//        }
//
//        player = board.board[0][board.size - 1];
//        return player != Symbol.EMPTY.getSymbol() && allEqual(player, getDiagonal(false));
//    }
//
//    private static boolean allEqual(char player, char[] line) {
//        for (char cell : line) {
//            if (cell != player) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private char[] getColumn(int col) {
//        char[] column = new char[board.size];
//        for (int i = 0; i < board.size; i++) {
//            column[i] = board.board[i][col];
//        }
//        return column;
//    }
//
//    private char[] getDiagonal(boolean mainDiagonal) {
//        char[] diagonal = new char[board.size];
//        for (int i = 0; i < board.size; i++) {
//            diagonal[i] = mainDiagonal ? board.board[i][i] : board.board[i][board.size - 1 - i];
//        }
//        return diagonal;
//    }
//
//    private boolean isBoardFull() {
//        for (int i = 0; i < board.size; i++) {
//            for (int j = 0; j < board.size; j++) {
//                if (board.board[i][j] == Symbol.EMPTY.getSymbol()) return false;
//            }
//        }
//        return true;
//    }
//}
