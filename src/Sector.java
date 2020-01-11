import java.util.ArrayList;
import java.util.List;

public class Sector {
    public ArrayList<ArrayList<Boolean>> data;
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

    public Sector(int size) {
	ArrayList<ArrayList<Boolean>> data = new ArrayList();
	for (int i=0; i<size; i++) {
	    ArrayList<Boolean> row = new ArrayList();
	    for (int j=0; j<size; j++) {
		row.add(j, false);
	    }
	    data.add(i, row);
	}
        this.data = data;
    }

    public Sector(ArrayList<ArrayList<Boolean>> data) {
	ArrayList<ArrayList<Boolean>> out = new ArrayList<ArrayList<Boolean>>(data.size());
	for (int x=0; x<data.size(); x++) {
	    ArrayList<Boolean> column = new ArrayList<Boolean>();
	    for (int y=0; y<data.get(0).size(); y++) {
		column.set(y, data.get(x).get(y));
	    }
	    out.set(x, column);
	}
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
