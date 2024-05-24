import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static ArrayList<Integer> list;
    static boolean[] visited;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        num = new int[N + 1];
        for (int i=1; i<=N; i++) num[i] = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        visited = new boolean[N + 1];
        for (int i=1; i<=N; i++) {
            visited[i] = true;
            findCycle(i, i);
            visited[i] = false;
        }

        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for(int n : list) sb.append(n).append("\n");
        System.out.println(sb);
        br.close();
    }

    static void findCycle(int start, int target) {
        if(!visited[num[start]]) {
            visited[num[start]] = true;
            findCycle(num[start], target);
            visited[num[start]] = false;
        }
        if(num[start] == target) {
            list.add(target);
        }
    }
}
