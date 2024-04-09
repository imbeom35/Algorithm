import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int redX;
        int redY;
        int blueX;
        int blueY;
        int cnt;

        public Node(int redX, int redY, int blueX, int blueY, int cnt) {
            this.redX = redX;
            this.redY = redY;
            this.blueX = blueX;
            this.blueY = blueY;
            this.cnt = cnt;
        }
    }

    static char[][] map;
    static int N, M;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean success = false;
        int ans = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        int redX = 0, redY = 0, blueX = 0, blueY = 0;

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                char x = str.charAt(j);
                switch(x) {
                    case 'B':
                        blueX = j;
                        blueY = i;
                        map[i][j] = '.';
                        break;
                    case 'R':
                        redX = j;
                        redY = i;
                        map[i][j] = '.';
                        break;
                    default:
                        map[i][j] = x;
                        break;
                }
            }
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(redX, redY, blueX, blueY, 0));

        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            if(curr.cnt >= 10) continue;

            // 동, 서, 남, 북
            for(int d=0; d<4; d++) {
                boolean isInHoleR = false;
                boolean isInHoleB = false;
                int newRedX = curr.redX;
                int newRedY = curr.redY;
                int newBlueX = curr.blueX;
                int newBlueY = curr.blueY;

                // move red
                while(true) {
                    newRedX += dx[d];
                    newRedY += dy[d];
                    if(!(0 <= newRedX && newRedX < M && 0 <= newRedY && newRedY < N)) break;
                    if(map[newRedY][newRedX] == '#') break;
                    if(map[newRedY][newRedX] == 'O') {
                        isInHoleR = true;
                        break;
                    }
                }

                newRedX -= dx[d];
                newRedY -= dy[d];

                // move blue
                while(true) {
                    newBlueX += dx[d];
                    newBlueY += dy[d];
                    if(!(0 <= newBlueX && newBlueX < M && 0 <= newBlueY && newBlueY < N)) break;
                    if(map[newBlueY][newBlueX] == '#') break;
                    if(map[newBlueY][newBlueX] == 'O') {
                        isInHoleB = true;
                        break;
                    }
                }

                newBlueX -= dx[d];
                newBlueY -= dy[d];

                // 성공
                if(isInHoleR && !isInHoleB) {
                    ans = curr.cnt + 1;
                    success = true;
                    queue.clear();
                    break;
                }

                // 위치가 겹칠 경우
                if(newRedX == newBlueX && newRedY == newBlueY) {
                    if(d == 0) {
                        if(curr.redX < curr.blueX) {
                            newRedX--;
                        } else {
                            newBlueX--;
                        }
                    }
                    if(d == 1) {
                        if(curr.redX < curr.blueX) {
                            newBlueX++;
                        } else {
                            newRedX++;
                        }
                    }
                    if(d == 2) {
                        if(curr.redY < curr.blueY) {
                            newBlueY++;
                        } else {
                            newRedY++;
                        }
                    }
                    if(d == 3) {
                        if(curr.redY < curr.blueY) {
                            newRedY--;
                        } else {
                            newBlueY--;
                        }
                    }
                }

                // 위치가 변하지 않은 경우
                if(curr.redX == newRedX && curr.redY == newRedY && curr.blueX == newBlueX && curr.blueY == newBlueY) continue;
                
                if(!isInHoleB) {
                    queue.offer(new Node(newRedX, newRedY, newBlueX, newBlueY, curr.cnt + 1));
                }
            }
        }

        System.out.println(success?ans:-1);

        br.close();
    }
}
