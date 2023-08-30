import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    static LinkedHashSet<String> ans;
    static int N, M;
    static int[] nums, perm;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        perm = new int[M];
        visited = new boolean[N];
        ans = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        permutation(0, 0);
        ans.forEach(System.out::println);

        br.close();
    }

    static void permutation(int cnt, int index) {
        if (cnt == M) {
            StringBuilder sb = new StringBuilder();
            for(int p : perm) {
                sb.append(p).append(' ');
            }
            ans.add(sb.toString());
            return;
        }

        for (int i=index; i<N; i++) {
            //if(!visited[i]) {
                visited[i] = true;
                perm[cnt] = nums[i];
                permutation(cnt + 1, i);
                visited[i] = false;
            //}
        }
    }
}
