import java.util.ArrayList;
import java.util.List;

public class View {
    private static final String ZERO_CHAR = "▂";
    private static final String ONE_CHAR = "█";
    public static void printSector(Sector sector) {
	for (int y=0; y<sector.size(); y++) {
	    StringBuilder line = new StringBuilder();
	    for (int x=0; x<sector.size(); x++) {
		line.append(sector.getCell(x, y)==true ? ONE_CHAR : ZERO_CHAR);
		line.append(sector.getCell(x, y)==true ? ONE_CHAR : ZERO_CHAR);
	    }
	    System.out.println(line);
	}
    }
}
