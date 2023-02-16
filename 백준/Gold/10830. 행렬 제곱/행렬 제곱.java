import java.io.*;
import java.util.*;

public class Main {
	static int[][] matrix;
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); 
		long B = Long.parseLong(st.nextToken()); 
		matrix = new int[N][N];
		
		for(int y=0; y<N; y++) {
			st = new StringTokenizer(br.readLine());
			
			for(int x=0; x<N; x++) {
				matrix[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] result = bfs(B);
		
		for(int y=0; y<N; y++) {
			for(int x=0; x<N; x++) {
				sb.append(result[y][x]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
	}
	
	static int[][] bfs(long B) {
		if(B <= 0) {
			return new int[N][N];
		}else if(B == 1) {
			int[][] temp = new int[N][N];
			for(int y=0; y<N; y++) {
				for(int x=0; x<N; x++) {
					if(y==x) {
						temp[y][x] = 1;
					}
				}
			}
			
			return getProduct(matrix, temp);
		}else if(B == 2) {
			return getProduct(matrix, matrix);
		}else {
			if(B%2 == 0) {
				int[][] temp = bfs(B/2);
				return getProduct(temp, temp);
			}else {
				return getProduct(bfs(B-1), matrix);
			}
		}
	}
	
	static int[][] getProduct(int[][] arr1, int[][] arr2) {
		int[][] result = new int[N][N];
		
		for(int y=0; y<N; y++) {
			for(int x=0; x<N; x++) {
				for(int index=0; index<N; index++) {
					result[y][x] += (arr1[y][index] % 1000)*(arr2[index][x] % 1000) % 1000;
				}
				result[y][x] %= 1000;
			}
		}
		
		return result;
	}
}
