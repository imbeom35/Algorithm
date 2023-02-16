import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[1001][1001];
		int[] result = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = sx + Integer.parseInt(st.nextToken());
			int ey = sy + Integer.parseInt(st.nextToken());
			
			for(int x=sx; x<ex; x++) {
				for(int y=sy; y<ey; y++) {
					arr[x][y] = i;
				}
			}
		}
		
		for(int x=0; x<1001; x++) {
			for(int y=0; y<1001; y++) {
				result[arr[x][y]]++;
			}
		}
		
		for(int i=1; i<=N; i++) {
			System.out.println(result[i]);
		}
		
		br.close();
	}
}
