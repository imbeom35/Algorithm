import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[H][W];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<W; i++) {
            int val = Integer.parseInt(st.nextToken());
            for(int j=0; j<val; j++) map[j][i] = true;
        }

        int ans = 0;
        for(int i=0; i<H; i++) {
            boolean flag = false;
            int temp = 0;
            for(int j=0; j<W; j++) {
                if(map[i][j]) {
                    if(!flag) {
                        flag = true;
                    } else {
                        ans += temp;
                        temp = 0;
                    }
                } else {
                    if(flag) temp++;
                }
            }
        }

        System.out.println(ans);

        br.close();
    }
}
