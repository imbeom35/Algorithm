import java.io.*;
import java.util.*;

public class Main {
	
	private static class Edge implements Comparable<Edge>{
		int index;
		int cost;
		
		public Edge(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
	
	private static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
	private static int n, m;
	private static int[] dist, preCity;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Edge>());
		}
		
		StringTokenizer st;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()); 
			int to = Integer.parseInt(st.nextToken()); 
			int cost = Integer.parseInt(st.nextToken()); 
			graph.get(from).add(new Edge(to, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		preCity = new int[n+1];
		dijkstra(start, end);
		sb.append(dist[end]).append("\n");
		
		Stack<Integer> stack = new Stack<>();
		int index = end;
		while(index != 0) {
			stack.push(index);
			index = preCity[index];
		}
		
		sb.append(stack.size()).append("\n");
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		
		System.out.println(sb);
		
		br.close();
	}
	
	private static void dijkstra(int start, int end) {
		boolean[] visited = new boolean[n+1];
		dist = new int[n+1];
		int INF = Integer.MAX_VALUE;
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start, 0));
		while(!pq.isEmpty()) {
			int curr = pq.poll().index;
			
			if(visited[curr]) continue;
			visited[curr] = true;
			
			for(Edge next : graph.get(curr)) {
				if(dist[next.index] > dist[curr] + next.cost) {
					dist[next.index] = dist[curr] + next.cost;
					pq.add(new Edge(next.index, dist[next.index]));
					preCity[next.index] = curr;
				}
			}
		}
	}
}
