import static org.junit.Assert.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import org.junit.Test;

public class MainTest {

    @Test
    public void testIsInsidePolygon() {
        ArrayList<Point2D> polygon = new ArrayList<>();
        polygon.add(new Point2D.Double(0, 0));
        polygon.add(new Point2D.Double(0, 1));
        polygon.add(new Point2D.Double(1, 1));
        polygon.add(new Point2D.Double(1, 0));
        Point2D point = new Point2D.Double(0.5, 0.5);

        boolean result = Main.isInsidePolygon(polygon, point);

        assertTrue(result);
    }

    @Test
    public void testIsNotInsidePolygon() {
        ArrayList<Point2D> polygon = new ArrayList<>();
        polygon.add(new Point2D.Double(0, 0));
        polygon.add(new Point2D.Double(0, 1));
        polygon.add(new Point2D.Double(1, 1));
        polygon.add(new Point2D.Double(1, 0));
        Point2D point = new Point2D.Double(1.5, 1.5);

        boolean result = Main.isInsidePolygon(polygon, point);

        assertFalse(result);
    }

    @Test
    public void testIsOnPolygonEdge() {
        ArrayList<Point2D> polygon = new ArrayList<>();
        polygon.add(new Point2D.Double(0, 0));
        polygon.add(new Point2D.Double(0, 1));
        polygon.add(new Point2D.Double(1, 1));
        polygon.add(new Point2D.Double(1, 0));
        Point2D point = new Point2D.Double(0, 0.5);

        boolean result = Main.isOnPolygonEdge(polygon, point);

        assertTrue(result);
    }

    @Test
    public void testIsNotOnPolygonEdge() {
        ArrayList<Point2D> polygon = new ArrayList<>();
        polygon.add(new Point2D.Double(0, 0));
        polygon.add(new Point2D.Double(0, 1));
        polygon.add(new Point2D.Double(1, 1));
        polygon.add(new Point2D.Double(1, 0));
        Point2D point = new Point2D.Double(0.5, 0.5);

        boolean result = Main.isOnPolygonEdge(polygon, point);

        assertFalse(result);
    }
}