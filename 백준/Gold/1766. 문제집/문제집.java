import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[] indegree;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        indegree = new int[N+1];

        graph = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph.get(v1).add(v2);
            indegree[v2]++;
        }

        System.out.println(topologicalSort());

        br.close();
    }

    static String topologicalSort() {
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=1; i<=N; i++) {
            if(indegree[i] == 0) pq.offer(i);
        }

        while(!pq.isEmpty()) {
            int curr = pq.poll();
            sb.append(curr).append(" ");

            for(int next : graph.get(curr)) {
                indegree[next]--;

                if(indegree[next] == 0) {
                    pq.offer(next);
                }
            }
        }

        return sb.toString();
    }
}
