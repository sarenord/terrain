package sweeps;

import java.util.ArrayList;
import java.util.List;

public class Transform {
    public static Sector generateWalls(Sector sector) {
	Sector sector2 = new Sector(sector.size());
	for (int x=0; x<sector.size(); x++) {
	    for (int y=0; y<sector.size(); y++) {
		int count = 0;
		for (int xo=-1; xo<2; xo++) {
		    for (int yo=-1; yo<2; yo++) {
			try {
			    count += sector.get(xo).get(yo);
			}
			catch(Exception e) {
			    break;
			}
		    }
		}
		sector2.setCell(x, y, count>=4);
	    }
	}
    }

    public static void populateRandom(Sector sector) {
	for (int xw=0; xw<10; xw++) {
	    for (int yw=0; yw<10; yw++) {
		for (int xs=0; xs<25; xs++) {
		    for (int xy=0; xy<25; xy++) {

		    }
		}
	    }
	}
    }
}
