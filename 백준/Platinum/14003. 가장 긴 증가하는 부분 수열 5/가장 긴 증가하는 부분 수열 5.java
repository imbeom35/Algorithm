import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list = new ArrayList<>();
        list.add(Integer.MIN_VALUE);

        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        int[] idx = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int val = Integer.parseInt(st.nextToken());
            seq[i] = val;

            if(list.get(list.size() - 1) < val) {
                list.add(val);
                idx[i] = list.size() - 1;
            } else {
                int left = 1;
                int right = list.size() - 1;

                while(left < right) {
                    int mid = (left + right) / 2;
                    if(list.get(mid) < val) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                list.set(right, val);
                idx[i] = right;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(list.size() - 1 + "\n");

        int index = list.size() - 1;
        Stack<Integer> stack = new Stack<>();

        for(int i=N-1; i>=0; i--) {
            if(idx[i] == index) {
                index--;
                stack.push(seq[i]);
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb);

        br.close();
    }
}
