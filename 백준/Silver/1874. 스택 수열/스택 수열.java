import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int[] arr = new int[n];			//수열
		int[] stack = new int[n+1];		//스택
		char[] result = new char[n*2]; 	//연산
		
		for(int i=0; i<n; i++) {
			arr[i] = scan.nextInt();
		}
		
		int count = 0;	//수열배열 접근변수
		int num = 1;	//1부터 순차적으로 올라가는 숫자
		int x = 0;		//연산배열 접근변수
		
		while(count != n) {	//수열배열을 초과해서 접근하게 되는 경우 종료
			if(arr[count] == num) {			//수열과 숫자가 일치하는 경우
				stack = push(stack, num);
				result[x] = '+';
				x++;
				
				stack = pop(stack);
				result[x] = '-';
				x++;
				
				count++;
				num++;
			} else if(arr[count] < num) {	//수열보다 숫자가 큰 경우
				if(arr[count] == stack[stack[0]]) {
					stack = pop(stack);
					result[x] = '-';
					x++;
					
					count++;
				} else {
					break;
				}
			} else {	//수열보다 숫자가 작은 경우
				stack = push(stack, num);
				result[x] = '+';
				x++;
				
				num++;
			}
			
		}
		
		if(count == n) {
			for(int i=0; i<n*2; i++) {
				System.out.println(result[i]);
			}
		} else {
			System.out.print("NO");
		}
		
		scan.close();
	}
	
	public static int[] push(int[] stack, int val) {
		if(stack.length > stack[0]) {
			stack[0]++;
			stack[stack[0]] = val;
		}
		
		return stack;
	}
	
	public static int[] pop(int[] stack) {
		if(stack[0] > 0) {
			stack[stack[0]] = 0;
			stack[0] = stack[0] - 1;
		}
		
		return stack;
	}
}
