import java.io.*;
import java.util.*;

public class Main {
	
	private static int time = 0;
	private static int[][] visited = new int[100001][2];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
        if (N >= K) {
            System.out.println((N-K) + "\n1");
            return;
        }
        
		bfs(N, K);
		
		System.out.println(time);
		System.out.println(visited[K][0]);
		
		br.close();
	}
	
	private static void bfs(int N, int K) {
		boolean flag = false;
		
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(N);
		visited[N][0] = 1;
		visited[N][1] = 0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			time++;
			
			for(int i=0; i<size; i++) {
				int curr = queue.poll();
				
				// 이동 : +1
				if(0 <= curr + 1 && curr + 1 <= 100000) {
					if(visited[curr + 1][0] == 0) {
						visited[curr + 1][1] = time;
						queue.add(curr + 1);
					}
					
					if(visited[curr + 1][1] == time) {
						visited[curr + 1][0] += visited[curr][0];
					}
					
					if(curr + 1 == K) {
						flag = true;
					}
					//System.out.println(curr+1 + " " + visited[curr + 1]);
				}
				
				// 이동 : -1
				if(0 <= curr - 1 && curr - 1 <= 100000) {
					if(visited[curr - 1][0] == 0) {
						visited[curr - 1][1] = time;
						queue.add(curr - 1);
					}
					if(visited[curr - 1][1] == time) {
						visited[curr - 1][0] += visited[curr][0];
					}
					
					if(curr - 1 == K) {
						flag = true;
					}
					//System.out.println(curr-1 + " " + visited[curr - 1]);
				}
				
				// 이동 : *2
				if(0 <= curr *2 && curr * 2 <= 100000) {
					if(visited[curr * 2][0] == 0) {
						visited[curr * 2][1] = time;
						queue.add(curr * 2);
					}
					if(visited[curr * 2][1] == time) {
						visited[curr * 2][0] += visited[curr][0];
					}
					
					if(curr * 2 == K) {
						flag = true;
					}
					//System.out.println(curr*2 + " " + visited[curr * 2]);
				}
			}
			
			//System.out.println("---------");
			if(flag) return;
		}
	}
}
