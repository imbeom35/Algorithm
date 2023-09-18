import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited, colors;
    static int[] ans = new int[2];
    static int[] dr = {-1, -1};
    static int[] dc = {1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];
        colors = new boolean[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                colors[i][j] = (i%2 == 0 && j%2==0) || (i%2 != 0 && j%2 != 0);
            }
        }

        dfs(-1, true, 0);
        dfs(-1, false, 0);

        System.out.println(ans[0] + ans[1]);

        br.close();
    }

    static void dfs(int index, boolean black, int depth) {
        for(int i=index+1; i<N*N; i++) {
            int r = i/N;
            int c = i%N;

            if(colors[r][c] != black || map[r][c] == 0 || !check(r, c)) continue;

            visited[r][c] = true;
            dfs(i, black, depth+1);
            visited[r][c] = false;
        }
        ans[black ? 1 : 0] = Math.max(ans[black ? 1 : 0], depth);
    }

    static boolean check(int r, int c) {
        for(int i=0; i<2; i++) {
            int nr = r;
            int nc = c;
            while(true) {
                if(OOB(nr, nc)) break;
                if(visited[nr][nc]) return false;

                nr += dr[i];
                nc += dc[i];
            }
        }

        return true;
    }

    static boolean OOB(int r, int c) {
        return r < 0 || r >= N || c < 0 || c >= N;
    }

}
