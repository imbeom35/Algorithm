import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> h = new HashMap<>();
		
		for(int i=0; i<N; i++) {
			String[] input = br.readLine().split(" ");
			h.put(input[0], input[1]);
		}
		
		for(int i=0; i<M; i++){
			sb.append(h.get(br.readLine()) + "\n");
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}
}
