import java.io.*;
import java.util.*;

public class Main {
	
	static int[] dx = {-1, 0, 1};
	static int[] dy = {0, -1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int[][] field = new int[N][M];
		int maxKill = 0;
		
		// 필드에 적이 존재하는 좌표 입력
		for(int y=0; y<N; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<M; x++) {
				field[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] a = new int[3];

		// 세 궁수의 위치를 조합으로 뽑는다.
		for(a[0]=0; a[0]<M; a[0]++) {
			for(a[1]=a[0]+1; a[1]<M; a[1]++) {
				for(a[2]=a[1]+1; a[2]<M; a[2]++) {
					// 킬 스코어 합
					int sumKill = 0;
					
					// 필드 복사
					int[][] copy = new int[N][M];
					for(int cy=0; cy<N; cy++) {
						for(int cx=0; cx<M; cx++) {
							copy[cy][cx] = field[cy][cx];
						}
					}
					
					// 필드의 가장 아래에서부터 접근
					for(int y=N-1; y>=0; y--) {
						
						// 제거한 적
						int kill = 0;
						
						// 적을 제거하기 전 임시로 보관된다.
						ArrayList<Point> killList = new ArrayList<>();
						
						// 각 궁수마다 화살 발사
						for(int i=0; i<3; i++) {
							Queue<Point> que = new ArrayDeque<>();
							boolean[][] visited = new boolean[N][M];
							
							// 궁수가 화살을 발사
							que.add(new Point(a[i], y, D-1));
							visited[y][a[i]] = true;
							
							while(!que.isEmpty()) {
								Point p = que.poll();
								
								// 현재 화살에 있는 곳에 적이 있을 경우
								if(copy[p.y][p.x] == 1) {
									// 적을 죽이기 위한 임시 리스트에 보관한다.(동시에 죽이기 위해)
									killList.add(new Point(p.x, p.y, 0));
									break;
								}
								
								// 화살의 최대거리까지 갔을 경우 해당 화살은 종료
								if(p.count == 0) {
									continue;
								}
								
								// 왼쪽, 위, 오른쪽 순으로 화살을 다시 발사한다.
								for(int j=0; j<3; j++) {
									int nx = p.x + dx[j];
									int ny = p.y + dy[j];
									
									// 다른 화살이 방문한 곳은 방문하지 않는다.
									if(isInArray(copy, nx, ny) && !visited[ny][nx]) {
										visited[ny][nx] = true;
										
										que.add(new Point(nx, ny, p.count-1));
									}
								}
							}
						}
						
						// 적 제거
						for(Point p : killList) {
							if(copy[p.y][p.x] == 1) {
								copy[p.y][p.x] = 0;
								kill++;
							}
						}
						
						// 킬 수 더하기
						sumKill += kill;
					}
					
					// 가장 많은 킬을 낸 경우로 갱신
					maxKill = Math.max(maxKill, sumKill);
				}
			}
		}
		
		System.out.println(maxKill);
		
		br.close();
	}
	
	public static boolean isInArray(int[][] arr, int x, int y) {
		if(0<=y && y<arr.length && 0<=x && x<arr[0].length) {
			return true;
		} else {
			return false;
		}
	}

	// 화살의 좌표와 앞으로 갈 수 있는 거리
	public static class Point{
		int x;
		int y;
		int count;
		
		public Point(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
}
