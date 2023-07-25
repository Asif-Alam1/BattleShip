public class Square {
    private char horizontal;
    private int vertical;
    private boolean hasShip = false;
    private Ship ship = null;
    private boolean isActive = false;

    public Square(int vertical, char horizontal) {
        this.vertical = vertical;
        this.horizontal = horizontal;
        this.isActive = true;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public int getColumn() {
        return vertical;
    }

    public char getRow() {
        return horizontal;
    }

    public boolean hasShip() {
        return hasShip;
    }

    public void setIsActive() {
        this.isActive = false;
    }

    public void setHasShip(Ship ship) {
        this.hasShip = true;
        this.ship = ship;
    }

    @Override
    public String toString() {
        if (hasShip) {
            if (this.isActive == false) {

                return "X" + ship.name + "X";

            } else {

                return "**" + ship.name + "**";
            }

        } else {
            return " **** ";
        }

    }

    public Ship getShip() {
        return this.ship;
    }
}
