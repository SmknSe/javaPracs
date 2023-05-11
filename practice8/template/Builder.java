package practice8.template;

public abstract class Builder {
    public void build(){
        buildFloor();
        buildWalls();
        buildRoof();
    }

    public void buildFloor(){}

    public void buildWalls(){}
    public void buildRoof(){}
}
