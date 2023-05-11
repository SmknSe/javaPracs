package practice7.Lightweight;

import java.util.HashMap;

public class DrinkFactory {
    private static HashMap<String,Drink> drinks = new HashMap<>();

    public static Drink getDrink(String type){
        Drink drink = drinks.get(type.toLowerCase());
        if (drink==null){
            if (type.equalsIgnoreCase("tea")) drink = new Tea();
            else drink = new Coffe();
            drinks.put(type.toLowerCase(),drink);
        }
        return drink;
    }
}
