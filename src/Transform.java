package sweeps;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Transform {
    public static void generateWalls(Sector sector) {
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
		sector.setCell(x, y, count>=4);
	    }
	}
    }

    public static void populateRandom(Sector sector) {
	Random rand = new Random();
	for (int x=0; x<sector.size(); x++) {
	    for (int y=0; y<sector.size(); y++) {
		sector2.setCell(x, y, rand.nextInt(2)==1);
	    }
	}
    }
}
