import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static final int max = 10000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] n = new int[max*2+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		for(int i=0; i<N; i++) {
			n[Integer.parseInt(st.nextToken())+max]++;
		}
		
		int M = Integer.parseInt(br.readLine());
		int[] m = new int[M];
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<M; i++) {
			sb.append(m[i] = n[Integer.parseInt(st.nextToken())+max]).append(' ');
		}
		
		System.out.println(sb);
		
		br.close();
	}
}