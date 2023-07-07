import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] field = new char[N][M];
        boolean[][] visited = new boolean[N][M];
        Point p = new Point();
        int cnt = 0;

        for(int n=0; n<N; n++) {
            String input = br.readLine();
            for(int m=0; m<M; m++) {
                field[n][m] = input.charAt(m);
                if(field[n][m] == 'I') {
                    p.x = n;
                    p.y = m;
                }
            }
        }

        Queue<Point> queue = new LinkedList<Point>();
        queue.add(p);
        while(!queue.isEmpty()) {
            Point curr = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if(0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if(field[nx][ny] == 'P') {
                        cnt++;
                    }

                    if(field[nx][ny] != 'X') {
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }

        if(cnt == 0) {
            System.out.println("TT");
        } else {
            System.out.println(cnt);
        }

        br.close();
    }
}
