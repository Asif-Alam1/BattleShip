import java.util.Random;
import java.util.Scanner;

public class Game {
    private Scanner in = new Scanner(System.in);
    private Square[] player1chosenSquare = new Square[100];
    private Square[] player2chosenSquare = new Square[100];
    private Player[] players = new Player[2];
    private int gameMode;
    private Player Winner = null;

    public Game() {

        System.out.println("Welcome to Battleship!");
        System.out.println("Please choose a game mode: ");
        System.out.println("1. Human vs Human");
        System.out.println("2. Human vs Computer");
        System.out.println("Please enter 1 or 2");
        int i = 0;
        char horizontal;
        int vertical;
        char direction;
        String input = in.next();
        gameMode = input.length() == 1 ? Character.getNumericValue(input.charAt(0)) : 0;

        while (gameMode != 1 && gameMode != 2) {
            System.err.println("Invalid input, please enter again");
            System.out.println("Please enter 1 or 2");
            input = in.next();
            gameMode = input.length() == 1 ? Character.getNumericValue(input.charAt(0)) : 0;
        }

        if (gameMode == 1) {
            System.out.println("Game mode 1: Human vs Human");
            in.nextLine();
            System.out.println("Player 1, please enter your name: ");
            players[0] = new Human(in.nextLine());
            System.out.println("Player 2, please enter your name: ");
            players[1] = new Human(in.nextLine());
            System.out.println("Let's start the game!");
            System.out.println(players[0].getName() + " please place your ships on the grid");
            do {

                do {
                    System.out.println("Please enter the coordinates of the first square of your "
                            + players[0].getShip(i).getClass().getSimpleName() + " of size "
                            + players[0].getShip(i).nbOfSquares);
                    System.out.println("char horizontal(A to J) ");
                    input = in.next();
                    horizontal = input.length() == 1 ? input.toUpperCase().charAt(0) : 'Z';
                    in.nextLine();
                    System.out.println("int vertical(0 to 9) ");
                    input = in.next();
                    vertical = input.length() == 1 ? Character.getNumericValue(input.charAt(0)) : 11;
                    in.nextLine();
                    System.out.println("char Direction (V or H) ");
                    input = in.next();
                    direction = input.length() == 1 ? input.toUpperCase().charAt(0) : 'Z';

                    while (horizontal < 'A' || horizontal > 'J' || vertical < 0 || vertical > 9
                            || (direction != 'V' && direction != 'H')) {
                        System.err.println("Invalid input, please enter again");
                        System.out.println("char horizontal(A to J) ");
                        input = in.next();
                        horizontal = input.length() == 1 ? input.toUpperCase().charAt(0) : 'Z';
                        in.nextLine();
                        System.out.println("int vertical(0 to 9) ");
                        input = in.next();
                        vertical = input.length() == 1 ? Character.getNumericValue(input.charAt(0)) : 11;
                        in.nextLine();
                        System.out.println("char Direction (V or H) ");
                        input = in.next();
                        direction = input.length() == 1 ? input.toUpperCase().charAt(0) : 'Z';

                    }

                    players[0].placeShip(players[0].getShip(i), horizontal, vertical, direction);

                } while (players[0].getShip(i).isAlive == false);

                players[0].getGrid().displayGrid();
                i++;
            } while (players[0].getShip(players[0].getFleet().length - 1).isAlive == false);

            System.out.println(players[1].getName() + " , please place your ships on the grid");
            i = 0;
            do {

                do {
                    System.out.println("Please enter the coordinates of the first square of your "
                            + players[1].getShip(i).getClass().getSimpleName() + " of size "
                            + players[1].getShip(i).nbOfSquares);
                    System.out.println("char horizontal(A to J) ");
                    input = in.next();
                    horizontal = input.length() == 1 ? input.toUpperCase().charAt(0) : 'Z';
                    in.nextLine();
                    System.out.println("int vertical(0 to 9) ");
                    input = in.next();
                    vertical = input.length() == 1 ? Character.getNumericValue(input.charAt(0)) : 11;
                    in.nextLine();
                    System.out.println("char Direction (V or H) ");
                    input = in.next();
                    direction = input.length() == 1 ? input.toUpperCase().charAt(0) : 'Z';

                    while (horizontal < 'A' || horizontal > 'J' || vertical < 0 || vertical > 9
                            || (direction != 'V' && direction != 'H')) {
                        System.err.println("Invalid input, please enter again");
                        System.out.println("char horizontal(A to J) ");
                        input = in.next();
                        horizontal = input.length() == 1 ? input.toUpperCase().charAt(0) : 'Z';
                        in.nextLine();
                        System.out.println("int vertical(0 to 9) ");
                        input = in.next();
                        vertical = input.length() == 1 ? Character.getNumericValue(input.charAt(0)) : 11;
                        in.nextLine();
                        System.out.println("char Direction (V or H) ");
                        input = in.next();
                        direction = input.length() == 1 ? input.toUpperCase().charAt(0) : 'Z';
                    }

                    players[1].placeShip(players[1].getShip(i), horizontal, vertical, direction);

                } while (players[1].getShip(i).isAlive == false);

                players[1].getGrid().displayGrid();
                i++;
            } while (players[1].getShip(players[1].getFleet().length - 1).isAlive == false);
            System.out.println("Let's start the game!");

        } else if (gameMode == 2) {
            System.out.println("Game mode 2 player vs Computer");
            System.out.println("Player, please enter your name: ");
            in.nextLine();
            players[0] = new Human(in.nextLine());
            players[1] = new Computer();
            System.out.println(players[0].getName() + " please place your ships on the grid");
            do {

                do {
                    System.out.println("Please enter the coordinates of the first square of your "
                            + players[0].getShip(i).getClass().getSimpleName() + " of size "
                            + players[0].getShip(i).nbOfSquares);
                    System.out.println("char horizontal(A to J) ");
                    input = in.next();
                    horizontal = input.length() == 1 ? input.toUpperCase().charAt(0) : 'Z';
                    in.nextLine();
                    System.out.println("int vertical(0 to 9) ");
                    input = in.next();
                    vertical = input.length() == 1 ? Character.getNumericValue(input.charAt(0)) : 11;
                    in.nextLine();
                    System.out.println("char Direction (V or H) ");
                    input = in.next();
                    direction = input.length() == 1 ? input.toUpperCase().charAt(0) : 'Z';

                    while (horizontal < 'A' || horizontal > 'J' || vertical < 0 || vertical > 9
                            || (direction != 'V' && direction != 'H')) {
                        System.err.println("Invalid input, please enter again");
                        System.out.println("char horizontal(A to J) ");
                        input = in.next();
                        horizontal = input.length() == 1 ? input.toUpperCase().charAt(0) : 'Z';
                        in.nextLine();
                        System.out.println("int vertical(0 to 9) ");
                        input = in.next();
                        vertical = input.length() == 1 ? Character.getNumericValue(input.charAt(0)) : 11;
                        System.out.println("char Direction (V or H) ");
                        input = in.next();
                        direction = input.length() == 1 ? input.toUpperCase().charAt(0) : 'Z';

                    }

                    players[0].placeShip(players[0].getShip(i), horizontal, vertical, direction);

                } while (players[0].getShip(i).isAlive == false);

                players[0].getGrid().displayGrid();
                i++;
            } while (players[0].getShip(players[0].getFleet().length - 1).isAlive == false);
            i = 0;

            do {
                do {
                    Random random = new Random();
                    horizontal = (char) (random.nextInt(10) + 'A');
                    vertical = random.nextInt(10);
                    direction = (random.nextInt(2) == 0) ? 'V' : 'H';
                    players[1].placeShip(players[1].getShip(i), horizontal, vertical, direction);

                } while (players[1].getShip(i).isAlive == false);

                i++;
            } while (players[1].getShip(players[1].getFleet().length - 1).isAlive == false);
            System.out.println("Let's start the game!");

        }

    }

    public void play() {
        int i = 0;
        char horizontal;
        int vertical;
        Square chosenSquare = null;
        int currentPlayerIndex = (Math.random() < 0.5) ? 0 : 1;
        String input;
        int ships1 = 0;
        int ships2 = 0;

        do {
            Player currentPlayer = players[currentPlayerIndex];
            Player otherPlayer = players[(currentPlayerIndex + 1) % 2];

            if (gameMode == 1) {

                do {
                    System.out.println();
                    System.out.println(
                            currentPlayer.getName() + " Please input the coordinates of the square you want to strike");
                    System.out.println();
                    System.out.println("char horizontal(A to J) ");
                    input = in.next();
                    horizontal = input.length() == 1 ? input.toUpperCase().charAt(0) : 'Z';
                    in.nextLine();
                    System.out.println("int vertical(0 to 9) ");
                    input = in.next();
                    vertical = input.length() == 1 ? Character.getNumericValue(input.charAt(0)) : 11;

                    while (horizontal < 'A' || horizontal > 'J' || vertical < 0 || vertical > 9) {
                        System.err.println("Invalid input, please enter again");
                        System.out.println();
                        System.out.println("char horizontal(A to J) ");
                        input = in.next();
                        horizontal = input.length() == 1 ? input.toUpperCase().charAt(0) : 'Z';
                        in.nextLine();
                        System.out.println("char vertical(0 to 9)  ");
                        input = in.next();
                        vertical = input.length() == 1 ? Character.getNumericValue(input.charAt(0)) : 11;
                    }
                    chosenSquare = otherPlayer.getGrid().getSquare(horizontal, vertical);
                    if (chosenSquare.isActive() == false) {
                        System.out.println("This square has already been chosen. Please choose another square.");
                    }
                } while (chosenSquare.isActive() == false);

                player1chosenSquare[i] = chosenSquare;
                player1chosenSquare[i].setIsActive();
                if (player1chosenSquare[i].hasShip()) {
                    System.out.println("You hit a ship!");
                    player1chosenSquare[i].getShip().countHits++;

                    if (player1chosenSquare[i].getShip().countHits == player1chosenSquare[i].getShip().nbOfSquares) {
                        player1chosenSquare[i].getShip().isAlive = false;
                        System.out.println("You sank a ship!");
                        ships1++;
                    }
                    if (ships1 == 5) {
                        System.out.println(currentPlayer.getName() + " is the winner!");
                        Winner = currentPlayer;
                        return;

                    }
                } else {
                    System.out.println("You missed!");
                }
                do {
                    System.out.println();
                    System.out.println(
                            otherPlayer.getName() + " Please input the coordinates of the square you want to strike");
                    System.out.println();
                    System.out.println("char horizontal(A to J) ");
                    input = in.next();
                    horizontal = input.length() == 1 ? input.toUpperCase().charAt(0) : 'Z';
                    in.nextLine();
                    System.out.println("int vertical(0 to 9) ");
                    input = in.next();
                    vertical = input.length() == 1 ? Character.getNumericValue(input.charAt(0)) : 11;

                    while (horizontal < 'A' || horizontal > 'J' || vertical < 0 || vertical > 9) {
                        System.err.println("Invalid input, please enter again");
                        System.out.println();
                        System.out.println("char horizontal(A to J) ");
                        input = in.next();
                        horizontal = input.length() == 1 ? input.toUpperCase().charAt(0) : 'Z';
                        in.nextLine();
                        System.out.println("int vertical(0 to 9) ");
                        input = in.next();
                        vertical = input.length() == 1 ? Character.getNumericValue(input.charAt(0)) : 11;
                    }
                    chosenSquare = currentPlayer.getGrid().getSquare(horizontal, vertical);
                    if (chosenSquare.isActive() == false) {
                        System.out.println("This square has already been chosen. Please choose another square.");
                    }
                } while (chosenSquare.isActive() == false);

                player2chosenSquare[i] = chosenSquare;
                player2chosenSquare[i].setIsActive();
                if (player2chosenSquare[i].hasShip()) {
                    System.out.println("You hit a ship!");
                    player2chosenSquare[i].getShip().countHits++;

                    if (player2chosenSquare[i].getShip().countHits == player2chosenSquare[i].getShip().nbOfSquares) {
                        player2chosenSquare[i].getShip().isAlive = false;
                        System.out.println("You sank a ship!");
                        ships2++;
                    }
                    if (ships2 == 5) {
                        System.out.println(otherPlayer.getName() + " is the winner!");
                        Winner = otherPlayer;
                        return;
                    }
                } else {
                    System.out.println("You missed!");
                }
                i++;

            } else if (gameMode == 2) {

                currentPlayer = players[0];
                otherPlayer = players[1];

                do {

                    System.out.println(
                            currentPlayer.getName() + " Please input the coordinates of the square you want to strike");
                    System.out.println();
                    System.out.println("char horizontal(A to J) ");
                    input = in.next();
                    horizontal = input.length() == 1 ? input.toUpperCase().charAt(0) : 'Z';
                    in.nextLine();
                    System.out.println("int vertical(0 to 9) ");
                    input = in.next();
                    vertical = input.length() == 1 ? Character.getNumericValue(input.charAt(0)) : 11;

                    while (horizontal < 'A' || horizontal > 'J' || vertical < 0 || vertical > 9) {
                        System.err.println("Invalid input, please enter again");
                        System.out.println();
                        System.out.println("char horizontal(A to J) ");
                        input = in.next();
                        horizontal = input.length() == 1 ? input.toUpperCase().charAt(0) : 'Z';
                        in.nextLine();
                        System.out.println("int vertical(0 to 9) ");
                        input = in.next();
                        vertical = input.length() == 1 ? Character.getNumericValue(input.charAt(0)) : 11;
                    }

                    chosenSquare = otherPlayer.getGrid().getSquare(horizontal, vertical);
                    if (chosenSquare.isActive() == false) {
                        System.out.println("This square has already been chosen. Please choose another square.");
                    }
                } while (chosenSquare.isActive() == false);

                player1chosenSquare[i] = chosenSquare;
                player1chosenSquare[i].setIsActive();
                if (player1chosenSquare[i].hasShip()) {
                    System.out.println("You hit a ship!");
                    player1chosenSquare[i].getShip().countHits++;

                    if (player1chosenSquare[i].getShip().countHits == player1chosenSquare[i].getShip().nbOfSquares) {
                        player1chosenSquare[i].getShip().isAlive = false;
                        System.out.println("You sank a ship!");
                        ships1++;
                    }
                    if (ships1 == 5) {
                        System.out.println(currentPlayer.getName() + " is the winner!");
                        Winner = currentPlayer;
                        return;
                    }
                } else {
                    System.out.println("You missed!");

                }
                do {

                    System.out.println(
                            "Computers turn, please wait");
                    Random random = new Random();
                    horizontal = (char) (random.nextInt(10) + 'A');
                    vertical = random.nextInt(10);
                    chosenSquare = currentPlayer.getGrid().getSquare(horizontal, vertical);

                } while (chosenSquare.isActive() == false);

                player2chosenSquare[i] = chosenSquare;
                System.out.println("Computer chose " + player2chosenSquare[i].getRow()
                        + player2chosenSquare[i].getColumn());
                player2chosenSquare[i].setIsActive();
                if (player2chosenSquare[i].hasShip()) {
                    System.out.println("Computer hit a ship!");
                    player2chosenSquare[i].getShip().countHits++;

                    if (player2chosenSquare[i].getShip().countHits == player2chosenSquare[i].getShip().nbOfSquares) {
                        player2chosenSquare[i].getShip().isAlive = false;
                        System.out.println("Computer sank a ship!");
                        ships2++;
                    }
                    if (ships2 == 5) {
                        System.out.println("Computer is the winner!");
                        Winner = otherPlayer;
                        return;
                    }
                } else {
                    System.out.println("Computer missed!");
                }

            }

        } while (Winner == null);
    }

    public Player getWinner() {
        return Winner;
    }

    public static void main(String[] args) {

        Game game;

        try {
            game = new Game();
        } catch (Exception e) {
            System.err.println("Fatal error occured game is going to restart");
            game = new Game();
        }

        try {
            game.play();
        } catch (Exception e) {
            System.err.println("Fatal error occured game is going to restart with the same players and grid ");
            game.play();
        }

    }
}
