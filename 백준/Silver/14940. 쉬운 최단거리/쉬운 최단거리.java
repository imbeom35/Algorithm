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
        int[][] field = new int[N][M];
        int[][] answer = new int[N][M];
        Point goal = new Point();

        // 입력
        for(int n=0; n<N; n++) {
            st = new StringTokenizer(br.readLine());
            for(int m=0; m<M; m++) {
                field[n][m] = Integer.parseInt(st.nextToken());

                if(field[n][m] == 2) {
                    goal.x = n;
                    goal.y = m;
                }
            }
        }

        // BFS
        Queue<Point> queue = new LinkedList<>();
        queue.add(goal);
        while(!queue.isEmpty()) {
            Point curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                if (0 <= curr.x + dx[i] && curr.x + dx[i] < N && 0 <= curr.y + dy[i] && curr.y + dy[i] < M) {
                    if (answer[curr.x + dx[i]][curr.y + dy[i]] == 0 && field[curr.x + dx[i]][curr.y + dy[i]] != 0) {
                        answer[curr.x + dx[i]][curr.y + dy[i]] = answer[curr.x][curr.y] + 1;
                        queue.add(new Point(curr.x + dx[i], curr.y + dy[i]));
                    }
                }
            }
        }
        answer[goal.x][goal.y] = 0;

        // 목적지와 연결되지 않은 땅 -1 처리
        for(int n=0; n<N; n++) {
            for(int m=0; m<M; m++) {
                if(field[n][m] == 1 && answer[n][m] == 0) {
                    answer[n][m] = -1;
                }
            }
        }

        // 출력
        for(int n=0; n<N; n++) {
            for(int m=0; m<M; m++) {
                System.out.print(answer[n][m] + " ");
            }
            System.out.println();
        }

        br.close();
    }
}
