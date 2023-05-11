package practice8.template;

public class StoneHouse extends Builder{
    @Override
    public void buildFloor() {
        System.out.println("Built stone floor");
    }

    @Override
    public void buildWalls() {
        System.out.println("Built stone walls");
    }

    @Override
    public void buildRoof() {
        System.out.println("Built stone roof");
    }
}
