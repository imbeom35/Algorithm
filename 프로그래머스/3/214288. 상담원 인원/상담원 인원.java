import java.util.*;

class Solution {
    public int solution(int k, int n, int[][] reqs) {
        int answer = 0;
        //time[i][j]는 i번째 유형에 j명이 담당할 경우 기다리는 시간
        int[][] time = new int[k][n-k+2];
        for(int i=0; i<k; i++) {
            for(int j=1; j<n-k+2; j++) {
                //j-1명이 담당했을 때 기다리는 시간이 존재하는 경우
                //if(j == 1 || time[i][j-1] > 0) {
                    time[i][j] = calTime(reqs, i, j);
                //}
            }
        }
        
        answer = calTotalMinTime(time, k, n);
        return answer;
    }
    
    public int calTime(int[][] reqs, int k, int cnt) {
        int time = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<cnt; i++) pq.add(0);
        for(int i=0; i<reqs.length; i++) {
            if(reqs[i][2] == k+1) {
                int mentor = pq.poll();
                if(mentor > reqs[i][0]) {
                    time += mentor - reqs[i][0];
                    pq.add(mentor + reqs[i][1]);
                } else {
                    pq.add(reqs[i][0] + reqs[i][1]);
                }
            }
        }
        
        return time;
    }
    
    public int calTotalMinTime(int[][] time, int k, int n) {
        int[] mentorCnt = new int[k]; //mentorCnt[i]는 i번째 유형의 멘토의 수
        Arrays.fill(mentorCnt, 1);
        
        //인원을 늘렸을 때 가장 효율이 높은 순서대로 증가시킨다.
        int remain = n-k;
        while(remain-- > 0) {
            int max = 0;
            int idx = 0;
            for(int i=0; i<k; i++) {
                if(mentorCnt[i] == n - k + 1) continue;
                int diff = time[i][mentorCnt[i]] - time[i][mentorCnt[i] + 1];
                if(max < diff) {
                    max = diff;
                    idx = i;
                }
            }
            mentorCnt[idx]++;
        }
        
        // 모든 유형의 기다리는 시간의 합을 구한다.
        int result = 0;
        for(int i=0; i<k; i++) {
            result += time[i][mentorCnt[i]];
        }
        
        return result;
    }
}