import java.util.LinkedList;
import java.util.Queue;

class G9_Flood_Fill_Algorithm {
    class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<Pair> q = new LinkedList<>();
        int oldClr = image[sr][sc];
        if(color == oldClr) return image;

        q.add(new Pair(sr, sc));
        image[sr][sc] = color;

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,-1,1};
        while(!q.isEmpty()) {
            Pair top = q.poll();
            int x = top.i, y = top.j;
            for(int k = 0; k < 4; k++) {
                int i = x+dx[k], j = y+dy[k];
                if(i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] != oldClr) continue;
                image[i][j] = color;
                q.add(new Pair(i,j));
            }
        }
        return image;
    }
}