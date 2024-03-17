import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[] tops) {
        int answer = 0;
        int[] a = new int[n + 1]; // 왼쪽, 위, 정삼각형
        int[] b = new int[n + 1]; // 오른쪽
        
        a[1] = 2 + (( tops[0] == 1 ) ? 1 : 0);
        b[1] = 1;
        
        for(int i=2; i<=n; i++) {
            int top = ( tops[i-1] == 1 ) ? 1 : 0;
            // a의 경우의 수와 b의 경우의 수를 구분하여 계산한다.
            a[i] = (a[i-1] * (2 + top) + b[i-1] * (1 + top)) % 10007;
            // 오른쪽을 둘 때에는 전 회차의 경우에 수에 영향을 받지 않는다.
            b[i] = (b[i-1] + a[i-1]) % 10007;
        }
        
        answer = (a[n] + b[n]) % 10007;
        return answer;
    }
}