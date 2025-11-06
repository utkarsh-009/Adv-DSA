import java.util.Arrays;

public class G18_Bipartite_Graph_DFS {
    public boolean fillColorDfs(int[][] graph, int src, int[] nodeColor, int color) {
        if(nodeColor[src] != -1) return true;
        nodeColor[src] = color;
        boolean isGraphBipartite = true;
        for(int i = 0; i < graph[src].length; i++) {
            int next = graph[src][i];
            if(nodeColor[next] == color) return false;
            if(nodeColor[next] == -1 && !fillColorDfs(graph, next, nodeColor, color^1)) return false;
        }
        return isGraphBipartite;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int[] nodeColor = new int[n];
        Arrays.fill(nodeColor, -1);

        for(int i = 0; i < n; i++) {
            if(nodeColor[i] == -1 && !fillColorDfs(graph, i, nodeColor, 0)) {
                return false;
            }
        }
        return true;
    }
}
