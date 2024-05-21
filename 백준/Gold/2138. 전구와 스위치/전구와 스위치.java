import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] currentA = new int[N];
        int[] currentB = new int[N];
        int[] target = new int[N];
        int ansA = 0;
        int ansB = 0;

        String input1 = br.readLine();
        String input2 = br.readLine();
        for(int i=0; i<N; i++) {
            currentA[i] = input1.charAt(i) - '0';
            currentB[i] = input1.charAt(i) - '0';
            target[i] = input2.charAt(i) - '0';
        }
        press(currentA, 0);
        ansA++;

        for(int i=1; i<N; i++) {
            if(currentA[i-1] != target[i-1]) {
                press(currentA, i);
                ansA++;
            }

            if(currentB[i-1] != target[i-1]) {
                press(currentB, i);
                ansB++;
            }
        }

        int ans = Integer.MAX_VALUE;
        if(currentA[N-1] == target[N-1]) ans = ansA;
        if(currentB[N-1] == target[N-1]) ans = Math.min(ans, ansB);

        System.out.println(ans != Integer.MAX_VALUE ? ans : -1);

        br.close();
    }

    static void press(int[] current, int index) {
        current[index] = current[index] == 1 ? 0 : 1;
        if(index - 1 >= 0) current[index - 1] = current[index - 1] == 1 ? 0 : 1;
        if(index + 1 < current.length) {
            current[index + 1] = current[index + 1] == 1 ? 0 : 1;
        }
    }
}
