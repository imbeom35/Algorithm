import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K;
    static int[] cost, indegree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            cost = new int[N+1];
            indegree = new int[N+1];

            List<List<Integer>> list = new ArrayList<>();
            for(int i=0; i<N+1; i++) {
                list.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for (int i=1; i<N+1; i++) {
                cost[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                list.get(x).add(y);
                indegree[y]++;
            }

            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());

            topologicalSort(indegree, list, W);
        }

        System.out.println(sb.toString());

        br.close();
    }

    static void topologicalSort(int[] indegree, List<List<Integer>> list, int W) {
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[N+1];

        for(int i=1; i<N+1; i++) {
            result[i] = cost[i];

            if(indegree[i] == 0) queue.offer(i);
        }

        while(!queue.isEmpty()) {
            int curr = queue.poll();

            for(int next : list.get(curr)) {
                result[next] = Math.max(result[next], result[curr] + cost[next]);
                indegree[next]--;

                if(indegree[next] == 0) queue.offer(next);
            }
        }
        sb.append(result[W]).append('\n');
    }

}
