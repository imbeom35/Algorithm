import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		int[] H = new int[T];
		int[] W = new int[T];
		int[] N = new int[T];
		
		for(int i=0; i<T; i++) {
			H[i] = scan.nextInt();
			W[i] = scan.nextInt();
			N[i] = scan.nextInt();
		}
		
		for(int i=0; i<T; i++) {
			int X = (N[i] / H[i]) + 1;
			int Y = N[i] % H[i];
			
			if(N[i] % H[i] == 0) {
				Y = H[i];
				X--;
			}
			
			System.out.println(Y*100 + X);
		}
		
		scan.close();
	}
}
