
public class Player {
    private String name;
    private Grid grid;
    private Ship[] fleet;

    public Player(String name) {
        this.name = name;
        fleet = new Ship[5];
        fleet[0] = new AircraftCarrier();
        fleet[1] = new Battleship();
        fleet[2] = new Cruiser();
        fleet[3] = new Destroyer();
        fleet[4] = new Submarine();
        grid = new Grid();
    }

    public String getName() {
        return name;
    }

    public void placeShip(Ship ship, char horizontal, int vertical, char direction) {
        Square square = grid.getSquare(horizontal, vertical);
        Square square2 = grid.getSquare(horizontal, vertical);

        if (ship.isAlive) {
            System.out.println("Ship is already placed");
            return;
        } else {
            if (direction == 'V') {
                if (vertical + ship.getNbOfSquares() > 10) {
                    System.out.println("Ship is out of bounds");
                    return;
                }
                for (int i = 0; i < ship.getNbOfSquares(); i++) {
                    if (square2.hasShip()) {
                        System.out.println("Square already has a ship");
                        return;
                    }
                    if (vertical + i < 9) {
                        square2 = grid.getSquare(horizontal, vertical + i + 1);
                    } else {
                        square2 = grid.getSquare(horizontal, vertical + i);
                    }
                }

                for (int i = 0; i < ship.getNbOfSquares(); i++) {
                    square.setHasShip(ship);
                    if (vertical + i < 9) {
                        square = grid.getSquare(horizontal, vertical + i + 1);
                    } else {
                        square = grid.getSquare(horizontal, vertical + i);
                    }
                }
            }
            if (direction == 'H') {
                if (horizontal + ship.getNbOfSquares() > 'J' + 1) {
                    System.out.println("Ship is out of bounds");
                    return;
                }

                for (int i = 0; i < ship.getNbOfSquares(); i++) {
                    if (square2.hasShip()) {
                        System.out.println("Square already has a ship");
                        return;
                    }
                    if (horizontal + i < 'J') {
                        square2 = grid.getSquare((char) (horizontal + i + 1), vertical);
                    } else {
                        square2 = grid.getSquare((char) (horizontal + i), vertical);
                    }
                }
                for (int i = 0; i < ship.getNbOfSquares(); i++) {
                    square.setHasShip(ship);
                    if (horizontal + i < 'J') {
                        square = grid.getSquare((char) (horizontal + i + 1), vertical);
                    } else {
                        square = grid.getSquare((char) (horizontal + i), vertical);
                    }
                }

            }

        }
        ship.setIsAlive();

    }

    public Ship getShip(int i) {
        return this.fleet[i];
    }

    public Grid getGrid() {
        return this.grid;
    }

    public Ship[] getFleet() {
        return this.fleet;
    }
}
