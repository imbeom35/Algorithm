import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Group {
        int peopleCnt;
        int candyCnt;

        public Group(int peopleCnt, int candyCnt) {
            this.peopleCnt = peopleCnt;
            this.candyCnt = candyCnt;
        }
    }

    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] candy = new int[N];
        int[][] friends = new int[M][2];

        //input
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            candy[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            friends[i][0] = Integer.parseInt(st.nextToken());
            friends[i][1] = Integer.parseInt(st.nextToken());
        }

        parents = new int[N+1];
        for(int i=1; i<N+1; i++) {
            parents[i] = i;
        }

        //union
        for(int i=0; i<M; i++) {
            union(friends[i][0], friends[i][1]);
        }

        //그룹화
        Map<Integer, Group> map = new HashMap<>();
        for(int i=1; i<=N; i++) {
            int key = find(i);
            if(!map.containsKey(key)) map.put(key, new Group(0, 0));
            int peopleCnt = map.get(key).peopleCnt + 1;
            int candyCnt = map.get(key).candyCnt + candy[i-1];
            map.put(key, new Group(peopleCnt, candyCnt));
        }

        //map to list
        List<Group> list = new ArrayList<>();
        for(int key : map.keySet()) {
            list.add(map.get(key));
        }

        //dp
        int size = list.size();
        int[][] dp = new int[size+1][K];
        for(int i=1; i<size+1; i++) {
            for(int j=0; j<K; j++) {
                Group g = list.get(i-1);

                if(g.peopleCnt > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - g.peopleCnt] + g.candyCnt);
                }
            }
        }
        int max = 0;
        for(int i=0; i<K; i++) max = Math.max(max, dp[size][i]);

        System.out.println(max);

        br.close();
    }

    static int find(int x) {
        if(x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a == b) return;

        if(a < b) parents[b] = a;
        else parents[a] = b;
    }
}
