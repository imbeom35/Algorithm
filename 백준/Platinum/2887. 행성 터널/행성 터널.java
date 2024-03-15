import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int value;

        public Edge(int to, int from, int value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<int[]> data = new ArrayList<>();

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            data.add(new int[] {i, x, y, z});
        }

        Queue<Edge> queue = new PriorityQueue<>();
        for(int i=1; i<=3; i++) {
            int val = i;
            data.sort((o1, o2) -> (o1[val] - o2[val]));
            for(int j=1; j<N; j++) {
                int[] a = data.get(j-1);
                int[] b = data.get(j);
                queue.add(new Edge(a[0], b[0], Math.abs(a[i]-b[i])));
            }
        }

        int[] parents = new int[N];
        for(int i=0; i<N; i++) {
            parents[i] = i;
        }

        int total = 0;
        while(!queue.isEmpty()) {
            Edge edge = queue.poll();
            if(union(parents, edge.from, edge.to)) {
                total += edge.value;
            }
        }

        System.out.println(total);
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

        if(a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }

        return true;
    }
}
