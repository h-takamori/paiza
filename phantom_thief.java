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
        Point cp = new Point(0,0);  // current pointの略か？「currentPoint」の方がいい

        while(!points.isEmpty()) {  // メソッドにまとめられない？ またはこのwhile文でどのような処理をしたいのか書くべき。
            List<Double> mem = new ArrayList<>();  // memoryの略だろうが、何の？ 具体的な名前を書くべき。せめて上の行で処理の流れが書いてあればわかりやすいのに
            for (int i = 0; i < points.size(); i++) {
                mem.add(cp.distance(points.get(i)));
            }
            List<Double> sortedMem = new ArrayList<>(mem);  // 「残りのすべての点のうち最も近い点を探している」旨をコメントに残すべき
            Collections.sort(sortedMem);
            int pointsIdx = mem.indexOf(sortedMem.get(0));  // 何のポイントのインデックスなのか。「"最も近い"点のインデックス」と命名すべき
            result.add(points.get(pointsIdx));
            cp = points.remove(pointsIdx);
        }

        for (Point p: result) {
            System.out.println(p.x + " " + p.y);
        }
    }
}

