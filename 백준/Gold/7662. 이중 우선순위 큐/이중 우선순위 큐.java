import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> que = new TreeMap<>();
			
			for(int j=0; j<N; j++) {
				String[] input = br.readLine().split(" ");
				char ch = input[0].charAt(0);
				int n = Integer.parseInt(input[1]);
				
				if(ch == 'I') {
					que.put(n, que.getOrDefault(n, 0) + 1);
				} else {
					if(que.size() == 0) {
						continue;
					}else {
						int num = n == 1 ? que.lastKey() : que.firstKey();
						if(que.put(num, que.get(num) - 1) == 1) {
							que.remove(num);
						}
					}
				}
			}
			
			sb.append(que.size() == 0 ? "EMPTY" : que.lastKey() + " " + que.firstKey());
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}
}
