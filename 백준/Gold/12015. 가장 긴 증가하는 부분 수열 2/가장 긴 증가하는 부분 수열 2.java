import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] dp;
    static int point = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[1000001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        LIS(0);

        System.out.println(point);

        br.close();
    }

    static void LIS(int n){
        if(n == N) {
            return;
        }

        int left = 0;
        int right = point - 1;
        int mid;
        while(left <= right) {
            mid = (left + right) / 2;
            if(dp[mid] < arr[n]) left = mid + 1;
            else if(dp[mid] >= arr[n]) right = mid - 1;
        }

        if(dp[left] != arr[n]) dp[left] = arr[n];
        if(left == point) point++;

        LIS(n+1);
    }
}