import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String result = "";

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            if(N > 16*3) {
                // 비둘기집 원리
                result += "0\n";
            } else {
                int minValue = 100;
                String[] mbti = new String[N];

                for(int i=0; i<N; i++) {
                    mbti[i] = st.nextToken();
                }

                int cnt1, cnt2, cnt3;
                for(int i=0; i<N; i++) {
                    for(int j=i+1; j<N; j++) {
                        cnt1 = 0;
                        for(int c=0; c<4; c++) {
                            if(mbti[i].charAt(c) != mbti[j].charAt(c)) {
                                cnt1++;
                            }
                        }

                        for(int k=j+1; k<N; k++) {
                            cnt2 = 0;
                            for(int c=0; c<4; c++) {
                                if(mbti[j].charAt(c) != mbti[k].charAt(c)) {
                                    cnt2++;
                                }
                            }
                            cnt3 = 0;
                            for(int c=0; c<4; c++) {
                                if(mbti[i].charAt(c) != mbti[k].charAt(c)) {
                                    cnt3++;
                                }
                            }
                            minValue =  Math.min(minValue, cnt1+cnt2+cnt3);
                        }
                    }
                }

                result += minValue + "\n";
            }
        }

        System.out.println(result);

        br.close();
    }
}
