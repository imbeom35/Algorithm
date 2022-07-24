import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int M = scan.nextInt();
		int[] x = new int[N];
		int top = 0;
		int bot = 0;
		
		for(int i=0; i<N; i++) {
			x[i] = scan.nextInt();
			if(top < x[i]) {
				top = x[i];
			}
		}
		
		while(bot < top) {
			int mid = (top + bot)/2;
			long sum = 0;
			for(int i=0; i<N; i++) {
				if(mid < x[i]) {
					sum += x[i] - mid;
				}
			}
			
			if(sum < M) {
				top = mid;
			} else {
				bot = mid + 1;
			}
		}
		
		System.out.println(bot - 1);
		
		scan.close();
	}
}