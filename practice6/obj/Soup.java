package practice6.obj;

public class Soup implements Food{
    private boolean isSalty;
    private double volume;
    private boolean isTasty;

    public Soup(boolean isTasty) {
        this.isTasty = isTasty;
    }

    public Soup(boolean isSalty, double volume) {
        this.isSalty = isSalty;
        this.volume = volume;
    }

    @Override
    public boolean isTasty() {
        return false;
    }

    @Override
    public void makeTasty() {
        isTasty = true;
    }

    @Override
    public String toString() {
        return "Soup{" +
                "isSalty=" + isSalty +
                ", volume=" + volume +
                ", isTasty=" + isTasty +
                '}';
    }
}
