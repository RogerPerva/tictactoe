import java.util.Scanner;

public abstract class Game {
    Board board;
    Player player1, player2, currentPlayer;
    int typeGame; // I added the type in here because is part of the game.

    public Game(int size) {
        this.board = new Board(size);
    }

    //Created the empty constructor to use getScore in the Tictactoe's class
    public Game() {
    }

    public void play() {
        while (!nextTurn()) {
            nextTurn();
        }
    }

    abstract boolean nextTurn();

    abstract boolean isGameOver();

    abstract String gamesScore();
}