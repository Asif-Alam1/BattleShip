public abstract class Ship {
    protected String name;
    protected int nbOfSquares;
    protected int countHits = 0;
    protected boolean isAlive = false;

    public Ship(String name, int nbOfSquares) {
        this.nbOfSquares = nbOfSquares;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setIsAlive() {
        this.isAlive = !this.isAlive;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public int getNbOfSquares() {
        return nbOfSquares;
    }

}
