public class User {

    char turn = 'X';
    int gamesWonX = 0;
    int gamesWonO = 0;

    public User(char turn) {
        this.turn = turn;
    }

    public User(char turn, int gamesWonX, int gamesWonO) {
        this.turn = turn;
        this.gamesWonX = gamesWonX;
        this.gamesWonO = gamesWonO;
    }

    public String getGamesWon() {
        String message = (this.gamesWonX > this.gamesWonO) ? "Ganador es: X" : (this.gamesWonX < this.gamesWonO) ? "Ganador es: O" : "Es un empate!";
        return ("Jugador X: " + this.gamesWonX + "\n" + " Jugador O: " + this.gamesWonO + "\n" + message);
    }

    public void setGamesWonX() {
        this.gamesWonX++;
    }

    public void setGamesWonO() {
        this.gamesWonO++;
    }

    public void setGames(char turn){
        if(turn == 'X'){
            setGamesWonX();
        }else{
            setGamesWonO();
        }
    }

    public void setTurn(char turn) {
        this.turn = turn;
    }

    public char getTurn() {
        return turn;
    }

}