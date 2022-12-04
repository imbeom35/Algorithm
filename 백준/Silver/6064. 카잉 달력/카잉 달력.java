import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			
			sb.append(Calendar(M, N, x, y) + "\n");
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}
	
	public static int Calendar(int M, int N, int x, int y) {
		int xval = x;
		
		while(xval < M*N) {
			if(xval%N == y) {
				return xval+1;
			}
			
			xval = xval+M;
		}
		
		return -1;
	}
}
