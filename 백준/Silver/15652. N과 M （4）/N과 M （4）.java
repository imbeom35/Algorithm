import java.io.*;
import java.util.*;

public class Main {
	
	private static StringBuilder sb = new StringBuilder();
	private static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] arr = new int[M+1];
		arr[0] = 1;
		
		backtracking(1, arr);
		
		System.out.println(sb.toString());
		
		br.close();
	}
	
	private static void backtracking(int index, int[] arr) {
		if(index == M+1) {
			for(int i=1; i<=M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(arr[index-1] <= i) {
				arr[index] = i;
				backtracking(index+1, arr);
				arr[index] = 0;
			}
		}
	}
}
