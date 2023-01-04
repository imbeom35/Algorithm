import java.io.*;

public class Main {
	public static int MIN = 100;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		dfs(N, 1, 0);
		System.out.println(MIN);
		
		br.close();
	}
	
	public static void dfs(int x, int count, int a) {
		if(count < 5) {
			for(int i=1+a; i<x+1; i++) {
				if(x - i*i > 0) {
					dfs(x - i*i, count+1, i-1);
				}else if(x - i*i == 0) {
					if(MIN > count) {
						MIN = count;
					}
				}else {
					break;
				}
			}
		}
	}
}
