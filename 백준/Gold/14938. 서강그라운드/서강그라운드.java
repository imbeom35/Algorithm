import java.io.*;
import java.util.*;

public class Main {
	
	private static class Edge implements Comparable<Edge> {
		int index;
		int cost;
		
		Edge(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
	
	private static ArrayList<ArrayList<Edge>> graph;
	private static int[] items;
	private static int N, M, R;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		items = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}
		
		graph = new ArrayList<>();
		for(int i=0; i<=N; i++) graph.add(new ArrayList<>());
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph.get(start).add(new Edge(end, cost));
			graph.get(end).add(new Edge(start, cost));
		}
		
		int ans = 0;
		for(int i=1; i<=N; i++) {
			ans = Math.max(ans, dijkstra(i));
		}
		
		System.out.println(ans);
		
		br.close();
	}
	
	private static int dijkstra(int start) {
		boolean[] check = new boolean[N+1];
		int[] dist = new int[N+1];
		int INF = Integer.MAX_VALUE;
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0));
		while(!pq.isEmpty()) {
			int nowVertex = pq.poll().index;
			
			if(check[nowVertex]) continue;
			check[nowVertex] = true;
			
			for(Edge next : graph.get(nowVertex)) {
				if(dist[next.index] > dist[nowVertex] + next.cost) {
					dist[next.index] = dist[nowVertex] + next.cost;
					pq.offer(new Edge(next.index, dist[next.index]));
				}
			}
		}
		
		int count = 0;
		for(int i=1; i<=N; i++) {
			if(dist[i] <= M) {
				count += items[i];
			}
		}
		
		return count;
	}
}
