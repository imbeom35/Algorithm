import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(Plus(n) + "\n");
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}
	
	public static int Plus(int n) {
		if(n > 4) {
			return Plus(n-1) + Plus(n-2) + Plus(n-3);
		}else {
			if(n == 1) {
				return 1;
			}else if(n == 2) {
				return 2;
			}else if(n == 3) {
				return 4;
			}else {
				return 7;
			}
		}
	}
}
