package practice6.Factory;

import practice6.obj.Food;

public abstract class Creator {
    public abstract Food factoryMethod(boolean isTasty);
}
