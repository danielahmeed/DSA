class Solution {
    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
         Queue<int[]> queue = new LinkedList<>();
         int fresh = 0 ;
         //count fresh oranges and rotten ones to queue
         for (int r = 0 ; r< rows; r++) {
            for (int c= 0 ; c< cols ; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[] {r,c}); 
                } 
                if (grid[r][c] == 1) {
                    fresh++;
                }
            }
         }
         if (fresh == 0) {
            return 0;
         }

         int minutes = 0 ;
         int [][]  directions= {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
         };
         while (!queue.isEmpty() && fresh > 0 ) {
            int size = queue.size();
            for (int i = 0 ; i <size ; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];
                for (int[] dir :  directions) {
                    int nr = row + dir[0];
                    int nc = col + dir[1];
                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || grid[nr][nc] !=1) {
                        continue;
                    }
                    grid[nr][nc] = 2 ;
                    fresh--;
                    queue.offer(new int[] {nr,nc});

                }
            }
            minutes++;
         }
      /*  int rotten 
        int fresh 
        int empty
        in every 1 minute  
          0 -> 1 ;
          in 4 direction
           left , right , upper and lower  direction;

                  m==grid.length 
                n== grid[i],.length
                1<= m , n<= 10;
                grid[i][j] is 0,1 and 2

        return minutes;
*/
return fresh == 0  ? minutes : -1 ;
    }
}