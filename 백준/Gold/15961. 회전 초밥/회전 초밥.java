import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] count = new int[d+1];
		
		Queue<Integer> belt = new ArrayDeque<>();
		Queue<Integer> select = new ArrayDeque<>();
		
		// belt 입력
		for(int i=0; i<N; i++) {
			belt.add(Integer.parseInt(br.readLine()));
		}
		
		// select 초기값
		for(int i=0; i<k; i++) {
			int value = belt.poll();
			select.add(value);
			count[value]++;
		}
		
		// 쿠폰 번호
		count[c]++;
		
		// 현재 가짓수 구하기
		int ans = 0;
		int number = 0;
		for(int j=1; j<=d; j++) {
			if(count[j] > 0) {
				number++;
			}
		}
		
		// 모든 경우의 수 구하기
		for(int i=0; i<=N; i++) {
			// belt에서 다음접시를 선택하고 select의 마지막 접시를 버린다.
			int add = belt.poll();
			int remove = select.poll();
			count[remove]--;
			if(count[remove] == 0) number--;
			count[add]++;
			if(count[add] == 1) number++;
			select.add(add);
			// 마지막 접시는 belt에 추가된다.
			belt.add(remove);
			
			//System.out.println(select);
			//System.out.println("number : " + number);
			
			ans = Math.max(ans, number);
		}
		
		System.out.println(ans);
		
		br.close();
	}
}
