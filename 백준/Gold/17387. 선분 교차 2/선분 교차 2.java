import java.io.*;
import java.util.Scanner;

public class Main {
    static class Point {
        long x, y;
        
        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Point p1 = new Point(sc.nextLong(), sc.nextLong());
        Point p2 = new Point(sc.nextLong(), sc.nextLong());
        Point p3 = new Point(sc.nextLong(), sc.nextLong());
        Point p4 = new Point(sc.nextLong(), sc.nextLong());

        System.out.println(isIntersect(p1, p2, p3, p4) ? 1 : 0);

        sc.close();
    }

    public static int ccw(Point p1, Point p2, Point p3) {
        long s = (p1.x*p2.y + p2.x*p3.y + p3.x*p1.y) - (p2.x*p1.y + p3.x*p2.y + p1.x*p3.y);
        if(s == 0) return 0;
        else if(s > 0) return 1;
        else return -1;
    }

    public static boolean isIntersect(Point p1, Point p2, Point p3, Point p4) {
        int ccw1 = ccw(p1, p2, p3) * ccw(p1, p2, p4);
        int ccw2 = ccw(p3, p4, p1) * ccw(p3, p4, p2);

        // 두 직선이 일직선 상에 존재
        if(ccw1 == 0 && ccw2 == 0) {
            boolean compare1 = Math.min(p1.x, p2.x) <= Math.max(p3.x, p4.x);
            boolean compare2 = Math.min(p3.x, p4.x) <= Math.max(p1.x, p2.x);
            boolean compare3 = Math.min(p1.y, p2.y) <= Math.max(p3.y, p4.y);
            boolean compare4 = Math.min(p3.y, p4.y) <= Math.max(p1.y, p2.y);

            return compare1 && compare2 && compare3 && compare4;
        }

        return ccw1 <= 0 && ccw2 <= 0;
    }
}
