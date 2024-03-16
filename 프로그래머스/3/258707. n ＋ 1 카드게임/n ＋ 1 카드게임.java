import java.util.*;

class Solution {
    Set<Integer> hands, draw;
    
    public int solution(int coin, int[] cards) {
        int answer = 0;
        int n = cards.length;
        hands = new HashSet();
        draw = new HashSet();
        
        int idx = n/3;
        for(int i=0; i<idx; i++) {
            hands.add(cards[i]);
        }
        
        while(true) {
            answer++;
            
            // draw가 불가능 한 경우
            if(idx >= n) {
                break;
            }
            
            draw.add(cards[idx]);
            draw.add(cards[idx+1]);
            idx += 2;
            boolean flag = false;
            
            // hands만으로 n+1을 만드는 경우
            if(!flag) {
                for(int x : hands) {
                    if(hands.contains(n + 1 - x)) {
                        hands.remove(x);
                        hands.remove(n + 1 - x);
                        flag = true;
                        break;
                    }
                }
            }
            
            // hands와 draw를 사용하여 n+1을 만드는 경우
            if(!flag && coin > 0) {
                for(int x : hands) {
                    if(draw.contains(n + 1 - x)) {
                        hands.remove(x);
                        draw.remove(n + 1 - x);
                        coin--;
                        flag = true;
                        break;
                    }
                }
            }
            
            // draw만으로 n+1을 만드는 경우
            if(!flag && coin > 1) {
                for(int x : draw) {
                    if(draw.contains(n + 1 - x)) {
                        draw.remove(x);
                        draw.remove(n + 1 - x);
                        coin -= 2;
                        flag = true;
                        break;
                    }
                }
            }
            
            if(!flag) {
                break;
            }
        }
        
        return answer;
    }
}