import java.util.*;

class Solution {
    int X, Y;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    boolean[][] visitedRed, visitedBlue;
    int min = 10000;
    
    class Point {
        int x, y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] maze) {
        int answer = 0;
        Y = maze.length;
        X = maze[0].length;
        visitedRed = new boolean[Y][X];
        visitedBlue = new boolean[Y][X];
        Point red = null;
        Point blue = null;
        
        for(int x=0; x<X; x++) {
            for(int y=0; y<Y; y++) {
                if(maze[y][x] == 1) {
                    red = new Point(x, y);
                }
                if(maze[y][x] == 2) {
                    blue = new Point(x, y);
                }
            }
        }
        
        visitedRed[red.y][red.x] = true;
        visitedBlue[blue.y][blue.x] = true;
        DFS(maze, red, blue, 0);
        answer = (min == 10000) ? 0 : min;
        
        return answer;
    }
    
    public boolean isAvailable(int[][] maze, boolean[][] visited, Point p) {
        if(0 <= p.x && p.x < X && 0 <= p.y && p.y < Y && maze[p.y][p.x] != 5 && !visited[p.y][p.x]) return true;
        return false;
    }
    
    public void DFS(int[][] maze, Point red, Point blue, int cnt) {
        boolean isGoalRed = ( maze[red.y][red.x] == 3 ) ? true : false;
        boolean isGoalBlue = ( maze[blue.y][blue.x] == 4 ) ? true : false;
        if(isGoalRed && isGoalBlue) {
            min = Math.min(min, cnt);
            return;
        }

        for(int i=0; i<4; i++) {
            Point newRed = null;
            if(isGoalRed) {
                newRed = red;
            } else {
                newRed = new Point(red.x + dx[i], red.y + dy[i]);
                if(!isAvailable(maze, visitedRed, newRed)) continue;
            }
            
            for(int j=0; j<4; j++) {
                Point newBlue = null;
                if(isGoalBlue) {
                    newBlue = blue;
                } else {
                    newBlue = new Point(blue.x + dx[j], blue.y + dy[j]);
                    if(!isAvailable(maze, visitedBlue, newBlue)) continue;
                }
                
                if(newRed.x == newBlue.x && newRed.y == newBlue.y) continue;
                if(newRed.x == blue.x && newRed.y == blue.y && newBlue.x == red.x && newBlue.y == red.y) continue;
                visitedRed[newRed.y][newRed.x] = true;
                visitedBlue[newBlue.y][newBlue.x] = true;
                DFS(maze, newRed, newBlue, cnt + 1);
                visitedRed[newRed.y][newRed.x] = false;
                visitedBlue[newBlue.y][newBlue.x] = false;
            }
        }
    }
}