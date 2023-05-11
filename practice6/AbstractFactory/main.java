package practice6.AbstractFactory;

import practice6.obj.Food;

public class main {

    public static void main(String[] args) {
        AbstractFactory factory = new FoodFactory();
        System.out.println(factory.create("pizza",true));
        System.out.println(factory.create("soup",false));
    }
}
