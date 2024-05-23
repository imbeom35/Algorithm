import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String input = br.readLine();

            if(input.equals("end")) break;

            int[][] map = new int[3][3];
            boolean hasEmpty = false;
            int successX = 0;
            int successO = 0;
            int xCnt = 0;
            int oCnt = 0;

            for(int i=0; i<9; i++) {
                char c = input.charAt(i);
                switch(c) {
                    case '.':
                        map[i/3][i%3] = 0;
                        hasEmpty = true;
                        break;
                    case 'O':
                        map[i/3][i%3] = 1;
                        oCnt++;
                        break;
                    case 'X':
                        map[i/3][i%3] = -1;
                        xCnt++;
                        break;
                }
            }

            int[][][] search = {
                    {{0, 0}, {0, 1}, {0, 2}},
                    {{1, 0}, {1, 1}, {1, 2}},
                    {{2, 0}, {2, 1}, {2, 2}},
                    {{0, 0}, {1, 0}, {2, 0}},
                    {{0, 1}, {1, 1}, {2, 1}},
                    {{0, 2}, {1, 2}, {2, 2}},
                    {{0, 0}, {1, 1}, {2, 2}},
                    {{0, 2}, {1, 1}, {2, 0}}
            };

            for(int i=0; i<search.length; i++) {
                int sum = 0;
                for(int j=0; j<3; j++) {
                    sum += map[search[i][j][0]][search[i][j][1]];
                }

                if(sum == 3) successO++;
                if(sum == -3) successX++;
            }

            if (successX > 2 || successO > 1) { // 각각 O는 1개, X는 2개를 초과한 3연속을 만들 수 없다
                sb.append("invalid").append("\n");
            } else if (successX == 1 && successO == 1) { // 동시에 이길 수 없다
                sb.append("invalid").append("\n");
            } else if (oCnt > 4 || xCnt > 5) { // 각각 O는 4개, X는 5개를 초과하여 놓을 수 없다
                sb.append("invalid").append("\n");
            } else if (oCnt > xCnt) { // X보다 O가 많을 수 없다
                sb.append("invalid").append("\n");
            } else if (Math.abs(oCnt - xCnt) > 1) { // X와 O의 개수 차이가 1을 초과할 수 없다
                sb.append("invalid").append("\n");
            } else if (successX + successO == 0 && hasEmpty) { // 승리하지 않았는데 빈 칸이 존재할 수 없다
                sb.append("invalid").append("\n");
            } else if (successO > 0 && xCnt > oCnt) { // O가 승리했는데 X로 끝날 수 없다
                sb.append("invalid").append("\n");
            } else if (successX > 0 && xCnt == oCnt) { // X가 승리했는데 O로 끝날 수 없다
                sb.append("invalid").append("\n");
            } else {
                sb.append("valid").append("\n");
            }
        }

        System.out.println(sb);

        br.close();
    }
}
