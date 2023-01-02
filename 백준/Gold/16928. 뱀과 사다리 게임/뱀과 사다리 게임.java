import java.io.*;
import java.util.*;

public class Main {
	public static int[] rule = new int[101];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=1; i<rule.length; i++) {
			rule[i] = i;
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			rule[x] = y;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			rule[u] = v;
		}
		
		int result = bfs(1);
		
		System.out.println(result);
		
		br.close();
	}
	
	// 최적해를 찾을 경우 즉시 종료되므로 훨씬 빠르다
	public static int bfs(int s) {
		int[] check = new int[101];
		Queue<Integer> que = new LinkedList<>();
		que.add(s);
		check[s] = 0;
		
		while(true) {
			int x = que.poll();
			
			for(int i=1; i<7; i++) {
				if(x+i > 100) {
					continue;
				}
				
				if(check[rule[x+i]] == 0) {
					que.add(rule[x+i]);
					check[rule[x+i]] = check[x]+1;
				}
				
				if(rule[x+i] == 100) {
					return check[100];
				}
			}
		}
	}
}