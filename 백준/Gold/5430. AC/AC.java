import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			String com = br.readLine();
			int[] del = new int[2];
			int flag = 0;
			int num = Integer.parseInt(br.readLine());
			int[] arr = new int[num];
			String str = br.readLine();
			str = str.substring(1, str.length()-1);
			StringTokenizer st = new StringTokenizer(str, ",");
			
			for(int j=0; j<num; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			for(int j=0; j<com.length(); j++) {
				if(com.charAt(j) == 'R') {
					if(flag == 0) {
						flag = 1;
					}else {
						flag = 0;
					}
				}else if(com.charAt(j) == 'D') {
					del[flag]++;
				}
			}
			
			if(del[0]+del[1] > arr.length) {
				sb.append("error" + '\n');
				continue;
			}
			
			
			sb.append("[");
			
			if(flag == 0) {
				for(int j=del[0]; j<arr.length-del[1]; j++) {
					sb.append(arr[j]);
					if(j==arr.length-del[1]-1) {
						break;
					}
					sb.append(",");
				}
			}else {
				for(int j=arr.length-1-del[1]; j>=del[0]; j--) {
					sb.append(arr[j]);
					if(j==del[0]) {
						break;
					}
					sb.append(",");
				}
			}
			
			sb.append("]" + '\n');
		}
		
		System.out.print(sb.toString());
		
		br.close();
	}
}
