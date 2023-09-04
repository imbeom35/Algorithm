import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Jewelry {
        int mass; // 무게
        int value; // 가격

        Jewelry(int mass, int value) {
            this.mass = mass;
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long ans = 0;

        Jewelry[] jewelries = new Jewelry[N];
        int[] bags = new int[K];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int mass = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            jewelries[i] = new Jewelry(mass, value);
        }

        Arrays.sort(jewelries, new Comparator<Jewelry>() {
            @Override
            public int compare(Jewelry o1, Jewelry o2) {
                if(o1.mass == o2.mass) {
                    return o2.value - o1.value;
                }
                return o1.mass - o2.mass;
            }
        });

        for(int i=0; i<K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i=0, j=0; i<K; i++) {
            while (j < N && jewelries[j].mass <= bags[i]) {
                pq.offer(jewelries[j++].value);
            }

            if(!pq.isEmpty()) {
                ans += pq.poll();
            }
        }

        System.out.println(ans);

        br.close();
    }
}
