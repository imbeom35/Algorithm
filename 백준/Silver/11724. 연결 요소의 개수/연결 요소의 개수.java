import java.io.*;
import java.util.*;

public class Main {
	static boolean[] check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] arr = new boolean[N][N];
		check = new boolean[N];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			arr[x][y] = true;
			arr[y][x] = true;
		}
		
		int count = 0;
		
		for(int i=0; i<N; i++) {
			if(check[i] == false) {
				dfs(arr, i);
				count++;
			}
		}
		
		System.out.println(count);
		
		br.close();
	}
	
	public static void dfs(boolean[][] arr, int x) {
		for(int i=0; i<arr.length; i++) {
			if(arr[x][i] == true) {
				arr[x][i] = false;
				arr[i][x] = false;
				
				dfs(arr, i);
			}
			
			check[x] = true;
		}
	}
}
