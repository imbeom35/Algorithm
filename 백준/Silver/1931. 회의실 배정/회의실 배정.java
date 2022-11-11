import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//입력
		int N = Integer.parseInt(br.readLine());
		int[][] M = new int[N][2];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			M[i][0] = Integer.parseInt(st.nextToken());
			M[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//정렬
		Arrays.sort(M, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}else {
					return o1[1] - o2[1];
				}
			}
		});
		
		//알고리즘
		int count = 0;
		int end = 0;
		for(int i=0; i<N; i++) {
			if(end <= M[i][0]) {
				end = M[i][1];
				count++;
			}
		}
		
		System.out.println(count);
		
		br.close();
	}
}
