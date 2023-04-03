import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] field;
	static int X, Y;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int result = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		field = new int[Y][X];
		
		// 치즈 입력
		for(int y=0; y<Y; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<X; x++) {
				field[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int y=0; y<Y; y++) {
			for(int x=0; x<X; x++) {
				result += field[y][x];
			}
		}
		
		// 더이상 녹일 수 없을 때까지 녹이기
		int count = 1;
		while(melt()) {
			count++;
		}
		
		System.out.println(count + "\n" + result);
		
		br.close();
	}
	
	static boolean melt() {
		boolean[][] visited = new boolean[Y][X];
		
		int sum = 0;
		
		Queue<Point> queue = new ArrayDeque<>();
		
		// 가장자리는 항상 공기
		queue.add(new Point(0, 0));
		
		// 공기 확산
		while(!queue.isEmpty()) {
			Point curr = queue.poll();
			
			// 사방탐색
			for(int i=0; i<4; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				
				// 방문하지 않은 경우 방문
				if(0 <= nx && nx < X && 0 <= ny && ny < Y && !visited[ny][nx]) {
					visited[ny][nx] = true;
					
					// 치즈가 있는경우 녹이기
					if(field[ny][nx] == 1) {
						field[ny][nx] = 0;
					}
					
					// 치즈가 없는경우 확산
					else {
						queue.add(new Point(nx, ny));
					}
				}
			}
		}
		
		for(int y=0; y<Y; y++) {
			for(int x=0; x<X; x++) {
				sum += field[y][x];
			}
		}
		
		if(sum != 0) {
			result = sum;
			return true;
		} else {
			return false;
		}
	}
}
