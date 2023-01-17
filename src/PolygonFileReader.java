import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * @author mikas
 *
 */
public class PolygonFileReader {

    public ArrayList<Point2D> readPolygonFile(String fileName) {
        ArrayList<Point2D> polygon = new ArrayList<>();
        try {
            BufferedReader polygonReader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = polygonReader.readLine()) != null) {
                String[] parts = line.split(",");
                double x = Double.parseDouble(parts[0]);
                double y = Double.parseDouble(parts[1]);
                polygon.add(new Point2D.Double(x, y));
            }
            polygonReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return polygon;
    }
}