import java.io.*;
import java.util.*;

public class Main {
	static int[][] score;
	static int[] home = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
	static int[] away = {1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<4; t++) {
			score = new int[6][3];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int y=0; y<6; y++) {
				for(int x=0; x<3; x++) {
					score[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append(play(0)?1:0).append(" ");
		}
		
		System.out.println(sb);
		
		br.close();
	}
	
	static boolean play(int game) {
		if(game == 15) {
			for(int y=0; y<6; y++) {
				for(int x=0; x<3; x++) {
					if(score[y][x] != 0) {
						return false;
					}
				}
			}
			
			return true;
		}
		
		// 홈팀이 이기는 경우
		if(score[home[game]][0] > 0 && score[away[game]][2] > 0) {
			score[home[game]][0]--;
			score[away[game]][2]--;
			if(play(game+1)) return true;
			score[home[game]][0]++;
			score[away[game]][2]++;
		}
		
		// 어웨이 팀이 이기는 경우
		if(score[home[game]][2] > 0 && score[away[game]][0] > 0) {
			score[home[game]][2]--;
			score[away[game]][0]--;
			if(play(game+1)) return true;
			score[home[game]][2]++;
			score[away[game]][0]++;
		}
		
		// 비기는 경우
		if(score[home[game]][1] > 0 && score[away[game]][1] > 0) {
			score[home[game]][1]--;
			score[away[game]][1]--;
			if(play(game+1)) return true;
			score[home[game]][1]++;
			score[away[game]][1]++;
		}
		
		return false;
	}
}
