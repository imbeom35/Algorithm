import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];

        for(int y=0; y<N; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x=0; x<N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        boolean isMove = true;

        while(isMove) {
            isMove = false;

            boolean[][] visited = new boolean[N][N];
            for(int y=0; y<N; y++) {
                for(int x=0; x<N; x++) {
                    if(!visited[y][x]) {
                        boolean result = move(map, visited, x, y);
                        if(result && !isMove) {
                            ans++;
                            isMove = true;
                        }
                    }
                }
            }
        }

        System.out.println(ans);

        br.close();
    }

    static boolean move(int[][] map, boolean[][] visited, int x, int y) {
        ArrayList<Point> list = new ArrayList<>();
        list.add(new Point(x, y));
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        int cnt = map[y][x];
        visited[y][x] = true;

        while(!queue.isEmpty()) {
            Point curr = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if(!(0 <= ny && ny < N && 0 <= nx && nx < N)) continue;

                int gap = Math.abs(map[curr.y][curr.x] - map[ny][nx]);

                if(!visited[ny][nx] && L <= gap && gap <= R) {
                    visited[ny][nx] = true;
                    cnt += map[ny][nx];
                    list.add(new Point(nx, ny));
                    queue.add(new Point(nx, ny));
                }
            }
        }

        int newCnt = cnt/list.size();
        for(Point curr : list) {
            map[curr.y][curr.x] = newCnt;
        }

        return list.size() > 1;
    }
}
