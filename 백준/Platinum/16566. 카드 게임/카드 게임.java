import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[] cardList;
    static int[] playCard;
    static boolean[] pickedCard;
    static int[] parent;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        pickedCard = new boolean[N + 1];
        cardList = new int[M];
        playCard = new int[K];
        parent = new int[M];

        for(int i=0; i<M; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            pickedCard[Integer.parseInt(st.nextToken())] = true;
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++) {
            playCard[i] = Integer.parseInt(st.nextToken());
        }

        //counting sort
        int cnt = 0;
        for(int i=0; i<N+1; i++) {
            if(pickedCard[i]) {
                cardList[cnt] = i;
                cnt++;
            }
        }

        //union-find
        for(int i=0; i<K; i++) {
            int curr = playCard[i];
            int idx = binarySearch(curr);
            idx = find(idx);

            sb.append(cardList[idx]).append("\n");
            if(idx != M-1) union(idx, idx+1);
        }

        System.out.println(sb);

        br.close();
    }

    static int binarySearch(int target) {
        int left = 0;
        int right = M - 1;
        int mid;

        while(left < right) {
            mid = (left + right) / 2;
            if(cardList[mid] < target) left = mid + 1;
            else if(cardList[mid] > target) right = mid;
            else return mid + 1;
        }

        return left;
    }

    static int find(int a) {
        if(a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a > b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
}
