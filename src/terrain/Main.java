package terrain;

public class Main {
    public static void main(String[] args) {
        World world = new World();
        Sector sector = new Sector();
        world.generate();
        View.printSector(world.getSector(0, 0));
        View.drawWorld(world);
    }
}
