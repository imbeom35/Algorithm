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

    static int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            ArrayList<ArrayList<Edge>> map = new ArrayList<>();
            for(int i=0; i<=N; i++) map.add(new ArrayList<>());

            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                map.get(from).add(new Edge(to, cost));
                map.get(to).add(new Edge(from, cost));
            }

            int K = Integer.parseInt(br.readLine());
            int[] people = new int[K];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<K; i++) {
                people[i] = Integer.parseInt(st.nextToken());
            }

            int[] totalDist = new int[N+1];
            for(int i=0; i<K; i++) {
                int[] dist = Dijkstra(N, map, people[i]);
                for(int j=1; j<N+1; j++) {
                    totalDist[j] += dist[j];
                }
            }

            int minCost = INF;
            int index = 0;
            for(int i=1; i<N+1; i++) {
                if(minCost > totalDist[i]) {
                    minCost = totalDist[i];
                    index = i;
                }
            }

            sb.append(index).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    static int[] Dijkstra(int N, ArrayList<ArrayList<Edge>> map, int start) {
        boolean[] visited = new boolean[N+1];
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while(!pq.isEmpty()) {
            Edge curr = pq.poll();

            if(visited[curr.index]) continue;
            visited[curr.index] = true;

            for(Edge next : map.get(curr.index)) {
                if(dist[next.index] > dist[curr.index] + next.cost) {
                    dist[next.index] = dist[curr.index] + next.cost;
                    pq.offer(new Edge(next.index, dist[next.index]));
                }
            }
        }

        return dist;
    }
}
