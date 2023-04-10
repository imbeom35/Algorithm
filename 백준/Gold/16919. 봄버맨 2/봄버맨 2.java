import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	
	static int R, C, N;
	static int[][] field;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		field = new int[R][C];
		
		// 1. 가장 처음에 봄버맨은 일부 칸에 폭탄을 설치해 놓는다.
		for(int y=0; y<R; y++) {
			String input = br.readLine();
			for(int x=0; x<C; x++) {
				if(input.charAt(x) == 'O') {
					field[y][x] = 3;
				}
			}
		}
		
		// 2. 다음 1초 동안 봄버맨은 아무것도 하지 않는다.
		time();
		
		// 설정
		N %= 400;
		
		// 3과 4를 반복한다.
		action();
		
		br.close();
	}
	
	static void action() {
		Queue<Point> queue = new ArrayDeque<>();
		
		// 3과 4를 반복한다.
		while(true) {
			// 3. 폭탄이 설치되어 있지 않은 모든 칸에 폭탄을 설치한다.
			if(N > 0) {
				time();
				
				for(int y=0; y<R; y++) {
					for(int x=0; x<C; x++) {
						if(field[y][x] == 0) {
							field[y][x] = 3;
						}
					}
				}
			}
			
			// 4. 3초 전에 설치된 폭탄이 모두 폭발한다.
			if(N > 0) {
				time();
				
				// 폭발하는 폭탄을 큐에 저장한다.
				for(int y=0; y<R; y++) {
					for(int x=0; x<C; x++) {
						if(field[y][x] == 0) {
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
			}
			
			// 종료조건
			if(N <= 0) break;
		}
		
		// 결과 출력
		print();
	}
	
	static void print() {
		for(int y=0; y<R; y++) {
			for(int x=0; x<C; x++) {
				if(field[y][x] > 0) {
					System.out.print('O');
				} else {
					System.out.print('.');
				}
			}
			System.out.println();
		}
	}
	
	static void time() {
		N--;
		
		for(int y=0; y<R; y++) {
			for(int x=0; x<C; x++) {
				if(field[y][x] > 0) field[y][x]--;
			}
		}
	}
}
