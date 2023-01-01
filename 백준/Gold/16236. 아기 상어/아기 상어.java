import java.io.*;
import java.util.*;

public class Main {
	public static int[] dx = {-1, 0, 0, 1};
	public static int[] dy = {0, -1, 1, 0};
	public static int[][] space;
	public static boolean[][] check;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		space = new int[N][N];
		check = new boolean[N][N];
		
		int x = 0;
		int y = 0;
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<N; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
				
				if(space[i][j] == 9) {
					x = i;
					y = j;
					space[i][j] = 0;
				}
			}
		}
		
		int result = shark(x, y);
		System.out.println(result);
		
		br.close();
	}
	
	public static int shark(int x, int y) {
		int count = 0;
		int size = 2;
		int feed = 2;
		int mx = space.length-1;
		int my = space.length-1;
		int lock = 0;
		boolean flag = false;
		
		Queue<location> que = new LinkedList<location>();
		que.add(new location(x, y, 0));
		
		while(!que.isEmpty()) {
			location l = que.poll();
			
			
			
			// 먹을 수 있는 물고기 발견
			if(space[l.x][l.y] < size && space[l.x][l.y] != 0) {
				if(flag == false || l.c <= lock) {
					// 최초발견 신고
					if(flag == false) {
						lock = l.c;
						flag = true;
						
						// 카운트
						count += l.c;
					}
					
					// 우선순위가 높은 물고기의 위치 갱신
					if(mx > l.x){
						mx = l.x;
						my = l.y;
					}else if(mx == l.x) {
						if(my > l.y) {
							mx = l.x;
							my = l.y;
						}
					}
				}
			}
			
			// 이동 제한 필터, 발견시 활성화
			if(flag == true) {
				if(l.c > lock || que.isEmpty()) {
					// 현재위치 수정
					l.x = mx;
					l.y = my;
					
					// 현재위치의 물고기 제거
					space[l.x][l.y] = 0;
					
					// 성장
					feed--;
					if(feed == 0){
						size++;
						feed = size;
					}
					
					// 미발견 상태로 복귀
					flag = false;
					
					// 초기화
					que.clear();
					check = new boolean[space.length][space.length];
					l.c = 0;
					mx = space.length-1;
					my = space.length-1;
				}
			}
			
			
			
			// 현재 위치에서 이동가능 지역 탐색 후 이동
			for(int i=0; i<4; i++) {
				int nx = l.x + dx[i];
				int ny = l.y + dy[i];
				
				if(0 <= nx && nx < space.length && 0 <= ny && ny < space.length) {
					if(space[nx][ny] <= size && check[nx][ny] == false) {
						que.add(new location(nx, ny, l.c+1));
						check[nx][ny] = true;
					}
				}
			}
		}
		
		return count;
	}
}

class location{
	int x;
	int y;
	int c;
	
	location(int x, int y, int c){
		this.x = x;
		this.y = y;
		this.c = c;
	}
}
