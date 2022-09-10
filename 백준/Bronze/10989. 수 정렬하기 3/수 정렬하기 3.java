import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] counting = new int[10000 + 1];
		
		for(int i=0; i<N; i++) {
			counting[Integer.parseInt(br.readLine())]++;
		}
		
		br.close();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<counting.length; i++) {
			while(counting[i] > 0) {
				sb.append(i).append('\n');
				counting[i]--;
			}
		}
		
		System.out.println(sb);
	}
}
