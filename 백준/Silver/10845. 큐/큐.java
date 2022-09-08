import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] queue = new int[10000];
	static int start = 0;
	static int end = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] orders = new String[10000];
		StringBuilder sb = new StringBuilder();
		
 		for(int i=0; i<N; i++) {
 			orders[i] = br.readLine();
		}
 		
 		for(int i=0; i<N; i++) {
 			StringTokenizer st = new StringTokenizer(orders[i]);
 			String o1 = st.nextToken();
 			if(o1.equals("push")) {
 				push(queue, Integer.parseInt(st.nextToken()));
 			} else if(o1.equals("pop")) {
 				sb.append(pop(queue)).append('\n');
 			} else if(o1.equals("size")) {
 				sb.append(size()).append('\n');
 			} else if(o1.equals("empty")) {
 				sb.append(empty()).append('\n');
 			} else if(o1.equals("front")) {
 				sb.append(front(queue)).append('\n');
 			} else if(o1.equals("back")) {
 				sb.append(back(queue)).append('\n');
 			}
 		}
 		
 		System.out.println(sb);
	}
	
	public static void push(int[] arr, int x) {
		arr[end] = x;
		end++;
	}
	
	public static int pop(int[] arr) {
		int val = arr[start];
		if(start < end) {
			start++;
		} else {
			val = -1;
		}
		
		return val;
	}
	
	public static int size() {
		return end - start;
	}
	
	public static int empty() {
		if(end - start > 0) {
			return 0;
		} else {
			return 1;
		}
	}
	
	public static int front(int[] arr) {
		if(end - start > 0) {
			return arr[start];
		} else {
			return -1;
		}
	}
	
	public static int back(int[] arr) {
		if(end - start > 0) {
			return arr[end-1];
		} else {
			return -1;
		}
	}
}
