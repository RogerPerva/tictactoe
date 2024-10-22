package TicTacToe;

public class Board {
    private char[][] board;
    int size;
    int gameType;


    public Board(int boardSize, int gameType) {
        this.size = boardSize;
        this.gameType = gameType;
        initializeBoard();
        drawBoard();
        if (gameType == 1) {
            System.out.println("GAME NORMAL +++++");
            initGame();
        } else {
            System.out.println("GAME INVERTED ------");
            initGame();
        }
    }

    public void initGame() {
        System.out.println("====Starting the game===");
        TicTacToeNormal ticTacToeNormal = new TicTacToeNormal(size, gameType, board);

        char currentPlayer = EnumPlayers.X.getValuePlayer();;

        while (true) {
            int[] move = ticTacToeNormal.getPlayerMove(currentPlayer); // Pasar el jugador actual
            if (validateInput(move)) {
                board[move[0]][move[1]] = currentPlayer;
                drawBoard();

                if (ticTacToeNormal.isWinner(size) && gameType == 1) { // Pasar el tablero
                    System.out.println("¡Player " + currentPlayer + " wins!");
                    break;
                }
                if(ticTacToeNormal.isWinner(size) && gameType == 2) {
                    System.out.println("¡Player " + currentPlayer + " loses!");
                    break;
                }

                if (isBoardFull()) {
                    System.out.println("¡Draw!");
                    break;
                }

                currentPlayer = (currentPlayer == EnumPlayers.X.getValuePlayer()) ? EnumPlayers.O.getValuePlayer(): EnumPlayers.X.getValuePlayer(); // change player

            } else {
                System.out.println("Invalid movement. Try again..");
            }
        }
    }

    private void initializeBoard() {
        board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '-';
            }
        }
    }

    private void drawBoard() {
        System.out.println("-----------------");
        for (int i = 0; i < size; i++) {
            System.out.print("| ");
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-----------------");
        }
    }

    private boolean isBoardFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean validateInput(int[] move) {
        int row = move[0];
        int col = move[1];
        return row >= 0 && row < size && col >= 0 && col < size && board[row][col] == '-';
    }
}