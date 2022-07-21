import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int up = 0;
		int i=665;
		
		while(up < N) {
			i++;
			
			int count = 0;
			int x = i;
			int y = (int)Math.pow(10, (int)(Math.log10(x)));
			
			for(int j=0; j<Math.log10(i); j++) {
				if(count != 3) {
					if(x/y == 6) {
						count++;
					}else {
						count = 0;
					}
				}
				x = x%y;
				y = y/10;
			}
			if(count == 3) {
				up++;
			}
			
		}
		
		System.out.print(i);
	}
}