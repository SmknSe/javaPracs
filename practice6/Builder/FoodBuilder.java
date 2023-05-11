package practice6.Builder;

import practice6.obj.Food;
import practice6.obj.Pizza;
import practice6.obj.Soup;

public class FoodBuilder implements Builder{
    private Food food;
    private boolean isTasty;
    @Override
    public FoodBuilder buildPart(String type) {
        if (type.equalsIgnoreCase("pizza")){
            food = new Pizza(false);
        }
        food = new Soup(false);
        return this;
    }

    @Override
    public Builder makeTasty() {
        food.makeTasty();
        return this;
    }

    public Food getResult(){
        return food;
    }


}
