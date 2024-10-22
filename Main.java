package TicTacToe;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        int size;
        int gameType;

        InitialMenu menu = new InitialMenu();
            size= menu.selectBoardSize().getBoardSize();
            gameType = menu.selectGameType().getValueGameType();
        Board board = new Board(size,gameType);
    }

    static class InitialMenu{
        private Scanner scanner = new Scanner(System.in);
        private EnumBoardSize selectedBoardSize = null;
        private EnumGameType selectedGameType = null;


        private EnumBoardSize selectBoardSize(){

            while (selectedBoardSize == null) {
                System.out.println("Select board size::");
                for (EnumBoardSize size : EnumBoardSize.values()) {//Loops through enum and shows options
                    System.out.println(size.ordinal() + 1 + ". " + size.getDescription());
                }

                System.out.print("Enter your option (1-" + EnumBoardSize.values().length + "): "); //Request "board size" option from the user
                int option1 = scanner.nextInt();

                if (option1 >= 1 && option1 <= EnumBoardSize.values().length) {//Validates that the selected option exists in the ENUM
                    selectedBoardSize = EnumBoardSize.values()[option1 - 1];
                    System.out.println("You have selected: " + selectedBoardSize.getDescription() + " with size " + selectedBoardSize.getBoardSize());
                } else {
                    System.out.println("Opción inválida. Intente de nuevo.");
                }
            }
            return selectedBoardSize;
        }

        private EnumGameType selectGameType(){
            while(selectedGameType == null){
                System.out.println("Select game type:");
                for(EnumGameType typeGame : EnumGameType.values()){
                    System.out.println(typeGame.ordinal() + 1 +". " + typeGame.getDescriptionGameType());
                }

                System.out.print("Enter your option(1-" + EnumBoardSize.values().length + "): ");
                int option2 = scanner.nextInt();

                if (option2 >= 1 && option2 <= EnumGameType.values().length) {
                    selectedGameType = EnumGameType.values()[option2 - 1];
                    System.out.println("You have selected: " + selectedGameType.getDescriptionGameType() + " with type " + selectedGameType.getValueGameType());
                } else {
                    System.out.println("Invalid option. Try again.");
                }
            }
            return selectedGameType;
        }
    }
}







