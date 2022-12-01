import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			
			for(int j=0; j<N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		int val = 2;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j] == 1) {
					area(j, i, val);
					val++;
				}
			}
		}
		
		int[] result = new int[val-2];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int k=2; k<val+1; k++) {
					if(arr[i][j] == k) {
						result[k-2]++;
					}
				}
			}
		}
		
		Arrays.sort(result);
		
		StringBuilder sb = new StringBuilder();
		sb.append(result.length + "\n");
		for(int i=0; i<result.length; i++) {
			sb.append(result[i] + "\n");
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}
	
	public static void area(int x, int y, int val) {
		arr[y][x] = val;
		
		try {
			if(arr[y+1][x] == 1) {
				area(x, y+1, val);
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			
		}
		
		try {
			if(arr[y][x+1] == 1) {
				area(x+1, y, val);
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			
		}
		
		
		try {
			if(arr[y-1][x] == 1) {
				area(x, y-1, val);
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			
		}
		
		try {
			if(arr[y][x-1] == 1) {
				area(x-1, y, val);
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			
		}
	}
}
