import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;

    static int find(int[] parent, int x) {
        if(parent[x] == x) return x;
        return find(parent, parent[x]);
    }

    static boolean union(int[] parent, int x, int y) {
        x = find(parent, x);
        y = find(parent, y);

        if(x == y) return false;

        if(x <= y) parent[y] = x;
        else parent[x] = y;
        return true;
    }

    static class Edge implements Comparable<Edge> {
        int x;
        int y;
        int weight;

        Edge(int from, int to, int weight) {
            this.x = from;
            this.y = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        List<Edge> graph = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.add(new Edge(from, to, weight));
        }

        System.out.println(kruskal(graph));

        br.close();
    }

    static int kruskal(List<Edge> graph) {
        Collections.sort(graph, Collections.reverseOrder());

        int ans = 0;
        int[] parent = new int[N+1];
        for(int i=0; i<=N; i++) parent[i] = i;

        List<Integer> list = new ArrayList<>();

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i=0; i<M; i++) {
            pq.add(graph.get(i));
        }

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();

            if(union(parent, edge.x, edge.y)) {
                list.add(edge.weight);
            }
        }

        Collections.sort(list, Collections.reverseOrder());
        for(int i=1; i<list.size(); i++) {
            ans += list.get(i);
        }

        return ans;
    }

}
