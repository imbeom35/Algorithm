import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        int[] gates = new int[G+1];
        for(int i=1; i<G+1; i++) gates[i] = i;

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<P; i++) queue.add(Integer.parseInt(br.readLine()));

        int answer = 0;
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            int emptyGate = find(gates, curr);
            //도킹 X
            if(emptyGate == 0) break;

            //도킹 요청을 다음위치로 전가
            union(gates, emptyGate, emptyGate - 1);

            answer++;
        }

        System.out.println(answer);

        br.close();
    }

    public static int find(int[] parents, int x) {
        if(parents[x] == x) return x;
        return parents[x] = find(parents, parents[x]);
    }

    public static void union(int[] parents, int a, int b) {
        a = find(parents, a);
        b = find(parents, b);

        if(a == b) return;

        if(a <= b) parents[b] = a;
        parents[a] = b;
    }
}
