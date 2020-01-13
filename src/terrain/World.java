package terrain;

import java.util.ArrayList;
import java.util.List;

public class World {
    public ArrayList<List<Sector>> data;

    public World() {
        data = new ArrayList<List<Sector>>(10);
        for (int xw=0; xw < 10; xw++) {
            ArrayList<Sector> sectorRow = new ArrayList<Sector>();
            data.add(sectorRow);
            for (int yw = 0; yw < 10; yw++) {
                Sector s = new Sector(this);
                sectorRow.add(s);
                for (int xs = 0; xs < 25; xs++) {
                    for (int ys = 0; ys < 10; ys++) {
                        data.get(xw).get(yw).setCell(xs, ys, false);
                    }
                }
            }
        }
    }

    public World(int numSectors) {
        data = new ArrayList<List<Sector>>(numSectors);
        for (int xw=0; xw < numSectors; xw++) {
            ArrayList<Sector> sectorRow = new ArrayList<Sector>();
            data.add(sectorRow);
            for (int yw = 0; yw < numSectors; yw++) {
                Sector s = new Sector();
                sectorRow.add(s);
                for (int xs = 0; xs < 25; xs++) {
                    for (int ys = 0; ys < 25; ys++) {
                        data.get(xw).get(yw).setCell(xs, ys, false);
                    }
                }
            }
        }
    }

    public static Sector asSector(World data) {
        Sector sector = new Sector(data.getSectorSize()*data.getSectorRowSize());
        for (int yw=0; yw<data.getSectorRowSize(); yw++) {
            for (int ys=0; ys<data.getSector(0, 0).size(); ys++) {
                for (int xw=0; xw<data.getSectorRowSize(); xw++) {
                    for (int xs=0; xs<data.getSector(0, 0).size(); xs++) {
                        int x = (xw*data.getSector(0, 0).size())+xs;
                        int y = (yw*data.getSector(0, 0).size())+ys;
                        sector.setCell(x, y, data.getSector(xw, yw).getCell(xs, ys));
                    }
                }
            }
        }
        return sector;
    }

    //TODO
    public void generate() {
        for (int x=0; x<this.getSectorRowSize(); x++) {
            for (int y=0; y<this.getSectorRowSize(); y++) {
                Transform.populateRandom(this.getSector(x, y));
                Transform.generateWalls(this.getSector(x, y));
            }
        }
    }

    public int getSectorSize() {
        return this.getSector(0, 0).size();
    }

    public int getSectorRowSize() {
        return this.data.get(0).size();
    }

    public Sector getSector(int x, int y) {
        return this.data.get(x).get(y);
    }
    public void setSector(int x, int y, Sector data) { this.data.get(x).set(y, data);}
}
