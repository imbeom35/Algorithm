import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] S = new int[20];
		String[] input = new String[2];
		String cmd = "";
		int x = 0;
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<M; i++) {
			input = br.readLine().split(" ");
			cmd = input[0];
			
			switch(cmd) {
			case "add":
				x = Integer.parseInt(input[1]);
				S[x-1] = 1;
				break;
			case "remove":
				x = Integer.parseInt(input[1]);
				S[x-1] = 0;
				break;
			case "check":
				x = Integer.parseInt(input[1]);
				sb.append(S[x-1] + "\n");
				break;
			case "toggle":
				x = Integer.parseInt(input[1]);
				if(S[x-1] == 0) {
					S[x-1] = 1;
				}else {
					S[x-1] = 0;
				}
				break;
			case "all":
				for(int j=0; j<S.length; j++) {
					S[j] = 1;
				}
				break;
			case "empty":
				for(int j=0; j<S.length; j++) {
					S[j] = 0;
				}
				break;
			}
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}
}