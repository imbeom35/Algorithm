import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge>{
        int index;
        int cost;

        public Edge(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int N, M;
    static List<List<Edge>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new ArrayList<>();
        for(int i=0; i<=N; i++) map.add(new ArrayList<>());

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map.get(from).add(new Edge(to, cost));
            map.get(to).add(new Edge(from, cost));
        }

        System.out.println(Dijkstra());

        br.close();
    }

    static int Dijkstra() {
        int INF = 1000000000;
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        boolean[] visited = new boolean[N+1];
        dist[1] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));

        while(!pq.isEmpty()) {
            Edge curr = pq.poll();

            if(visited[curr.index]) continue;
            visited[curr.index] = true;

            for(Edge next : map.get(curr.index)) {
                if(dist[next.index] > dist[curr.index] + next.cost) {
                    dist[next.index] = dist[curr.index] + next.cost;
                    pq.add(new Edge(next.index, dist[next.index]));
                }
            }
        }

        return dist[N];
    }
}
