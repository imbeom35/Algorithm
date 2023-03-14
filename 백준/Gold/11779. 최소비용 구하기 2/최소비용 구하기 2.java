import java.io.*;
import java.util.*;

public class Main {
	static class City implements Comparable<City> {
		int to;
		int weight;

		public City(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(City o) {
			return this.weight - o.weight;
		}
	}

	static int N, M;
	static int d[], preCity[];
	static int start, end;
	static List<ArrayList<City>> graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		d = new int[N + 1];
		preCity = new int[N + 1];
		Arrays.fill(d, Integer.MAX_VALUE);

		graph = new ArrayList<>();
		for (int i = 0; i < N + 1; i++)
			graph.add(new ArrayList<City>());

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph.get(from).add(new City(to, weight));

		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		dijkstra(start);
		System.out.println(d[end]);
		
		int cnt = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(end);
		while (preCity[end] != 0) {
			cnt += 1;
			stack.push(preCity[end]);
			end = preCity[end];
		}
		System.out.println(cnt + 1);
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}

	}

	private static void dijkstra(int start) {
		PriorityQueue<City> pq = new PriorityQueue<City>();
		pq.add(new City(start, 0));
		d[start] = 0;

		while (!pq.isEmpty()) {
			City curCity = pq.poll();
			int cur = curCity.to;
			if (d[cur] < curCity.weight)
				continue;
			for (City next : graph.get(cur)) {
				if (d[next.to] > d[cur] + next.weight) {
					d[next.to] = d[cur] + next.weight;
					preCity[next.to] = cur;
					pq.offer(new City(next.to, d[next.to]));
				}
			}
		}
	}
}