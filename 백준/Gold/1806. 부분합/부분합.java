import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, S;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        cal(arr);

        br.close();
    }

    static void cal(int[] arr) {
        int s = 0;
        int e = 0;
        int sum = arr[e];

        while(true) {
            if(sum < S) {
                if(e + 1 == N) break;

                e++;
                sum += arr[e];
            }

            else {
                ans = Math.min(ans, e - s + 1);

                sum -= arr[s];
                s++;
            }
        }

        if(ans == Integer.MAX_VALUE) ans = 0;

        System.out.println(ans);
    }

}
