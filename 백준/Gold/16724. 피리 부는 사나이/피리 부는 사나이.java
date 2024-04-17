import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static Point[][] parents;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new Point[N][M];
        map = new int[N][M];
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                char val = str.charAt(j);
                switch(val) {
                    case 'U':
                        map[i][j] = 0;
                        break;
                    case 'D':
                        map[i][j] = 1;
                        break;
                    case 'L':
                        map[i][j] = 2;
                        break;
                    case 'R':
                        map[i][j] = 3;
                        break;
                }
            }
        }

        for(int y=0; y<N; y++) {
            for(int x=0; x<M; x++) {
                parents[y][x] = new Point(x, y);
            }
        }

        for(int y=0; y<N; y++) {
            for(int x=0; x<M; x++) {
                int nx = x + dx[map[y][x]];
                int ny = y + dy[map[y][x]];
                Point a = new Point(x, y);
                Point b = new Point(nx, ny);
                union(a, b);
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int y=0; y<N; y++) {
            for(int x=0; x<M; x++) {
                Point p = find(new Point(x, y));
                if(!map.containsKey(M * p.y + p.x)) {
                    map.put(M * p.y + p.x, 1);
                }
            }
        }

        System.out.println(map.size());

        br.close();
    }

    static Point find(Point p) {
        if(parents[p.y][p.x].equals(p)) {
            return p;
        }
        else {
            return parents[p.y][p.x] = find(parents[p.y][p.x]);
        }
    }

    static void union(Point a, Point b) {
        a = find(a);
        b = find(b);

        if(a.equals(b)) return;

        if(M * a.y + a.x < M * b.y + b.x) {
            parents[b.y][b.x] = a;
        } else {
            parents[a.y][a.x] = b;
        }
    }
}
