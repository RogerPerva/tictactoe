package TicTacToe;

public enum EnumPlayers {
    X("PlayerX",'X'),
    O("PlayerO",'O');

    private String descriptionPlayer;
    private char valuePlayer;

    EnumPlayers(String descriptionPlayer, char valuePlayer) {
        this.descriptionPlayer = descriptionPlayer;
        this.valuePlayer = valuePlayer;
    }

    public String getDescriptionPlayer() {
        return descriptionPlayer;
    }

    public char getValuePlayer() {
        return valuePlayer;
    }

}
