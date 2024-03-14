class Solution {
    static int max = Integer.MIN_VALUE;
    static int N;
    static List<Integer> sumListA;
    static List<Integer> sumListB;
    static List<Integer> choice = new ArrayList<>();
    static int[] answer;
    static int[][] dices;
    
    public int[] solution(int[][] dice) {
        dices = dice;
        N = dice.length;
        answer = new int[N / 2];
        coiceDice(0, 0);
        return answer;
    }
    
    public static void makeSumList(int depth, int[][] dice, int sum, List<Integer> sumList) {
        if(depth == N/2) {
            sumList.add(sum);
            return;
        }
        for(int i=0; i<6; i++) {
            int newSum = sum + dice[depth][i];
            makeArr(depth + 1, dice, newSum, arr);
        }
    }
    
    public static void makeSumListAB() {
        sumListA = new ArrayList<>();
        sumListB = new ArrayList<>();
        
        int[][] diceA = new int[N / 2][6];
        int[][] diceB = new int[N / 2][6];
        int a = 0, b = 0;
        for(int i=0; i<N; i++) {
            if(choice.contains(i)) {
                diceA[a] = dices[i];
                a++;
            } else {
                diceB[b] = dices[i];
                b++;
            }
        }
        
        makeSumList(0, diceA, 0, sumListA);
        makeSumList(0, diceB, 0, sumListB);
    }
    
    public static int calculateWinningPercent() {
        int count = 0;
        
        makeSumListAB();
        
        Collections.sort(arrB);
        
        // 이분 탐색
        for(int i=0; i<arrA.size(); i++) {
            int number = arrA.get(i);
            int left = 0;
            int right = arrB.size() - 1;
            int index = Integer.MIN_VALUE;
            while(left <= right) {
                int middle = (left + right) / 2;
                
                if(arrB.get(middle) < number) {
                    left = middle + 1;
                    index = Math.max(index, middle);
                } else {
                    right = middle - 1;
                }
            }
            if(index != Integer.MIN_VALUE) {
                count += index + 1;
            }
        }
        return count;
    }
    
    public void choiceDice(int depth, int s) {
        if(depth == N / 2) {
            int winning = calculateWinningPercent();
            if(max < winning) {
                max = winning;
                for(int i=0; i<choice.size(); i++) {
                    answer[i] = choice.get(i) + 1;
                }
            }
            return;
        }
        for(int i=s; i<N; i++) {
            choice.add(i);
            choiceDice(depth + 1, i + 1);
            choice.remove(choice.size() - 1);
        }
    }
}