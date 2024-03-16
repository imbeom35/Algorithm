import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static double[][] stars;

    static class Edge implements Comparable<Edge>{
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        stars = new double[n][2];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            stars[i][0] = Double.parseDouble(st.nextToken());
            stars[i][1] = Double.parseDouble(st.nextToken());
        }

        Queue<Edge> pq = new PriorityQueue<>();
        for(int from=0; from<n; from++) {
            for(int to=from+1; to<n; to++) {
                pq.add(new Edge(from, to, calculateDistance(stars[from], stars[to])));
            }
        }

        int[] parents = new int[n];
        for(int i=0; i<n; i++) {
            parents[i] = i;
        }

        double total = 0;
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            int from = edge.from;
            int to = edge.to;
            if(union(parents, from, to)) {
                total += edge.value;
            }
        }

        System.out.printf("%.2f", total);

        br.close();
    }

    public static double calculateDistance(double[] from, double[] to) {
        return Math.sqrt(Math.pow(Math.abs(from[0] - to[0]), 2) + Math.pow(Math.abs(from[1] - to[1]), 2));
    }

    public static int find(int[] parents, int x) {
        if(parents[x] == x) {
            return x;
        }
        return find(parents, parents[x]);
    }

    public static boolean union(int[] parents, int a, int b) {
        a = find(parents, a);
        b = find(parents, b);
        if(a == b) return false;

        if(a > b) {
            parents[a] = b;
        } else {
            parents[b] = a;
        }

        return true;
    }
}
