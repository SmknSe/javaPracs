package practice6.Prototype;


import practice6.obj.Food;

public class SoupPrototype implements Prototype, Food {
    private boolean isTasty;

    @Override
    public Prototype clone() {
        SoupPrototype p = new SoupPrototype();
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
}
