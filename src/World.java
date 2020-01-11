import java.util.ArrayList;
import java.util.List;

public class World {
    private ArrayList<List<Sector>> data;

    public World() {
        data = new ArrayList<List<Sector>>(10);
        for (int xw=0; xw < 10; xw++) {
            ArrayList<Sector> sectorRow = new ArrayList<Sector>();
            data.add(sectorRow);
            for (int yw = 0; yw < 10; yw++) {
                Sector s = new Sector();
                sectorRow.add(s);
                for (int xs = 0; xs < 25; xs++) {
                    for (int ys = 0; ys < 10; ys++) {
                        data.get(xw).get(yw).setCell(xs, ys, false);
                        //System.out.println(data.get(xw).get(yw).data.get(xs).get(ys));
                    }
                }
            }
        }
    }

    public Sector asSector(World data) {
        return new Sector();
    }
}
