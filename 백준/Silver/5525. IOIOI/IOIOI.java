import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		char[] S = new char[M];
		S = br.readLine().toCharArray();

		System.out.println(Pattern(S, N));
		
		br.close();
	}
	
	public static int Pattern(char[] arr, int N) {
		int count = 0;
		boolean flag = true;
		
		for(int i=0; i<arr.length; i++) {
			flag = true;
			
			if(arr[i] == 'I') {
				int num = 0;
				
				for(int j=i+1; j<arr.length; j++) {
					if(arr[j]=='O' && flag==true) {
						flag = false;
					}else if(arr[j]=='I' && flag==false) {
						flag = true;
						num++;
					}else {
						break;
					}
				}
				
				i = i+num*2;
				
				if(N <= num) {
					count += num - N + 1;
				}
			}
		} 
		
		return count;
	}
}
