import java.util.Scanner;

public class Tictactoe {
TicTacToeNormal getScore = new TicTacToeNormal();

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What size do you want the board?");
        String size = scanner.next();

        if (validateIfNumber(size)) {
            int sizeNumber = convertToNumber(size);
            System.out.println("Choose the type game \n1.-Normal \n2.-Inverted");
            String type = scanner.next();
            if (validateIfNumber(type)) {
                int typeNumber = convertToNumber(type);
                TicTacToeNormal normal = new TicTacToeNormal(sizeNumber, typeNumber);

                normal.play();
            }
        } else {
            System.out.println("Please enter a valid number.");
        }
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean finish = true;
        while (finish) {
            System.out.println("Welcome, please choose one of the following options:");
            System.out.println("(1) - Start");
            System.out.println("(2) - Score");
            System.out.println("(3) - Exit");
            System.out.println(" - - - - ");
            String option = scanner.next();

            if (validateIfNumber(option)) {
                int number = convertToNumber(option);

                switch (number) {
                    case 1:
                        start();
                        break;
                    case 2:
                       System.out.print(getScore.gamesScore());
                        break;
                    case 3:
                        byeBye(finish);
                        break;
                    default:
                        System.out.print("Enter a correct value");
                        break;
                }
            } else {
                System.out.println("Enter a valid number.");
            }

        }

    }

    public Tictactoe() {
    }

    public boolean byeBye(boolean finish) {
        System.out.println("Thanks for playing.");
        System.exit(0);

        return finish = false;
    }

    public boolean validateIfNumber(String number) {
        return number.matches("\\d+");
    }

    public int convertToNumber(String number) {
        return Integer.parseInt(number);

    }

}
