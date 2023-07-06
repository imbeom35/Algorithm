import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int cut = (int)Math.round((double)N*15/100);
        int sum = 0;

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        for(int i=cut; i<N-cut; i++) {
            sum += arr[i];
        }

        System.out.println((int)Math.round((double)sum / (N - cut * 2)));

        br.close();
    }
}
