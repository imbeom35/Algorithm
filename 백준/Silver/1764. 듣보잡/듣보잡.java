import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> n = new HashMap<>(N);
		String[] string = new String[M];
		int count = 0;
		
		for(int i=0; i<N; i++) {
			n.put(br.readLine(), i);
		}
		
		for(int i=0; i<M; i++) {
			string[i] = br.readLine();
		}
		
		Arrays.sort(string);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<M; i++) {
			if(n.get(string[i]) != null) {
				sb.append(string[i]).append("\n");
				count++;
			}
		}
		
		System.out.println(count);
		System.out.println(sb);
		
		br.close();
	}
}
