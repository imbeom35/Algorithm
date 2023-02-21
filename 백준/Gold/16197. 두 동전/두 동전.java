import java.io.*;
import java.util.*;

public class Main {
	
	static class Pos {
		int x;
		int y;
		int count;
		
		Pos(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
	
	static int N, M;
	static char[][] board;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		List<Pos> list = new ArrayList<>();
		
		for(int y=0; y<N; y++) {
			String input = br.readLine();
			for(int x=0; x<M; x++) {
				char value = input.charAt(x);
				if(value == 'o') {
					list.add(new Pos(x, y, 0));
				}
				board[y][x] = value;
			}
		}
		
		int value = bfs(list.get(0), list.get(1));
		System.out.println(value==-1?-1:value);
		
		br.close();
	}
	
	// coin2를 떨어뜨리지 않고 coin1을 떨어뜨리는데 걸리는 비용을 구하는 함수
	static int bfs(Pos coin1, Pos coin2) {
		Queue<Pos> que = new LinkedList<>();
		que.add(coin1);
		que.add(coin2);
		
		while(!que.isEmpty()) {
			Pos p1 = que.poll();
			Pos p2 = que.poll();
			
			// 최대 10번만 이동한다.
			if(p1.count == 10) break;
			
			for(int i=0; i<4; i++) {
				int nx1 = p1.x + dx[i];
				int ny1 = p1.y + dy[i];
				int nx2 = p2.x + dx[i];
				int ny2 = p2.y + dy[i];
				
				// 코인중 하나는 떨어지지 않았을 때
				if(isInArray(nx1, ny1) || isInArray(nx2, ny2)) {
					// 코인중 하나가 떨어졌을 경우 종료
					if(!isInArray(nx1, ny1) || !isInArray(nx2, ny2)) {
						return p1.count+1;
					}
					
					// 벽을 만날 경우 이동하지 않는다.
					if(board[ny1][nx1] != '#') {
						que.add(new Pos(nx1, ny1, p1.count+1));
					}else {
						que.add(new Pos(p1.x, p1.y, p1.count+1));
					}
					
					// 벽을 만날 경우 이동하지 않는다.
					if(board[ny2][nx2] != '#') {
						que.add(new Pos(nx2, ny2, p2.count+1));
					}else {
						que.add(new Pos(p2.x, p2.y, p2.count+1));
					}
				}
			}
		}
		
		return -1;
	}
	
	static boolean isInArray(int x, int y) {
		if(0 <= x && x < M && 0 <= y && y < N) {
			return true;
		}else {
			return false;
		}
	}
}
