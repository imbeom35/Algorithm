import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<ArrayList<Node>> tree;
	static int n;
	static int INF = 1000000000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		tree = new ArrayList<>();
		for(int i=0; i<n+1; i++) {
			tree.add(new ArrayList<Node>());
		}
		
		for(int i=1; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			tree.get(s).add(new Node(e, cost));
			tree.get(e).add(new Node(s, cost));
		}
		
		int[] dist = Dijkstra(1);
		int max = 0;
		int maxPoint = 0;
		for(int i=0; i<dist.length; i++) {
			if(max < dist[i] && dist[i] != INF) {
				max = dist[i];
				maxPoint = i;
			}
		}
		
		dist = Dijkstra(maxPoint);
		for(int i=0; i<dist.length; i++) {
			if(max < dist[i] && dist[i] != INF) {
				max = dist[i];
			}
		}
		
		System.out.println(max);
		
		br.close();
	}
	
	static int[] Dijkstra(int start) {
		boolean[] visited = new boolean[n+1];
		int[] dist = new int[n+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.index;
			
			for(Node next : tree.get(cur)) {
				if(!visited[next.index]) {
					visited[next.index] = true;
					
					if(dist[next.index] > dist[cur] + next.cost) {
						dist[next.index] = dist[cur] + next.cost;
						pq.add(new Node(next.index, dist[next.index]));
					}
				}
			}
		}
		
		return dist;
	}
	
	static class Node implements Comparable<Node>{
		int index;
		int cost;
		
		public Node(int index, int cost){
			this.index = index;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return index - o.index;
		}
	}
}
