import java.util.*;

class Solution {
    public int timeToValue(String time) {
        int[] timeArray = Arrays.stream(time.split(":"))
            .mapToInt(Integer::parseInt)
            .toArray();
        
        return timeArray[0] * 3600 + timeArray[1] * 60 + timeArray[2];
    }
    
    public String valueToTime(int value) {
        int hour = value / 3600;
        int minute = (value - 3600 * hour) / 60;
        int second = value - 3600 * hour - 60 * minute;
        
        return (hour < 10 ? "0" : "") + hour + ":" + 
            (minute < 10 ? "0" : "") + minute + ":" + 
            (second < 10 ? "0" : "") + second;
    }
    
    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = timeToValue(play_time);
        int advTime = timeToValue(adv_time);
        int[] times = new int[360000 + 1];
        for(String log : logs) {
            String[] slitLog = log.split("-");
            int start = timeToValue(slitLog[0]);
            int end = timeToValue(slitLog[1]);
            
            for (int i = start; i < end; i++) {
                times[i]++;
            }
        }
        
        int maxIdx = 0;
        long totalTime = 0;
        for(int i=0; i<advTime; i++) {
            totalTime += times[i];
        }
        long maxTotalTime = totalTime;
        
        // 투 포인터
        for(int i=advTime; i<playTime; i++) {
            totalTime += times[i] - times[i - advTime];
            if(totalTime > maxTotalTime) {
                maxTotalTime = totalTime;
                maxIdx = i - advTime + 1;
            }
        }
        
        return valueToTime(maxIdx);
    }
}