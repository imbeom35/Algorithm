import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Node>[] list;
	static boolean[] visited;
	static int max = 0;
	static int node;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		for(int i=0; i<n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			
			while(true) {
				int e = Integer.parseInt(st.nextToken());
				if(e == -1) break;
				int cost = Integer.parseInt(st.nextToken());
				list[s].add(new Node(e, cost));
			}
		}
		
		visited = new boolean[n+1];
		dfs(1, 0);
		
		visited = new boolean[n+1];
		dfs(node, 0);
		
		System.out.println(max);
	}
	
	public static void dfs(int x, int len) {
		if(max < len) {
			max = len;
			node = x;
		}
		
		visited[x] = true;
		
		for(int i=0; i<list[x].size(); i++) {
			Node n = list[x].get(i);
			
			if(!visited[n.e]) {
				dfs(n.e, len + n.cost);
			}
		}
	}
	
	public static class Node{
		int e;
		int cost;
		
		public Node(int e, int cost){
			this.e = e;
			this.cost = cost;
		}
	}
}
