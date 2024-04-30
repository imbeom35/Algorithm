import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int durability;
        boolean hasRoobot;

        public Node(int durability, boolean hasRoobot) {
            this.durability = durability;
            this.hasRoobot = hasRoobot;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int step = 0;
        List<Node> belt = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N*2; i++) {
            int val = Integer.parseInt(st.nextToken());
            if(val == 0) cnt++;
            belt.add(new Node(val, false));
        }

        while(cnt < K) {
            step++;

            // 회전
            belt.add(0, belt.remove(belt.size() - 1));
            belt.set(N-1, new Node(belt.get(N-1).durability, false));

            // 이동
            for(int i=N-2; i>=0; i--) {
                if(belt.get(i).hasRoobot && belt.get(i+1).durability > 0 && !belt.get(i+1).hasRoobot) {
                    belt.set(i, new Node(belt.get(i).durability, false));
                    belt.set(i+1, new Node(belt.get(i+1).durability - 1, true));
                    if(belt.get(i+1).durability == 0) {
                        cnt++;
                    }
                }
            }
            belt.set(N-1, new Node(belt.get(N-1).durability, false));

            // 올림
            if(belt.get(0).durability > 0) {
                belt.set(0, new Node(belt.get(0).durability - 1, true));
                if(belt.get(0).durability == 0) {
                    cnt++;
                }
            }
        }

        System.out.println(step);

        br.close();
    }
}
