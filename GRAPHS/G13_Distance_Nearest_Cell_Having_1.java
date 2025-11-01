import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class G13_Distance_Nearest_Cell_Having_1 {

    int dx[] = {1,-1,0,0};
    int dy[] = {0,0,1,-1};

    class Node {
        int x;
        int y;
        int dist;

        Node (int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // creating ans array list
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < m ; i++) {
            ArrayList<Integer> row = new ArrayList<>(Collections.nCopies(n, Integer.MAX_VALUE));
            ans.add(row);
        }

        // Reverse Thinking: Instead of finding nearest 1 from 0's, we will perform bfs from all 1's to 0's and update the minimum dist
        Queue<Node> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    q.add(new Node(i, j, 0));
                    vis[i][j] = true;
                    ans.get(i).set(j, 0);
                }
            }
        }

        while(!q.isEmpty()) {
            Node top = q.poll();

            for(int i = 0; i < 4; i++) {
                int x = top.x + dx[i], y = top.y + dy[i], dist = top.dist;
                if(x < 0 || y < 0 || x >= m || y >= n || vis[x][y]) continue;

                if(grid[x][y] == 0) {
                    ans.get(x).set(y, Math.min(ans.get(x).get(y), dist+1));
                    q.add(new Node(x, y, dist+1));
                    vis[x][y] = true;
                }
            }
        }

        return ans;
    }
}
