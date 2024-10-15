import java.util.*;

class Solution {
    public static List<Integer> answer = new ArrayList<>();
    public static boolean[] visited;
    public static boolean[] visited_state;
    
    public int solution(int[] info, int[][] edges) {
        int n = info.length;
        visited = new boolean[n];
        visited_state = new boolean[1 << n];
        
        visited[0] = true;
        dfs(info, edges, 1, 0, 1);
        return Collections.max(answer);
    }
    
    public void dfs(int[] info, int[][] edges, int sheep, int wolf, int state) {
        if(sheep > wolf) {
            answer.add(sheep);
        } else {
            return;
        }
        
        if(visited_state[state]) {
            return;
        }
        visited_state[state] = true;
        
        for(int[] edge : edges) {
            int p = edge[0];
            int c = edge[1];
            
            if(visited[p] && !visited[c]) {
                visited[c] = true;
                if(info[c] == 0) {
                    dfs(info, edges, sheep + 1, wolf, state | 1 << c);
                } else {
                    dfs(info, edges, sheep, wolf + 1, state | 1 << c);
                }
                visited[c] = false;
            }
        }
    }
}