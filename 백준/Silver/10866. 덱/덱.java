import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] deque = new int[20000];
	public static int start = 10000;
	public static int end = 10000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] orders = new String[20000];
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			orders[i] = br.readLine();
		}
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(orders[i]);
			String o1 = st.nextToken();
			if(o1.equals("push_front")) {
				push_front(deque, Integer.parseInt(st.nextToken()));
			} else if(o1.equals("push_back")) {
				push_back(deque, Integer.parseInt(st.nextToken()));
			} else if(o1.equals("pop_front")) {
				sb.append(pop_front(deque)).append('\n');
			} else if(o1.equals("pop_back")) {
				sb.append(pop_back(deque)).append('\n');
			} else if(o1.equals("size")) {
				sb.append(size()).append('\n');
			} else if(o1.equals("empty")) {
				sb.append(empty()).append('\n');
			} else if(o1.equals("front")) {
				sb.append(front(deque)).append('\n');
			} else if(o1.equals("back")) {
				sb.append(back(deque)).append('\n');
			}
		}
		
		System.out.println(sb);
	}
	
	public static void push_front(int[] arr, int x) {
		start--;
		arr[start] = x;
	}
	
	public static void push_back(int[] arr, int x) {
		arr[end] = x;
		end++;
	}
	
	public static int pop_front(int[] arr) {
		int val = -1;
		if(end > start) {
			val = arr[start];
			start++;
		}
		
		return val;
	}
	
	public static int pop_back(int[] arr) {
		int val = -1;
		if(end > start) {
			end--;
			val = arr[end];
		}
		
		return val;
	}
	
	public static int size() {
		return end - start;
	}
	
	public static int empty() {
		if(end > start) {
			return 0;
		} else {
			return 1;
		}
	}
	
	public static int front(int[] arr) {
		if(end > start) {
			return arr[start];
		} else {
			return -1;
		}
	}
	
	public static int back(int[] arr) {
		if(end > start) {
			return arr[end-1];
		} else {
			return -1;
		}
	}
}
