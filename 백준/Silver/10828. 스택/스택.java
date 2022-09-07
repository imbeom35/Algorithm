import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] stack = new int[10000 + 1];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] orders = new String[N];
		
		StringBuilder sb = new StringBuilder();
				
		for(int i=0; i<N; i++) {
			orders[i] = br.readLine();
		}
		
		for(int i=0; i<N; i++) {
			String[] s = orders[i].split(" ");
			String order = s[0];
			
			if(order.equals("pop")) {
				sb.append(pop(stack)).append('\n');
			} else if(order.equals("size")) {
				sb.append(size(stack)).append('\n');
			} else if(order.equals("empty")) {
				sb.append(empty(stack)).append('\n');
			} else if(order.equals("top")) {
				sb.append(top(stack)).append('\n');
			} else if (order.equals("push")) {
				int x = Integer.parseInt(s[1]);
				push(stack, x);
			}
		}
		
		System.out.print(sb);
	}
	
	public static void push(int[] arr, int x) {
		arr[0]++;
		arr[arr[0]] = x;
	}
	
	public static int pop(int[] arr) {
		int val = -1;
		
		if(arr[0] > 0) {
			val = arr[arr[0]];
			arr[0]--;
		}
		
		return val;
	}
	
	public static int size(int[] arr) {
		return arr[0];
	}
	
	public static int empty(int[] arr) {
		if(arr[0] == 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static int top(int[] arr) {
		if(arr[0] > 0) {
			return arr[arr[0]];
		} else {
			return -1;
		}
	}
}
