import java.util.ArrayList;
import java.util.List;

public class Sector {
    public ArrayList<List<Boolean>> data;
    public Sector() {
	ArrayList<List<Boolean>> data = new ArrayList(25);
	for (int i=0; i<25; i++) {
	    ArrayList<Boolean> row = new ArrayList(25);
	    for (int j=0; j<25; j++) {
		row.set(j, false);
	    }
	    data.set(i, row);
	}
        this.data = data;
    }

    public Sector(int size) {
	ArrayList<List<Boolean>> data = new ArrayList(size);
	for (int i=0; i<size; i++) {
	    ArrayList<Boolean> row = new ArrayList(size);
	    for (int j=0; j<size; j++) {
		row.set(j, false);
	    }
	    data.set(i, row);
	}
        this.data = data;
    }

    public Sector(ArrayList<ArrayList<Boolean>> data) {
	ArrayList<List<Boolean>> out = new ArrayList<List<Boolean>>(data.size());
	for (int x=0; x<data.size(); x++) {
	    ArrayList<Boolean> column = new ArrayList<Boolean>();
	    for (int y=0; y<data.get(0).size(); y++) {
		column.set(y, data.get(x).get(y));
	    }
	    out.set(x, column);
	}
    }

    public void setCell(int x, int y, boolean val) {
	this.data.get(x).get(y) = val;
    }

    public int getSize() {
        return this.data.size();
    }

    public Boolean getCell(int x, int y) {
	return this.data.get(x).get(y);
    }
}
