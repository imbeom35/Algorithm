import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int V, E;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        int[][] edge = new int[E][3];

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            edge[i][0] = Integer.parseInt(st.nextToken());
            edge[i][1] = Integer.parseInt(st.nextToken());
            edge[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(edge, (o1, o2) -> o1[2] - o2[2]);

        kruskal(edge);

        br.close();
    }

    static void union(int[] parent, int x, int y) {
        x = find(parent, x);
        y = find(parent, y);

        if(x < y) parent[y] = x;
        else parent[x] = y;
    }

    static int find(int[] parent, int x) {
        if(parent[x] == x) return x;
        else return find(parent, parent[x]);
    }

    static void kruskal(int[][] edge) {
        int cost = 0;
        int[] parent = new int[V+1];

        for(int i=0; i<parent.length; i++) {
            parent[i] = i;
        }

        for(int i=0; i<edge.length; i++) {
            if(find(parent, edge[i][0]) != find(parent, edge[i][1])) {
                cost += edge[i][2];
                union(parent, edge[i][0], edge[i][1]);
            }
        }

        System.out.println(cost);
    }

}
