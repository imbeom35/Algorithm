import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] input = new int[N];
        int[] numbers = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);

        sequence(input, numbers, 0);

        System.out.println(sb.toString());
        
        br.close();
    }

    public static void sequence(int[] input, int[] numbers ,int cnt) {
        if(cnt == M) {
            String str = Arrays.toString(numbers).replaceAll(",", "");
            sb.append(str.substring(1, str.length()-1) + "\n");
            return;
        }

        for(int i=0; i<N; i++) {
            if(cnt == 0) {
                numbers[cnt] = input[i];
                sequence(input, numbers, cnt + 1);
            }

            else if(numbers[cnt-1] <= input[i]) {
                numbers[cnt] = input[i];
                sequence(input, numbers, cnt + 1);
            }
        }
    }
}