import java.io.*;

public class Main {
    static long mod = 1000000007;

    static long[][] square(long[][] arr1, long[][] arr2) {
        long[][] new_arr = new long[8][8];
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                for(int k=0; k<8; k++) {
                    new_arr[i][j] = (new_arr[i][j] + (arr1[i][k] * arr2[k][j]) % mod) % mod;
                }
            }
        }
        return new_arr;
    }

    static long[][] divide(long[][] arr, long N) {
        if(N == 1) return arr;
        if(N % 2 == 0) {
            long[][] arr1 = divide(arr, N / 2);
            return square(arr1, arr1);
        }
        else return square(divide(arr, N-1), arr);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long[][] arr = {
                { 0, 1, 0, 1, 0, 0, 0, 0 },
                { 1, 0, 1, 1, 0, 0, 0, 0 },
                { 0, 1, 0, 1, 1, 1, 0, 0 },
                { 1, 1, 1, 0, 0, 1, 0, 0 },
                { 0, 0, 1, 0, 0, 1, 1, 0 },
                { 0, 0, 1, 1, 1, 0, 0, 1 },
                { 0, 0, 0, 0, 1, 0, 0, 1 },
                { 0, 0, 0, 0, 0, 1, 1, 0 }
        };
        arr = divide(arr, N);
        System.out.println(arr[0][0]);
    }
}
