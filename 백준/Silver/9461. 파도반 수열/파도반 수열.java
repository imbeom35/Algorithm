import java.io.*;

public class Main {
	static long[] sequence = new long[101];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sequence[1] = 1;
		sequence[2] = 1;
		sequence[3] = 1;
		sequence[4] = 2;
		sequence[5] = 2;
		
		for(int i=6; i<101; i++) {
			sequence[i] = sequence[i-1] + sequence[i-5];
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			sb.append(sequence[N] + "\n");
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}
}
