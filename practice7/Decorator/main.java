package practice7.Decorator;

public class main {
    public static void main(String[] args) {
        Car car = new BasicCar();
        System.out.println(car.getPrice());
        System.out.println(car.getDesc());

        car = new SportCar(car);
        System.out.println(car.getPrice());
        System.out.println(car.getDesc());
    }
}
