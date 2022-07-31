import java.util.Scanner;

public class Main{
	public static int bc(int x) {
		int y=1;
		
		while(x > 0) {
			y = x*y;
			
			x--;
		}
		
		return y;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N, K, result;
		
		N = scan.nextInt();
		K = scan.nextInt();
		
		result = bc(N)/(bc(N-K)*bc(K));
		
		System.out.print(result);
		
		scan.close();
	}
	
}