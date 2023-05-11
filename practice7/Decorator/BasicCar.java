package practice7.Decorator;

public class BasicCar implements Car{
    @Override
    public double getPrice() {
        return 1000;
    }

    @Override
    public String getDesc() {
        return "BasicCar ";
    }
}
