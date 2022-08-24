import java.util.Arrays;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int[] x = new int[N];
		int sum = 0;
		int max = -4000;
		int min = 4000;
		
		for(int i=0; i<N; i++) {
			x[i] = scan.nextInt();
			sum = sum + x[i];
			if(x[i] > max) {
				max = x[i];
			}
			if(x[i] < min) {
				min = x[i];
			}
		}
		
		Arrays.sort(x);
		System.out.println(Math.round((double)sum/N));
		System.out.println(x[Math.round(N/2)]);
		System.out.println(Mode(x));
		System.out.println(max - min);
		
		scan.close();
	}
	
	public static int Mode(int[] arr) {
		int[] counting = new int[8001];
		int max = 0;
		int mod = 0;
	    boolean flag = false;
		
		for(int i=0; i<arr.length; i++) {
			counting[arr[i]+4000]++;
		}
	      
		for(int i=0; i<counting.length; i++) {
			if(max < counting[i]) {
				max = counting[i];
				mod = i;
				flag = true;
			} else if(max == counting[i] && flag == true) {
				max = counting[i];
				mod = i;
				flag = false;
			}
		}
	      
		return mod-4000;
	}
}