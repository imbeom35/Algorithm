import java.io.*;
import java.util.*;

public class Main {
	static int n, m, start, end;
	static ArrayList<ArrayList<Node>> graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
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
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		System.out.println(dijktra(start, end));
		
		br.close();
	}
	
	static int dijktra(int start, int end) {
		boolean[] visited = new boolean[n+1];
		int[] dist = new int[n+1];
		int INF = 1000000000;
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
					if(dist[next.index] > dist[cur] + next.cost) {
						dist[next.index] = dist[cur] + next.cost;
						pq.add(new Node(next.index, dist[next.index]));
					}
				}
			}
		}
		
		return dist[end];
	}
	
	static class Node implements Comparable<Node>{
		int index;
		int cost;
		
		Node(int index, int cost){
			this.index = index;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return cost - o.cost;
		}
	}
}
