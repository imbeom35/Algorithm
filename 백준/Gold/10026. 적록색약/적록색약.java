import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		int[][] normal = new int[N][N];
		int[][] rg = new int[N][N];
		int normal_count = 1;
		int rg_count = 1;
		
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 'R') {
					normal[i][j] = -2;
					rg[i][j] = -1;
				}else if(map[i][j] == 'G') {
					normal[i][j] = -1;
					rg[i][j] = -1;
				}else {
					normal[i][j] = 0;
					rg[i][j] = 0;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(DFS(normal, i, j, normal[i][j], normal_count) == true) {
					normal_count++;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(DFS(rg, i, j, rg[i][j], rg_count) == true) {
					rg_count++;
				}
			}
		}
		
		normal_count--;
		rg_count--;
		System.out.println(normal_count + " " + rg_count);
		
		br.close();
	}
	
	public static boolean DFS(int[][] arr, int x, int y, int val, int count) {
		if(0 <= x && x < arr.length && 0 <= y && y < arr.length) {
			if(arr[x][y] != val || arr[x][y] > 0) {
				return false;
			}else {
				arr[x][y] = count;
			}
			
			DFS(arr, x+1, y, val, count);
			DFS(arr, x-1, y, val, count);
			DFS(arr, x, y+1, val, count);
			DFS(arr, x, y-1, val, count);
			
			return true;
		}else {
			return false;
		}
	}
}
