package practice6.Builder;

import practice6.obj.Food;

public class Director {
    private FoodBuilder builder;
    public Food construct(String type, boolean b){
        builder.buildPart(type);
        if (b) builder.makeTasty();
        return builder.getResult();
    }
}
