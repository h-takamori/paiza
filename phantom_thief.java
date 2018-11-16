import java.util.*;
import java.awt.Point;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Point p = new Point(sc.nextInt(),sc.nextInt());
            points.add(p);
        }

        List<Point> result = new ArrayList<>();
        Point cp = new Point(0,0);

        while(!points.isEmpty()) {
            List<Double> mem = new ArrayList<>();
            for (int i = 0; i < points.size(); i++) {
                mem.add(cp.distance(points.get(i)));
            }
            List<Double> sortedMem = new ArrayList<>(mem);
            Collections.sort(sortedMem);
            int pointsIdx = mem.indexOf(sortedMem.get(0));
            result.add(points.get(pointsIdx));
            cp = points.remove(pointsIdx);
        }

        for (Point p: result) {
            System.out.println(p.x + " " + p.y);
        }
    }
}

