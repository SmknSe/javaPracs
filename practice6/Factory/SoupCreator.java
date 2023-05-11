package practice6.Factory;

import practice6.obj.Food;
import practice6.obj.Soup;

public class SoupCreator extends Creator{
    @Override
    public Food factoryMethod(boolean isTasty) {
        return new Soup(isTasty);
    }
}
