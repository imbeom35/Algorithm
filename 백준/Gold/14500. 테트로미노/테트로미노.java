import java.io.*;
import java.util.*;

public class Main {
	public static int max = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				int val = arr[n][m] + tetromino(arr, n, m);
				
				if(val > max) {
					max = val;
				}
			}
		}
		
		System.out.println(max);
		
		br.close();
	}
	
	public static int tetromino(int[][] arr, int n, int m) {
		int max = 0;
		int val = 0;
		int[] x = {
				1, 2, 3, 0, 0, 0, 
				1, 1, 0, 
				1, 1, 1, -1, -1, -1, -1, 0, 1, -1, 0, 1, 
				1, 1, 2, 1, 1, 2, 0, 1, 1, 0, -1, -1, 
				1, 2, 2, 1, 2, 2, 0, 0, 1, 0, 0, -1, 0, 0, 1, 0, 0, -1, -1, -2, -2, -1, -2, -2
		};
		int[] y = {
				0, 0, 0, 1, 2, 3, 
				0, 1, 1, 
				-1, 0, 1, -1, 0, 1, 1, 1, 1, -1, -1, -1, 
				0, 1, 1, 0, -1, -1, 1, 1, 2, 1, 1, 2, 
				0, 0, 1, 0, 0, -1, 1, 2, 2, 1, 2, 2, -1, -2, -2, -1, -2, -2, 0, 0, 1, 0, 0, -1
		};
		
		int i = 0;
		while(i < x.length) {
			if(0 <= n+x[i] && n+x[i] < arr.length && 0 <= m+y[i] && m+y[i] < arr[0].length) {
				val += arr[n+x[i]][m+y[i]];
			}
			
			if((i+1)%3 == 0) {
				if(max < val) {
					max = val;
				}
				val = 0;
			}
			
			i++;
		}
		
		return max;
	}
}
