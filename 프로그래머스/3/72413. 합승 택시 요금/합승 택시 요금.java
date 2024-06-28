import java.util.*;

class Solution {
    public class Edge implements Comparable<Edge> {
        int index;
        int cost;
        
        public Edge(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
        
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    
    public List<List<Edge>> graph = new ArrayList<>();
    public int INF = Integer.MAX_VALUE;
    
    public int[] dijkstra(int n, int x) {
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        
        Arrays.fill(dist, INF);
        dist[x] = 0;
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(x, 0));
        while(!pq.isEmpty()) {
            int curr = pq.poll().index;
            
            if(visited[curr]) continue;
            visited[curr] = true;
            
            for(Edge next : graph.get(curr)) {
                if(dist[next.index] > dist[curr] + next.cost) {
                    dist[next.index] = dist[curr] + next.cost;
                    pq.offer(new Edge(next.index, dist[next.index]));
                }
            }
        }
        
        return dist;
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] fare : fares) {
            int from = fare[0];
            int to = fare[1];
            int cost = fare[2];
            graph.get(from).add(new Edge(to, cost));
            graph.get(to).add(new Edge(from, cost));
        }
        
        int[] dist_a = dijkstra(n, a);
        int[] dist_b = dijkstra(n, b);
        int[] dist_s = dijkstra(n, s);
        
        int answer = INF;
        for(int i=1; i<=n; i++) {
            answer = Math.min(answer, dist_a[i] + dist_b[i] + dist_s[i]);
        }
        
        return answer;
    }
}