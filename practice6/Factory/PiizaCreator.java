package practice6.Factory;

import practice6.obj.Food;
import practice6.obj.Pizza;

public class PiizaCreator extends Creator{
    @Override
    public Food factoryMethod(boolean isTasty) {
        return new Pizza(isTasty);
    }
}
