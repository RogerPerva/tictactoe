public class Player {
    private final Symbol symbol;
    int gamesWonX = 0;
    int gamesWonO = 0;


    public Player(Symbol symbol) {
        this.symbol = symbol;
    }

    public Symbol getSymbol() {
        return symbol;
    }

//    public String getGamesWon() {
//        String message = (this.gamesWonX > this.gamesWonO) ? "The winner is: X" : (this.gamesWonX < this.gamesWonO) ? "The winner is: O" : "Its a draw!";
//        return ("Player X: " + this.gamesWonX + "\n" + " Player O: " + this.gamesWonO + "\n" + message);
//    }

    public void setGamesWonX() {
        this.gamesWonX++;
    }

    public void setGamesWonO() {
        this.gamesWonO++;
    }

}
