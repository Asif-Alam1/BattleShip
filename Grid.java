public class Grid {
    private Square[][] grid = new Square[10][10];

    public Grid() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.grid[i][j] = new Square(i, (char) (j + 'A'));
            }
        }
    }

    public void displayGrid() {
        System.out.println("    A        B        C        D        E        F        G        H        I        J  ");
        for (int i = 9; i > -1; i--) {
            System.out.println((i)
                    + " ----------------------------------------------------------------------------------------");
            for (int j = 0; j < 10; j++) {
                System.out.print(" |" + grid[i][j].toString() + "|");
            }
            System.out.println();

        }
        System.out
                .println("  ----------------------------------------------------------------------------------------");
        System.out.println("    A        B        C        D        E        F        G        H        I        J  ");
    }

    public Square getSquare(char column, int row) {
        return grid[row][column - 'A'];
    }

}
