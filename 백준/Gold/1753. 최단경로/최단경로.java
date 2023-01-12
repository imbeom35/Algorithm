import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

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
	static int n;
	static int m;
	static int x;
	static ArrayList<ArrayList<Node>> graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph.get(s).add(new Node(e, cost));
		}
		
		int[] result = dijkstra(x);
		
		for(int i=1; i<=n; i++) {
			if(result[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			}else {
				sb.append(result[i] + "\n");
			}
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}
	
	public static int[] dijkstra(int start) {
		int[] dist = new int[n+1];
		boolean[] visited = new boolean[n+1];
		int INF = Integer.MAX_VALUE;
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
						pq.add(new Node(next.index, dist[next.index]));
					}
				}
			}
		}
		
		return dist;
	}
}
