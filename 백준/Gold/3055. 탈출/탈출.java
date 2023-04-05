import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	
	static int R, C;
	static char[][] field;
	static boolean[][] visited;
	static Point S;
	static ArrayList<Point> list = new ArrayList<>();
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		field = new char[R][C];
		visited = new boolean[R][C];
		
		// 입력
		for(int y=0; y<R; y++) {
			String input = br.readLine();
			for(int x=0; x<C; x++) {
				field[y][x] = input.charAt(x);
				
				if(field[y][x] == 'S') {
					// 고슴도치의 위치 저장
					S = new Point(x, y);
					field[y][x] = '.';
				} else if(field[y][x] == '*') {
					// 물의 위치 저장
					list.add(new Point(x, y));
				}
			}
		}
		
		int ans = move();
		
		if(ans == -1) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(ans);
		}
		
		br.close();
	}
	
	// 고슴도치는 매 분마다 이동한다.
	static int move() {
		int count = 0; // 한 번 이동할때 고려하는 가짓수
		int moveCount = 1; // 총 이동횟수
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(S); // 현재위치 저장
		
		while(!queue.isEmpty()) {
			// count만큼 이동할 수 있다.
			count = queue.size();
			
			for(int i=0; i<count; i++) {
				Point curr = queue.poll();
				
				// 물에 빠지게 되는 경우
				if(field[curr.y][curr.x] == '*') continue;
				
				// 이동
				for(int j=0; j<4; j++) {
					int nx = curr.x + dx[j];
					int ny = curr.y + dy[j];
					
					if(0 <= nx && nx < C && 0<= ny && ny < R && !visited[ny][nx]) {
						// 빈 공간으로 이동할 수 있는 경우
						if(field[ny][nx] == '.') {
							visited[ny][nx] = true;
							queue.add(new Point(nx, ny));
						}
						
						// 소굴로 이동할 수 있는 경우
						if(field[ny][nx] == 'D') {
							return moveCount;
						}
					}
				}
			}
			
			// 이동횟수 증가
			moveCount++;
			
			// 물 확장
			water();
		}
		
		return -1;
	}
	
	// 물 확장
	static void water() {
		// 새로운 물 리스트
		ArrayList<Point> nextList = new ArrayList<>();
		
		// 현재 물 리스트는 빈 공간으로 확장한다.
		for(Point water : list) {
			for(int i=0; i<4; i++) {
				int nx = water.x + dx[i];
				int ny = water.y + dy[i];
				
				if(0 <= nx && nx < C && 0<= ny && ny < R && field[ny][nx] == '.') {
					field[ny][nx] = '*';
					// 확장된 공간에 생성된 물은 새로운 물 리스트에 추가한다.
					nextList.add(new Point(nx, ny));
				}
			}
		}
		
		list = nextList;
	}
}
