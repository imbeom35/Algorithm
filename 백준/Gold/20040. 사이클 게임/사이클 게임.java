import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][2];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        parents = new int[n];
        for(int i=0; i<n; i++) {
            parents[i] = i;
        }

        int ans = 0;
        for(int i=0; i<m; i++) {
            boolean hasNotCycle = union(arr[i][0], arr[i][1]);
            if(!hasNotCycle) {
                ans = i+1;
                break;
            }
        }

        System.out.println(ans);

        br.close();
    }

    static int find(int x) {
        if(x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a == b) return false;

        if(a > b) parents[a] = b;
        else parents[b] = a;

        return true;
    }
}
