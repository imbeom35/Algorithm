import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] indexToCard = new int[N];
        int INF = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            INF = Math.max(INF, indexToCard[i] = Integer.parseInt(st.nextToken()));
        }

        int[] score = new int[N+1];
        int[] cardToIndex = new int[INF+1];
        for(int i=0; i<N; i++) cardToIndex[indexToCard[i]] = i+1;

        for(int i : indexToCard) {
            for(int j=i*2; j<=INF; j+=i) {
                if(cardToIndex[j] != 0) {
                    score[cardToIndex[j]]--;
                    score[cardToIndex[i]]++;
                }
            }
        }

        for(int i=1; i<=N; i++) sb.append(score[i]).append(" ");
        System.out.println(sb);

        br.close();
    }
}
