import java.util.*;

public class Solution {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		for(int i=0; i<N; i++) {
			String value = sc.next();
			int number = sc.nextInt();
			int[] arr = new int[value.length()];
			
			for(int j=0; j<arr.length; j++) {
				arr[j] = value.charAt(j) - '0';
			}
			
			sb.append("#" + (i+1) + " " + change(arr, number) + '\n');
		}
		
		
		
		System.out.println(sb.toString());
		
		sc.close();
	}
	
	public static int change(int[] arr, int number) {
		boolean same = false;
		int front = 0;
		int max = 0;
		int max_num = 0;
		int sub = 0;
		int sum = 0;
		
		// 같은 값이 있는지 확인
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++){
				if(arr[i] == arr[j]) {
					same = true;
					break;
				}
			}
		}
		
		while(number > 0) {
			max = 0;
			max_num = 0;
			
			// 두개 남았을 경우
			if(arr.length - front <= 2) {
				if(same == true) {
					break;
				}else {
					sub = arr[front];
					arr[front] = arr[front+1];
					arr[front+1] = sub;
					number--;
					
					continue;
				}
			}
			
			// 최댓값 구하기
			int best = number;
			for(int j=arr.length-1; j>=front; j--) {
				if(max < arr[j]) {
					max = arr[j];
					max_num = j;
				}
				
				if(max == arr[j] && best > 0) {
					max = arr[j];
					max_num = j;
					best--;
				}
			}
			
			// 맨 앞자리가 이미 최댓값일 경우 재탐색
			if(arr[front] == max) {
				front++;
			}
			// 최댓값과 교환
			else {
				sub = arr[front];
				arr[front] = max;
				arr[max_num] = sub;
				front++;
				number--;
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			int x = arr.length - i - 1;
			
			sum += Math.pow(10, i)*arr[x];
		}
		
		return sum;
	}
}
