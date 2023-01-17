
import java.io.IOException;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * @author mikas
 *
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Point2D> polygon = new ArrayList<>();
        ArrayList<Point2D> points = new ArrayList<>();
        try {
            PolygonFileReader polygonFileReader = new PolygonFileReader();
            polygon = polygonFileReader.readPolygonFile("polygoni.txt");
            PointsFileReader pointsFileReader = new PointsFileReader();
            points = pointsFileReader.readPointsFile("pisteet.txt");
            
            ReportFileWriter reportFileWriter = new ReportFileWriter();
            for (Point2D point : points) {
                if (isInsidePolygon(polygon, point)) {
                    reportFileWriter.write("Piste " + point + " on polygonin sisäpuolella.");
                } else if (isOnPolygonEdge(polygon, point)) {
                    reportFileWriter.write("Piste " + point + " on polygonin reunalla.");
                } else {
                    reportFileWriter.write("Piste " + point + " on polygonin ulkopuolella.");
                }
            }
            reportFileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Tarkistaa, onko piste polygonin reunalla
    /**
     * @param polygon
     * @param point
     * @return
     */
    public static boolean isOnPolygonEdge(ArrayList<Point2D> polygon, Point2D point){
        for (int i = 0; i < polygon.size(); i++) {
            Point2D p1 = polygon.get(i);
            Point2D p2 = polygon.get((i + 1) % polygon.size());
            double edgeLength = p1.distance(p2);
            double distanceToStart = point.distance(p1);
            double distanceToEnd = point.distance(p2);
            double distanceToEdge = Math.abs((edgeLength + distanceToStart + distanceToEnd) / 2 - edgeLength);
            if (distanceToEdge <= 0.000001) {
                return true;
            }
        }
        return false;
    }
    // Tarkistaa, onko piste polygonin sisäpuolella
    /**
     * @param polygon
     * @param point
     * @return
     */
    public static boolean isInsidePolygon(ArrayList<Point2D> polygon, Point2D point) {
        int i, j;
        boolean inside = false;
        for (i = 0, j = polygon.size() - 1; i < polygon.size(); j = i++) {
            if ((polygon.get(i).getY() > point.getY()) != (polygon.get(j).getY() > point.getY()) &&
            	(point.getX() < (polygon.get(j).getX() - polygon.get(i).getX()) * (point.getY() - polygon.get(i).getY()) /
            	(polygon.get(j).getY() - polygon.get(i).getY()) + polygon.get(i).getX())){
            	inside = !inside;
            }
            }
            return inside;
    }
}