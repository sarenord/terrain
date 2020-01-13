package terrain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sector {
	public ArrayList<ArrayList<Boolean>> data;
	public World parent = null;
	public String ID = null;

	public Sector() {
		ArrayList<ArrayList<Boolean>> data = new ArrayList<ArrayList<Boolean>>();
		for (int i=0; i<25; i++) {
			ArrayList<Boolean> row = new ArrayList(25);
			for (int j=0; j<25; j++) {
				row.add(false);
			}
			data.add(row);
		}
		this.data = data;
	}

	public Sector(int size, String id) {
		ArrayList<ArrayList<Boolean>> data = new ArrayList();
		for (int i=0; i<size; i++) {
			ArrayList<Boolean> row = new ArrayList();
			for (int j=0; j<size; j++) {
				row.add(j, false);
			}
			data.add(i, row);
		}
		this.data = data;
		this.ID = id;
	}

	public Sector(World world, int size, String id) {
		ArrayList<ArrayList<Boolean>> data = new ArrayList();
		for (int i=0; i<size; i++) {
			ArrayList<Boolean> row = new ArrayList();
			for (int j=0; j<size; j++) {
				row.add(j, false);
			}
			data.add(i, row);
		}
		this.data = data;
		this.ID = id;
		this.parent=world;
	}

	public Sector(World world, String id) {
		ArrayList<ArrayList<Boolean>> data = new ArrayList<ArrayList<Boolean>>();
		for (int i=0; i<25; i++) {
			ArrayList<Boolean> row = new ArrayList(25);
			for (int j=0; j<25; j++) {
				row.add(false);
			}
			data.add(row);
		}
		this.data = data;
		this.parent = world;
		this.ID = id;
	}

	public boolean getSurround(int x, int y) {
	    boolean[] out = new boolean[8];
	    int count = 0;
		for (int yo=-1; yo<=1; yo++) {
			for (int xo=-1; xo<=1; xo++) {
			    if ((xo == 0) || (yo == 0)) {
			    	break;
				}
				try {
					out[count] = this.getCell(x+xo, y+yo);
				}
				catch (Exception e) {
					int[] offs = new int[2]{ xo, yo };
					int myX = Integer.parseInt(ID.substring(0, this.ID.indexOf(".")));
					int myY = Integer.parseInt(ID.substring(this.ID.indexOf("."), this.ID.length()));
					int neighborX;
					int neighborY;
					switch (Arrays.toString(offs)) {
						case "[-1, -1]":
							if (x==0) { neighborX = myX-1; }
							if (y==0) { neighborY = myY-1; }
							out[0] = this.parent.getSector(neighborX, neighborY).getCell(this.data.size(), y-1);
							break;
						case "[0, -1]":
							out[1] = this.parent.getSector(myX, myY-1).getCell(x, this.data.size());
							break;
						case "[1, -1]":
							if (x==this.size()) { neighborX = myX+1; }
							if (y==0) { neighborY = myY-1; }
							out[2] = this.parent.getSector(neighborX, neighborY).getCell(x+1, y-1);
							break;
						case "[-1, 0]":
						    out[3] = this.parent.getSector(x-1, y).getCell(this.size(), y);
							break;
						case "[1, 0]":
						    out[4] = this.parent.getSector(x+1, y).getCell(0, y);
							break;
						case "[-1, 1]":
							if (x==0) { neighborX = myX-1; }
							if (y==this.size()) { neighborY = myY+1; }
							//out[5] = this.parent.getSector(neighborX, neighborY).getCell();
							}
							break;
						case "[0, 1]":
							break;
						case "[1, 1]":
							break;
					}
				}
			}
		}
	}

	public Sector(ArrayList<ArrayList<Boolean>> data) {
		ArrayList<ArrayList<Boolean>> out = new ArrayList<ArrayList<Boolean>>(data.size());
		for (int x=0; x<data.size(); x++) {
			ArrayList<Boolean> row = new ArrayList<Boolean>();
			for (int y=0; y<data.get(0).size(); y++) {
				row.set(y, data.get(x).get(y));
			}
			out.set(x, row);
		}
	}

	//sectorSize is intended size of sectors in output world
	public static World asWorld(Sector sector, int sectorSize) {
		int numSectors = sector.size()/sectorSize;
		World out = new World(numSectors);
		for (int yw=0; yw<numSectors; yw++) {
			for (int xw=0; xw<numSectors; xw++) {
			    Sector sector1 = new Sector(sectorSize);
				for (int ys=0; ys<sectorSize; ys++) {
					for (int xs=0; xs<sectorSize; xs++) {
						int selectX = (xw*sectorSize)+xs;
						int selectY = (yw*sectorSize)+ys;
						sector1.setCell(xs, ys, sector.getCell(selectX, selectY));
					}
				}
				out.setSector(xw, yw, sector1);
			}
		}
		return out;
	}
	public void setCell(int x, int y, boolean val) {
		this.data.get(x).set(y, val);
	}

	public Boolean getCell(int x, int y) {
		return this.data.get(x).get(y);
	}

	public int size() {
		return this.data.size();
	}

}
