import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, String> dictionary1 = new HashMap<>(N);
		HashMap<String, Integer> dictionary2 = new HashMap<>(N);
		String[] question = new String[M];
		StringBuilder answer = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			String n = br.readLine();
			dictionary1.put(i+1, n);
			dictionary2.put(n, i+1);
		}
		
		for(int i=0; i<M; i++) {
			question[i] = br.readLine();
		}
		
		for(int i=0; i<M; i++) {
			int x = (int)question[i].charAt(0);
			if(48 <= x && x <= 57) {
				answer.append(dictionary1.get(Integer.parseInt(question[i]))).append("\n");
			} else {
				answer.append(dictionary2.get(question[i])).append("\n");
			}
		}
		
		System.out.println(answer);
		
		br.close();
	}
}
