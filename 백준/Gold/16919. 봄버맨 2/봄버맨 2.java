import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	
	static int R, C, N;
	static int time = 0;
	static int[][] field;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		field = new int[R][C];
		
		// 폭탄 설치
		for(int y=0; y<R; y++) {
			String input = br.readLine();
			for(int x=0; x<C; x++) {
				if(input.charAt(x) == 'O') {
					field[y][x] = 3;
				}
			}
		}
		
		// 설정
		if(N >= 8) {
			N = N % 4 + 4;
		}
		
		// 3과 4를 반복한다.
		action();
		
		// 결과 출력
		for(int y=0; y<R; y++) {
			for(int x=0; x<C; x++) {
				if(field[y][x] > 0) {
					sb.append('O');
				} else {
					sb.append('.');
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}
	
	static void action() {
		Queue<Point> queue = new ArrayDeque<>();
		
		while(time++ < N) {
			// 폭탄이 설치되어 있지 않은 모든 칸에 폭탄을 설치한다.
			if(time%2 == 0) {
				for(int y=0; y<R; y++) {
					for(int x=0; x<C; x++) {
						if(field[y][x] == 0) {
							field[y][x] = time + 3;
						}
					}
				}
			}
			
			// 3초 전에 설치된 폭탄이 모두 폭발한다.
			for(int y=0; y<R; y++) {
				for(int x=0; x<C; x++) {
					if(field[y][x] == time) {
						field[y][x] = 0;
						queue.add(new Point(x, y));
					}
				}
			}
			
			// 동시에 폭발하며 인접한 네 칸도 함께 파괴된다.
			while(!queue.isEmpty()) {
				Point p = queue.poll();
				for(int i=0; i<4; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];
					
					if(0 <= nx && nx < C && 0 <= ny && ny < R) {
						field[ny][nx] = 0;
					}
				}
			}
			
			// 종료조건
			if(N <= 0) break;
		}
	}
}