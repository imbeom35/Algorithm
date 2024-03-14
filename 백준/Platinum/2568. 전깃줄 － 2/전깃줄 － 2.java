import java.io.*;
import java.util.*;

public class Main {
    static int m;
    static int[][] pole;
    static int[] preIndex;
    static ArrayList<Integer> list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        m = Integer.parseInt(br.readLine());
        pole = new int[m][2];
        preIndex = new int[m];
        list = new ArrayList<>();
        list.add(0);

        for(int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pole[i][0] = Integer.parseInt(st.nextToken());
            pole[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pole, Comparator.comparingInt(o -> o[0]));
        sb.append(binarySearch() + "\n");
        willBeRemovedPole();

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static int binarySearch() {
        for(int i=0; i<m; i++) {
            if(list.get(list.size() - 1) < pole[i][1]) {
                list.add(pole[i][1]);
                preIndex[i] = list.size() - 1;
            } else {
                int left = 1;
                int right = list.size() - 1;

                while(left < right) {
                    int mid = (left + right) / 2;

                    if(list.get(mid) < pole[i][1]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                list.set(right, pole[i][1]);
                preIndex[i] = right;
            }
        }

        return m - (list.size() - 1);
    }

    static void willBeRemovedPole() {
        int idx = list.size() - 1;
        Stack<Integer> stk = new Stack<>();

        for(int i=m-1; i>=0; i--) {
            if(preIndex[i] == idx) {
                idx--;
            } else {
                stk.push(pole[i][0]);
            }
        }

        while(!stk.isEmpty()) {
            sb.append(stk.pop() + "\n");
        }
    }
}
