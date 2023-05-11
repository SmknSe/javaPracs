package practice8.template;

public class WoodHouse extends Builder{
    @Override
    public void buildFloor() {
        System.out.println("Built wooden floor");
    }

    @Override
    public void buildWalls() {
        System.out.println("Built wooden walls");
    }

    @Override
    public void buildRoof() {
        System.out.println("Built wooden roof");
    }
}
