public class Board {
    int size;
    char [][] board;

    public Board(int size){
        this.size = size;
        board = new char[size][size];
        initBoard();
    }

    public void drawBoard(){
        System.out.println("-------------");
        for (int i = 0; i < size; i++) {
            System.out.print("| ");
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }
    public void initBoard(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = Symbol.EMPTY.getSymbol();
            }
        }
    }

    public void updateBoard(int x, int y, Symbol symbol){
        board[x][y] = symbol.getSymbol();
    }

    public boolean validateMove(int x, int y){
        return x >= 0 && x < size && y >= 0 && y < size && board[x][y] == Symbol.EMPTY.getSymbol();
    }
}