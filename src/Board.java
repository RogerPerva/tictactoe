import java.util.Scanner;

public class Board {
    int rows;
    int columns;
    char[][] board;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        board = new char[rows][columns];
        initializeBoard();
        drawBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.board[i][j] = '-';
            }
        }
    }

    public void drawBoard() {
        System.out.println("-------------");
        for (int i = 0; i < rows; i++) {
            System.out.print("| ");
            for (int j = 0; j < columns; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public int[] getPlayerMove(User currentPlayer) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("sdasdasd " + currentPlayer.getTurn() + ", ingresa tu movimiento (fila y columna): ");

        String row = scanner.next();
        // Use java libs to validate that the row input is a number
        if (!row.matches("\\d+")) {
            System.out.println("Fila inválida. Intenta de nuevo.");
            return getPlayerMove(currentPlayer);
        }

        int col = scanner.nextInt() - 1;
        return new int[]{Integer.parseInt(row), col};
    }

    public boolean validateInput(int[] move) {
        int row = move[0];
        int col = move[1];
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-';
    }

    public void switchUser(User currentPlayer) {
        currentPlayer.setTurn((currentPlayer.getTurn() == 'X') ? 'O' : 'X');
    }

    public boolean isWinner() {
        // Verificar filas
        for (int i = 0; i < rows; i++) {
            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }
        // Verificar columnas
        for (int j = 0; j < columns; j++) {
            if (board[0][j] != '-' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return true;
            }
        }
        // Verificar diagonales
        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        return false;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    //Colocamos un movimiento, le pasamos la posicion y el caracter
    public void setMove(int row, int col, char playerChar) {
        this.board[row][col] = playerChar;

    }

}

