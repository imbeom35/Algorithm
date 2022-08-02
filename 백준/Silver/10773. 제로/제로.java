import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int K = scan.nextInt();
		int[] N = new int[K+1];
		int x = 0;
		int sum = 0;
		
		for(int i=0; i<K; i++) {
			x = scan.nextInt();
			if(x == 0) {
				pop(N);
			} else {
				push(N, x);
			}
		}
		
		for(int i=0; i<N[0]; i++) {
			sum += N[i+1];
		}
		
		System.out.println(sum);
		
		scan.close();
	}
	
	public static void push(int[] arr, int val) {
		arr[arr[0]+1] = val;
		arr[0]++;
	}
	
	public static void pop(int[] arr) {
		arr[arr[0]] = 0;
		arr[0]--;
	}
}
