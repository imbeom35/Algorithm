import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map, visited;
    static Map<Integer, Integer> countMap;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        countMap = new HashMap<>();
        visited = new int[N][M];

        for(int y=0; y<N; y++) {
            String str = br.readLine();
            for(int x=0; x<M; x++) {
                map[y][x] = str.charAt(x) - '0';
            }
        }

        bfs();

        for(int y=0; y<N; y++) {
            for(int x=0; x<M; x++) {
                if(map[y][x] == 1) {
                    int cnt = 1;
                    Set<Integer> set = new HashSet<>();
                    for(int i=0; i<4; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];

                        if(isInArray(nx, ny) && map[ny][nx] == 0 && !set.contains(visited[ny][nx])) {
                            set.add(visited[ny][nx]);
                            cnt += countMap.get(visited[ny][nx]);
                        }
                    }
                    sb.append(cnt%10);
                } else {
                    sb.append(0);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    public static void bfs() {
        int groupId = 1;

        for(int y=0; y<N; y++) {
            for(int x=0; x<M; x++) {
                if(visited[y][x] != 0 || map[y][x] != 0) continue;
                int cnt = 1;
                visited[y][x] = groupId;
                Queue<Point> queue = new LinkedList<>();
                queue.offer(new Point(x, y));
                while(!queue.isEmpty()) {
                    Point curr = queue.poll();
                    for(int i=0; i<4; i++) {
                        int nx = curr.x + dx[i];
                        int ny = curr.y + dy[i];

                        if(isInArray(nx, ny) && visited[ny][nx] == 0 && map[ny][nx] == 0) {
                            queue.offer(new Point(nx, ny));
                            visited[ny][nx] = groupId;
                            cnt++;
                        }
                    }
                }

                countMap.put(groupId, cnt);
                groupId++;
            }
        }
    }

    public static boolean isInArray(int x, int y) {
        if(0 <= x && x < M && 0 <= y && y< N) return true;
        else return false;
    }
}
