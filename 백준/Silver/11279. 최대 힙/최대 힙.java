import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(0);
		
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x == 0) {
				sb.append(Pop(arr) + "\n");
			}else {
				Push(arr, x);
			}
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}
	
	public static void Push(ArrayList<Integer> arr, int val) {
		arr.add(val);
		
		int s = arr.size()-1;
		while(s > 1) {
			if(arr.get(s) > arr.get(s/2)) {
				int temp = arr.get(s);
				arr.set(s, arr.get(s/2));
				arr.set(s/2, temp);
				
				s = s/2;
			}else {
				break;
			}
		}
	}
	
	public static int Pop(ArrayList<Integer> arr) {
		if(arr.size() < 2) {
			return 0;
		}
		
		int val = arr.get(1);
		arr.set(1, arr.get(arr.size() - 1));
		arr.remove(arr.size() - 1);
		
		int pos = 1;
		while(pos*2 < arr.size()) {
			int max = arr.get(pos*2);
			int maxPos = pos*2;
			
			if((pos*2 + 1) < arr.size() && arr.get(pos*2) < arr.get(pos*2+1)) {
				max = arr.get(pos*2+1);
				maxPos = pos*2+1;
			}
			
			if(arr.get(pos) > max) {
				break;
			}
			
			int tmp = arr.get(pos);
			arr.set(pos, max);
			arr.set(maxPos, tmp);
			pos = maxPos;
		}
		
		return val;
	}
}
