package practice6.AbstractFactory;

import practice6.obj.Food;
import practice6.obj.Pizza;
import practice6.obj.Soup;

public class FoodFactory implements AbstractFactory{
    @Override
    public Food create(String type, boolean isTasty) {
        if (type.equalsIgnoreCase("pizza")){
            return new Pizza(isTasty);
        }
        return new Soup(isTasty);
    }
}
