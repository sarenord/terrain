package terrain;

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
							if (sector.getCell(x+xo, y+yo) == true) {
								count++;
							}
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

	public static void generateWalls(Sector sector, int threshold) {
		for (int x=0; x<sector.size(); x++) {
			for (int y=0; y<sector.size(); y++) {
				int count = 0;
				for (int xo=-1; xo<2; xo++) {
					for (int yo=-1; yo<2; yo++) {
						try {
							if (sector.getCell(x+xo, y+yo) == true) {
								count++;
							}
						}
						catch(Exception e) {
							break;
						}
					}
				}
				System.out.println(count);
				sector.setCell(x, y, count>=threshold);
			}
		}
	}

	public static void populateRandom(Sector sector) {
		Random rand = new Random();
		for (int x=0; x<sector.size(); x++) {
			for (int y=0; y<sector.size(); y++) {
				sector.setCell(x, y, rand.nextInt(2)==1);
			}
		}
	}

	public static void populateRandom(Sector sector, int density) {
		Random rand = new Random();
		for (int x=0; x<sector.size(); x++) {
			for (int y=0; y<sector.size(); y++) {
				sector.setCell(x, y, rand.nextInt(100) <= density);
			}
		}
	}
}
