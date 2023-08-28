import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final int MAX = 1000000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int result = -1;

        boolean[] field = new boolean[MAX+1];
        field[A] = true;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(A, 1));
        while(!queue.isEmpty()) {
            Node temp = queue.poll();

            if(((long)temp.value * 2) <= MAX && !field[temp.value * 2]) {
                queue.add(new Node(temp.value * 2, temp.count + 1));
                field[temp.value * 2] = true;
            }

            if(((long)temp.value * 10 + 1) <= MAX && !field[temp.value * 10 + 1]) {
                queue.add(new Node(temp.value * 10 + 1, temp.count + 1));
                field[temp.value * 10 + 1] = true;
            }

            if(field[B]) {
                result = temp.count + 1;
                break;
            }
        }

        System.out.println(result);

        br.close();
    }

    public static class Node {
        int value;
        int count;

        Node(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }
}
