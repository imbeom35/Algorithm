import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            char[] line = br.readLine().toCharArray();
            int W = Integer.parseInt(br.readLine());
            int max = 0;
            int min = Integer.MAX_VALUE;

            for(int i=0; i<line.length; i++) {
                int cnt = 0;
                for(int j=i; j<line.length; j++) {
                    if(line[i] == line[j]) {
                        cnt++;
                    }

                    if(cnt == W) {
                        max = Math.max(max, j - i + 1);
                        min = Math.min(min, j - i + 1);
                        break;
                    }
                }
            }

            if(min == Integer.MAX_VALUE) {
                sb.append("-1").append("\n");
            } else {
                sb.append(min).append(" ").append(max).append("\n");
            }
        }

        System.out.println(sb);

        br.close();
    }
}
