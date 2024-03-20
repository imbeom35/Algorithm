import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            cnt = 0;
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N+1];
            boolean[] visited = new boolean[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++) arr[i] = Integer.parseInt(st.nextToken());
            for(int i=1; i<=N; i++) {
                if(!visited[i]) checkLoop(arr, visited, new HashSet<>(), i);
            }
            sb.append(N - cnt).append("\n");
        }

        System.out.println(sb.toString());
        
        br.close();
    }

    public static void checkLoop(int[] arr, boolean[] visited, Set<Integer> list, int x) {
        if(!visited[x]) {
            visited[x] = true;
            list.add(x);
            checkLoop(arr, visited, list, arr[x]);
        }
        else {
            if(list.contains(x)) {
                int loopCnt = 1;
                int next = arr[x];
                while(next != x) {
                    loopCnt++;
                    next = arr[next];
                }

                cnt += loopCnt;
            }
        }
    }
}
