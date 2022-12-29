import java.io.*;

public class Main {
	static Integer[] cal = new Integer[1001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int count = tile(n);
		
		/* 가로 타일이 있는 경우만 계산하므로 1을 추가한다. */
		if(n > 0) {
			count++;
		}
		
		System.out.println(count%10007);
		
		br.close();
	}
	
	public static int tile(int n) {
		if(cal[n] == null) {
			int sum = 0;
			
			for(int i=1; i<n; i++) {
				sum += tile(n-i-1) + 1;
			}
			
			cal[n] = sum%10007;
		}
		
		return cal[n];
	}
}
