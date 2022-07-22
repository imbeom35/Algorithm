import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int[] x = new int[N*2];
		
		for(int i=0; i<N; i++) {
			x[i] = i+1;
		}
		
		for(int i=0; i<N-2; i++) {
			x[N+i] = x[i*2+1];
		}
		if(N != 1) {
			System.out.println(x[N*2-3]);
		}else {
			System.out.println("1");
		}
		
		scan.close();
	}
}
