import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int MAX = 4000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[MAX + 1];
        List<Integer> primeList = new ArrayList<>();

        prime[0] = prime[1] = true;
        
        for(int i=2; i*i<=MAX; i++) {
            if(!prime[i]) {
                for(int j=i*i; j<=MAX; j+=i) {
                    prime[j] = true;
                }
            }
        }

        for(int i=0; i<=MAX; i++) {
            if(!prime[i]) primeList.add(i);
        }

        int size = primeList.size();
        int left = 0;
        int right = 0;
        int count = 0;

        while(true) {
            int sum = 0;
            for(int i=left; i<=right; i++) sum += primeList.get(i);

            if(sum == N) {
                count++;
                right++;
            } else if(sum < N) {
                right++;
            } else {
                left++;
            }

            if (right == size || left == size || left > right) {
                break;
            }
        }

        System.out.println(count);

        br.close();
    }
}
