import java.io.*;
import java.util.*;

public class Main {
	
	static int[] dx = {1, 1, 1};
	static int[] dy = {-1, 0, 1};
	static char[][] space;
	static boolean[][] visited;
	static int R, C;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		space = new char[R][C];
		visited = new boolean[R][C];
		
		for(int y=0; y<R; y++) {
			String input = br.readLine();
			for(int x=0; x<C; x++) {
				space[y][x] = input.charAt(x);
			}
		}
		
		int count = 0;
		for(int y=0; y<R; y++) {
			if(dfs(0, y)) {
				count++;
			}
		}
		
		System.out.println(count);
		
		br.close();
	}
	
	static boolean dfs(int x, int y) {
		if(x == C-1) {
			return true;
		}
		
		// 오른쪽 대각선 위, 오른쪽, 오른쪽 대각선 아래의 순으로 접근한다.
		for(int i=0; i<3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 해당 위치에 파이프를 놓을 수 있는 경우
			if(isInArray(nx, ny) && !visited[ny][nx] && space[ny][nx] == '.') {
				if(dfs(nx, ny)) {
					visited[ny][nx] = true;
					return true;
				}
			}
		}
		visited[y][x] = true;
		
		return false;
	}
	
	static boolean isInArray(int x, int y) {
		if(0 <= x && x < C && 0 <= y && y < R) {
			return true;
		}else {
			return false;
		}
	}
}
