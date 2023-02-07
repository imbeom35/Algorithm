import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		// 스위치들의 상태를 저장하는 배열 구현
		int[] switchs = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			switchs[i] = Integer.parseInt(st.nextToken());
		}
		
		// m명의 사람을 뽑는다.
		int m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			// 성별과 스위번호를 입력받는다.
			int gender = Integer.parseInt(st.nextToken());
			int have = Integer.parseInt(st.nextToken());
			
			if(gender == 1) {
				// 여성일 경우
				manMethod(switchs, have);
			}else if(gender == 2) {
				// 남성일 경우
				womanMethod(switchs, have);
			}
		}
		
		for(int i=0; i<n; i++) {
			if(i != 0 && (i)%20 == 0) {
				sb.append("\n");
			}
			
			sb.append(switchs[i]).append(" ");
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}
	
	// 남성일 경우
	public static void manMethod(int[] switchs, int have) {
		// 가지고 있는 스위치 번호의 배수마다 toggle적용
		for(int i=0; i<switchs.length; i++) {
			if((i+1) % have == 0) {
				switchs[i] = switchToggle(switchs[i]);
			}
		}
	}
	
	// 여성의 경우
	public static void womanMethod(int[] switchs, int have) {
		// 현재위치 저장
		int l = have-1;
		int r = have-1;
		
		while(true) {
			// 오른쪽과 왼쪽으로 각각 한 칸씩 이동
			l--;
			r++;
			
			// 배열을 벗어났을 경우 종료
			if(0 > l || r >= switchs.length) {
				break;
			}
			
			// 오른쪽과 왼쪽 값이 다를 경우 종료
			if(switchs[l] != switchs[r]) {
				break;
			}
		}
		
		// 오른쪽과 왼쪽값이 다르거나 벗어나기 직전의 영역
		for(int i=l+1; i<r; i++) {
			// 해당 영역에 toggle적용
			switchs[i] = switchToggle(switchs[i]);
		}
	}
	
	// toggle적용 함수
	public static int switchToggle(int val) {
		if(val == 1) {
			return 0;
		}else {
			return 1;
		}
	}
}
