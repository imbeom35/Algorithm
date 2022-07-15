import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		scan.close();
		
		int x, y;
		int gcd = 1, lcm, tmp;
		
		if(a > b) {
			x = a;
			y = b;
		}else {
			x = b;
			y = a;
		}
		
		while(y != 0) {
			if(x%y == 0) {
				gcd = y;
			}
			tmp = x%y;
			x = y;
			y = tmp;
		}
		
		lcm = a * b / gcd;
		
		System.out.println(gcd);
		System.out.println(lcm);
	}
}