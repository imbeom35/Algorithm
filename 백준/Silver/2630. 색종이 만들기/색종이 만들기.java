import java.io.*;
import java.util.*;

public class Main {
	static int white = 0;
	static int blue = 0;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		CutPaper(0, 0, N);
		
		System.out.println(white);
		System.out.println(blue);
		
		br.close();
	}
	
	public static void CutPaper(int x, int y, int size) {
		for(int i=y; i<y+size; i++) {
			for(int j=x; j<x+size; j++) {
				if(arr[y][x] != arr[i][j]) {
					CutPaper(x, y, size/2);
					CutPaper(x+size/2, y, size/2);
					CutPaper(x, y+size/2, size/2);
					CutPaper(x+size/2, y+size/2, size/2);
					
					return;
				}
			}
		}
		
		if(arr[y][x] == 0) {
			white++;
		}else {
			blue++;
		}
	}
}
