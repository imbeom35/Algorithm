import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
	int index;
	int cost;
	
	public Node(int index, int cost){
		this.index = index;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return cost - o.cost;
	}
}

public class Main {
	static ArrayList<ArrayList<Node>> graph;
	static int INF = Integer.MAX_VALUE;
	static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for(int i=0; i<n+1; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph.get(s).add(new Node(e, cost));
			graph.get(e).add(new Node(s, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		int result;
		
		int case1 = 0;
		int res1 = dijkstra(1, v1);
		int res2 = dijkstra(v1, v2);
		int res3 = dijkstra(v2, n);
		if(res1 != INF && res2 != INF && res3 != INF) {
			case1 = res1 + res2 + res3;
		}else {
			case1 = INF;
		}
		
		int case2 = 0;
		res1 = dijkstra(1, v2);
		res2 = dijkstra(v2, v1);
		res3 = dijkstra(v1, n);
		if(res1 != INF && res2 != INF && res3 != INF) {
			case2 = res1 + res2 + res3;
		}else {
			case2 = INF;
		}
		
		if(case1 < INF || case2 < INF) {
			result = Math.min(case1, case2);
		}else {
			result = -1;
		}
		
		System.out.println(result);
		
		br.close();
	}
	
	static int dijkstra(int start, int end) {
		boolean[] visited = new boolean[n+1];
		int[] dist = new int[n+1];
		
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.index;
			
			if(!visited[cur]) {
				visited[cur] = true;
				
				for(Node next : graph.get(cur)) {
					if(!visited[next.index] && dist[next.index] > dist[cur] + next.cost) {
						dist[next.index] = dist[cur] + next.cost;
						pq.offer(new Node(next.index, dist[next.index]));
					}
				}
			}
		}
		
		return dist[end];
	}
}
