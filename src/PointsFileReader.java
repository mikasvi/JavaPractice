import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * @author mikas
 *
 */
public class PointsFileReader {

    public ArrayList<Point2D> readPointsFile(String fileName) {
        ArrayList<Point2D> points = new ArrayList<>();
        try {
            BufferedReader pointsReader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = pointsReader.readLine()) != null) {
                String[] parts = line.split(",");
                double x = Double.parseDouble(parts[0]);
                double y = Double.parseDouble(parts[1]);
                Point2D point = new Point2D.Double(x, y);
                points.add(point);
            }
            pointsReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return points;
    }
}

