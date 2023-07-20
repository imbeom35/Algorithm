import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] input = new int[N];
        int[] numbers = new int[M];
        boolean[] visited = new boolean[N];
        for(int i=0; i<N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        
        // 정렬
        Arrays.sort(input);

        perm(input, numbers, visited, 0);

        System.out.println(sb.toString());

        br.close();
    }

    public static void perm(int[] input, int[] numbers, boolean[] visited, int cnt) {
        if(cnt == M) {
            String str = Arrays.toString(numbers).replaceAll(",", "");
            sb.append(str.substring(1, str.length()-1) + "\n");
            return;
        }

        for(int i=0; i<input.length; i++) {
            if(visited[i]) continue;
            numbers[cnt] = input[i];
            visited[i] = true;
            perm(input, numbers, visited, cnt+1);
            visited[i] = false;
        }
    }
}
