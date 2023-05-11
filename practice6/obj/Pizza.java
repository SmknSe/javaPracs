package practice6.obj;

public class Pizza implements Food{
    private int numOfPieces;
    private double size;
    private boolean isTasty;

    public Pizza(boolean isTasty) {
        this.isTasty = isTasty;
    }

    public Pizza(int numOfPieces, double size) {
        this.numOfPieces = numOfPieces;
        this.size = size;
    }

    @Override
    public boolean isTasty() {
        return isTasty;
    }

    @Override
    public void makeTasty() {
        isTasty = true;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "numOfPieces=" + numOfPieces +
                ", size=" + size +
                ", isTasty=" + isTasty +
                '}';
    }
}
