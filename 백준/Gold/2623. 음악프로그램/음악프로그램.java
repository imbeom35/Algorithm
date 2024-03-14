import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static ArrayList<Integer> result = new ArrayList<>();
    static int N, M;
    static int[] indegree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        indegree = new int[N+1];
        for(int i=0; i<N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            String[] str = br.readLine().split(" ");
            int size = Integer.parseInt(str[0]);
            for(int j=2; j<size+1; j++) {
                int a = Integer.parseInt(str[j-1]);
                int b = Integer.parseInt(str[j]);
                graph.get(a).add(b);
                indegree[b]++;
            }
        }

        topologicalSort();

        if(result.size() == N) {
            for(int i=0; i<result.size(); i++) {
                sb.append(result.get(i) + "\n");
            }
        } else {
            sb.append(0);
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    static void topologicalSort() {
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=N; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            result.add(curr);

            for(int next : graph.get(curr)) {
                indegree[next]--;
                if(indegree[next] == 0) queue.offer(next);
            }
        }
    }
}
