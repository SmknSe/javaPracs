package practice7.Decorator;

public class SportCar implements Car{
    protected Car car;

    public SportCar(Car car) {
        this.car = car;
    }

    @Override
    public double getPrice() {
        return car.getPrice()+5000;
    }

    @Override
    public String getDesc() {
        return car.getDesc()+"-> SportCar";
    }
}
