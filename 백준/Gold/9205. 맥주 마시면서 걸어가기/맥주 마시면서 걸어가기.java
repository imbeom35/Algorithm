import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			ArrayList<Point> list  = new ArrayList<>();
			for(int i=0; i<N+2; i++) {
				st = new StringTokenizer(br.readLine());
				list.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
			Queue<Point> queue = new ArrayDeque<>();
			queue.add(list.get(0));
			boolean[] visited = new boolean[N+1];
			boolean state = false;
			
			while(!queue.isEmpty()) {
				Point curr = queue.poll();
				
				// 도착지에 갈 수 있는지 확인
				if(youCanGo(curr, list.get(N+1))) {
					state = true;
				}
				
				// 편의점에 갈 수 있는지 확인
				for(int i=1; i<=N; i++) {
					// 현재위치에서 i번째 편의점에 갈 수 없는경우
					if(!youCanGo(curr, list.get(i))) {
						continue;
					}
					
					// 방문하지 않은 경우
					if(!visited[i]) {
						// 방문
						visited[i] = true;
						queue.add(list.get(i));
					}
				}
			}
			
			if(state) {
				sb.append("happy\n");
			} else {
				sb.append("sad\n");
			}
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}
	
	static boolean youCanGo(Point p1, Point p2) {
		if((Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y)) <= 1000) {
			return true;
		} else {
			return false;
		}
	}
}
