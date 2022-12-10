import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<>();
			
			for(int j=0; j<N; j++) {
				String[] input = br.readLine().split(" ");
				map.put(input[1], map.getOrDefault(input[1], 0)+1);
				
				
			}
			
			Iterator<String> keys = map.keySet().iterator();
			int sum = 1;
			
			while(keys.hasNext()) {
				sum *= map.get(keys.next()) + 1;
			}
			
			sum = sum - 1;
			sb.append(sum + "\n");
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}
}
