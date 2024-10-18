import java.util.Scanner;

public class Game {
    static User currentPlayer = new User('X');
    static Board board = new Board(3, 3);

    int option = 0;

    public Game() {

    }

    public Game(int option) {
        this.option = option;
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean finish = true;
        while (finish) {
            System.out.println("Bienvenido, selecciona una de las opciones:");
            System.out.println("(1) - Iniciar");
            System.out.println("(2) - Puntuaciones");
            System.out.println("(3) - Terminar");
            System.out.println(" - - - - ");
            String option = scanner.next();
            if (option.matches("\\d+")) {
                int number = Integer.parseInt(option);

                switch (number) {
                    case 1:
                        start();
                        break;
                    case 2:
                        System.out.println(currentPlayer.getGamesWon());
                        break;
                    case 3:
                        byeBye(finish);
                        break;
                    default:
                        System.out.print("ingrese un valor correcto");
                        break;
                }
            }

        }

    }

    public void start() {
        while (true) {
            int[] move = board.getPlayerMove(currentPlayer);
            if (board.validateInput(move)) {

                board.setMove(move[0], move[1], currentPlayer.getTurn());
                board.drawBoard();

                if (board.isWinner()) {
                    System.out.println("¡Jugador " + currentPlayer.getTurn() + " gana!");
                    currentPlayer.setGames(currentPlayer.getTurn());

                    break;
                }

                if (board.isBoardFull()) {
                    System.out.println("¡Empate!");
                    break;
                }

                board.switchUser(currentPlayer);
            } else {
                System.out.println("Movimiento inválido. Intenta de nuevo.");
            }
        }
    }

    public boolean byeBye(boolean finish){
        System.out.println("Gracias por jugar.");
        System.exit(0);
        return finish = false;


    }
}

