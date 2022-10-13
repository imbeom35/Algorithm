import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int zero = 0;
		
		for(int i=2; i<=N; i++) {
			int x = i;
			while(x%10 == 0 || x%5 == 0) {
				if(x%10 == 0) {
					x = x/10;
					zero++;
				}else if(x%5 == 0) {
					x = x/5;
					zero++;
				}
			}
		}
		
		System.out.println(zero);
		
		br.close();
	}
}
