package practice6.Prototype;

import practice6.obj.Food;

public class PizzaPrototype implements Prototype, Food {
    private boolean isTasty;
    @Override
    public Prototype clone() {
        PizzaPrototype p = new PizzaPrototype();
        p.isTasty = isTasty;
        return p;
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
        return "PizzaPrototype{" +
                "isTasty=" + isTasty +
                '}';
    }
}
