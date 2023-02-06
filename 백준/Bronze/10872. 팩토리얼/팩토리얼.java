import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(factorial(n));
		
		br.close();
	}
	
	public static int factorial(int n) {
		if(n <= 0) {
			return 1;
		}
		
		return n * factorial(n-1);
	}
}
