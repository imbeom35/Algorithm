import java.io.*;

public class Main {
	public static int n;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		getAllDecimal(2, 1);
		getAllDecimal(3, 1);
		getAllDecimal(5, 1);
		getAllDecimal(7, 1);
		
		System.out.println(sb);
		
		br.close();
	}
	
	public static void getAllDecimal(int value, int count) {
		if(count >= n) {
			sb.append(value).append("\n");
			return;
		}
		
		for(int i=1; i<10; i++) {
			int newValue = value*10+i;
			
			if(isDecimal(newValue) == true) {
				getAllDecimal(newValue, count+1);
			}
		}
	}
	
	public static boolean isDecimal(int n) {
		for(int i=2; i<=Math.sqrt(n); i++) {
			if(n%i == 0) {
				return false;
			}
		}
		
		return  true;
	}
}
