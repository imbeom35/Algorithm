import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int Y = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());
            char[][] space = new char[Y+2][X+2];
            for(int y=0; y<Y+2; y++) {
                String str = "";
                if(y !=0 && y != Y+1) str = br.readLine();
                for(int x=0; x<X+2; x++) {
                    if(y == 0 || y == Y+1 || x == 0 || x == X+1) {
                        space[y][x] = '.';
                    } else {
                        space[y][x] = str.charAt(x-1);
                    }
                }
            }

            String str = br.readLine();
            Set<Integer> keys = new HashSet<>();
            for(int i=0; i<str.length(); i++) {
                int key = str.charAt(i);
                keys.add(key);
            }

            int ans = BFS(space, keys);
            sb.append(ans).append("\n");
        }

        System.out.println(sb.toString());

        br.close();
    }

    public static boolean isAvailable(char[][] space, int x, int y) {
        return 0 <= y && y < space.length && 0 <= x && x < space[0].length && space[y][x] != '*';
    }

    public static int BFS(char[][] space, Set<Integer> keys) {
        int ans = 0;
        boolean[][] visited = new boolean[space.length][space[0].length];
        ArrayList<Point> doors = new ArrayList<>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        visited[0][0] = true;
        while(!queue.isEmpty()) {
            Point curr = queue.poll();
            if(space[curr.y][curr.x] == '$') ans++;
            for(int i=0; i<4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                if(isAvailable(space, nx, ny)) {
                    // visited
                    if(visited[ny][nx]) continue;
                    visited[ny][nx] = true;
                    // key
                    if(97 <= space[ny][nx] && space[ny][nx] <= 122) {
                        keys.add((int)space[ny][nx]);
                        Iterator<Point> iterator = doors.iterator();
                        while(iterator.hasNext()) {
                            Point door = iterator.next();
                            if(keys.contains(space[door.y][door.x] + 32)) {
                                queue.add(new Point(door.x, door.y));
                                iterator.remove();
                            }
                        }
                    }
                    // door
                    if(65 <= space[ny][nx] && space[ny][nx] <= 90 && !keys.contains(space[ny][nx] + 32)) {
                        doors.add(new Point(nx, ny));
                        continue;
                    }
                    // move
                    queue.add(new Point(nx, ny));
                }
            }
        }

        return ans;
    }
}
