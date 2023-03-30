import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] field, dp;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n=1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			
			field = new int[N][N];
			dp = new int[N][N];
			for(int y=0; y<N; y++) {
				st = new StringTokenizer(br.readLine());
				for(int x=0; x<N; x++) {
					field[y][x] = Integer.parseInt(st.nextToken());
					dp[y][x] = 1000000000;
				}
			}
			
			Queue<Point> queue = new ArrayDeque<>();
			queue.add(new Point(0, 0));
			dp[0][0] = field[0][0];
			
			while(!queue.isEmpty()) {
				Point p = queue.poll();
				
				for(int i=0; i<4; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					
					if(0 <= nx && nx < N && 0 <= ny && ny < N) {
						if(dp[ny][nx] > dp[p.y][p.x] + field[ny][nx]) {
							dp[ny][nx] = dp[p.y][p.x] + field[ny][nx];
							queue.add(new Point(nx, ny));
						}
					}
				}
			}
			
			sb.append("Problem " + n++ + ": ").append(dp[N-1][N-1]).append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
	}
}
