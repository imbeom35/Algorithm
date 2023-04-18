import java.io.*;
import java.util.*;

public class Main {
	
	static class Node implements Comparable<Node> {
		int x, time;
		
		Node(int x, int time) {
			this.x = x;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			return this.time - o.time;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] visited = new int[100001];
		
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(N, 0));
		Arrays.fill(visited, 1000000000);
		visited[N] = 0;
		
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			
			int[] next = {curr.x + 1, curr.x - 1, curr.x*2};
			int[] nextTime = {1, 1, 0};
			for(int i=0; i<3; i++) {
				if(0 <= next[i] && next[i] <= 100000 && visited[next[i]] > curr.time) {
					visited[next[i]] = curr.time + nextTime[i];
					queue.add(new Node(next[i], curr.time + nextTime[i]));
				}
			}
		}
		
		System.out.println(visited[K]);
		
		br.close();
	}
}
