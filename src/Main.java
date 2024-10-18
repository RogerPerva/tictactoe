//import java.util.Scanner;

public class Main {
//    static User currentPlayer = new User('X');
//    static Board board = new Board(3,3);

//    private static char[][] board = new char[3][3];
    //private static char currentPlayer = 'X';

    public static void main(String[] args) {

//        initializeBoard();
//        drawBoard();
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
        Game newGame = new Game();
        newGame.menu();
    }
}

//        while (true) {
//            int[] move = board.getPlayerMove(currentPlayer);
//            if (board.validateInput(move)) {
//
//                board.setMove(move[0], move[1], currentPlayer.getTurn());
//                board.drawBoard();
//
//                if (board.isWinner()) {
//                    System.out.println("¡Jugador " + currentPlayer + " gana!");
//                    break;
//                }
//
//                if (board.isBoardFull()) {
//                    System.out.println("¡Empate!");
//                    break;
//                }
//
//                board.switchUser(currentPlayer);
//            } else {
//                System.out.println("Movimiento inválido. Intenta de nuevo.");
//            }
//        }
//    }

    //creado:s-----------------------------------------------------------
//    private static void initializeBoard() {
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                board.setMove(move[0], move[1], '-');
//            }
//        }
//    }
//
//    //creado:s-----------------------------------------------------------
//    private static void drawBoard() {
//        System.out.println("-------------");
//        for (int i = 0; i < 3; i++) {
//            System.out.print("| ");
//            for (int j = 0; j < 3; j++) {
//                System.out.print(board[i][j] + " | ");
//            }
//            System.out.println("\n-------------");
//        }
//    }
////------------------------------------------------
//    private static int[] getPlayerMove() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Jugador " + currentPlayer + ", ingresa tu movimiento (fila y columna): ");
//
//        String row = scanner.next();
//        // Use java libs to validate that the row input is a number
//        if (!row.matches("\\d+")) {
//            System.out.println("Fila inválida. Intenta de nuevo.");
//            return getPlayerMove();
//        }
//
//        int col = scanner.nextInt() - 1;
//        return new int[]{Integer.parseInt(row), col};
//    }
//
////------------------------------------------------
//    private static boolean validateInput(int[] move) {
//        int row = move[0];
//        int col = move[1];
//        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-';
//    }
//
////------------------------------------------------
//    private static void switchUser() {
//        currentPlayer.setTurn((currentPlayer.getTurn() == 'X') ? 'O' : 'X');
//    }
//
////------------------------------------------------
//    private static boolean isWinner() {
//        // Verificar filas
//        for (int i = 0; i < 3; i++) {
//            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
//                return true;
//            }
//        }
//
//        // Verificar columnas
//        for (int j = 0; j < 3; j++) {
//            if (board[0][j] != '-' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
//                return true;
//            }
//        }
//
//        // Verificar diagonales
//        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
//            return true;
//        }
//        if (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
//            return true;
//        }
//
//        return false;
//    }
//
//    private static boolean isBoardFull() {
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                if (board[i][j] == '-') {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
