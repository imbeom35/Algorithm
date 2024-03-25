import java.io.*;
import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        int size = sequence.length;
        int aSet = 1, bSet = -1;
        long aSum = sequence[0];
        long bSum = sequence[0] * -1;
        long aMax = Long.MIN_VALUE, bMax = Long.MIN_VALUE, aMin = 0, bMin = 0;
        
        for(int i=1; i<=size; i++) {
            aSet *= -1;
            bSet *= -1;
            
            //max값은 i길이의 수열에서 i길이 전에 만난 가장 낮은 값을 가지는 수열을 뺀 값이다.
            aMax = Math.max(aMax, aSum - aMin);
            bMax = Math.max(bMax, bSum - bMin);
            
            aMin = Math.min(aMin, aSum);
            bMin = Math.min(bMin, bSum);
            
            if(i == size) break;
            
            aSum += sequence[i] * aSet;
            bSum += sequence[i] * bSet;
        }
        
        return Math.max(aMax, bMax);
    }
}