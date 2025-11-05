public class G14_Surrounded_Regions {

    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};

    public void fillRegionDfs(char[][] board, int i, int j, int m, int n) {
        if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O') return ;
        board[i][j] = 'X';
        for(int k = 0; k < 4; k++) {
            int x = dx[k] + i, y = dy[k] + j;
            fillRegionDfs(board, x, y, m, n);
        }
    }

    public void nonRegionDfs(char[][] board, int i, int j, int m, int n) {
        if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O') return ;
        board[i][j] = '#';
        for(int k = 0; k < 4; k++) {
            int x = dx[k] + i, y = dy[k] + j;
            nonRegionDfs(board, x, y, m, n);
        }
    }

    // NOTE: We can reduce this 1 for-loop by using n*n visited matrix. Marking them visited in first two for loops only.
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++) {
            // first col
            if(board[i][0] == 'O') nonRegionDfs(board, i, 0, m, n);
            // last col
            if(board[i][n-1] == 'O') nonRegionDfs(board, i, n-1, m, n);
        }

        for(int i = 0; i < n; i++) {
            // first row
            if(board[0][i] == 'O') nonRegionDfs(board, 0, i, m, n);
            // last row
            if(board[m-1][i] == 'O') nonRegionDfs(board, m-1, i, m, n);
        }

        for(int i = 1; i < m-1; i++) {
            for(int j = 1; j < n-1; j++) {
                if(board[i][j] == 'O') fillRegionDfs(board, i, j, m, n);
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }
}
