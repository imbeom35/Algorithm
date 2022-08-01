import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int[] array = new int[4];
		int x, y, w, h;
		
		Scanner scan = new Scanner(System.in);
		
		x = scan.nextInt();
		y = scan.nextInt();
		w = scan.nextInt();
		h = scan.nextInt();
		
		array[0] = x;
		array[1] = y;
		array[2] = w-x;
		array[3] = h-y;
		
		Arrays.sort(array);
		System.out.println(array[0]);
		
		scan.close();
	}
}
