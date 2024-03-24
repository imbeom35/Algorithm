import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        double value;

        public Edge(int from, int to, double value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.value, o.value);
        }
    }

    static Queue<Edge> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double ans = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] pipe = new int[N+1][2];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            pipe[i][0] = Integer.parseInt(st.nextToken());
            pipe[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] parents = new int[N+1];
        for(int i=1; i<=N; i++) parents[i] = i;

        //기존 연결
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(parents, a, b);
        }

        getDistance(pipe);

        //신규 연결
        while(!pq.isEmpty()) {
            Edge curr = pq.poll();
            if(union(parents, curr.from, curr.to)) {
                ans += curr.value;
            }
        }

        System.out.printf(String.format("%.2f", ans));

        br.close();
    }

    public static int find(int[] parents, int x) {
        if(x == parents[x]) return x;
        else return parents[x] = find(parents, parents[x]);
    }

    public static boolean union(int[] parents, int a, int b) {
        a = find(parents, a);
        b = find(parents, b);
        if(a != b) {
            parents[a] = b;
            return true;
        }
        return false;
    }

    public static void getDistance(int[][] pipe) {
        for(int i=1; i<pipe.length; i++) {
            for(int j=i+1; j< pipe.length; j++) {
                int a = pipe[i][0] - pipe[j][0];
                int b = pipe[i][1] - pipe[j][1];
                double dist = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
                pq.add(new Edge(i, j, dist));
            }
        }
    }
}
