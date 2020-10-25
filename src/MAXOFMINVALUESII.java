public class MAXOFMINVALUESII



        public static void main(String[] args) {
            int[][] grid1 = {{1, 7}, {5, 3}};
            int[][] grid2 = {{1,2,3}, {7,8,9}, {4,5,6}};
            int[][] grid3 = {{7,5,3}, {2,0,9}, {4,5,9}};
            System.out.println(getMinMax(grid1));
            System.out.println(getMinMax(grid2));
            System.out.println(getMinMax(grid3));
        }

        private static int getMinMax(int[][] grid) {
            int[][] dp = new int[grid.length][grid[0].length];

            for(int i = 0; i < dp.length; i++) {
                for(int j = 0; j < dp[i].length; j++) {
                    if(i == 0 && j == 0) {
                        dp[i][j] = grid[i][j];
                        continue;
                    }
                    int top =  i > 0 ? dp[i - 1][j] : Integer.MIN_VALUE;
                    int left = j > 0 ? dp[i][j - 1] : Integer.MIN_VALUE;
                    dp[i][j] = Math.max(Math.min(top, grid[i][j]), Math.min(left, grid[i][j]));
                }
            }
            return dp[dp.length - 1][dp[0].length - 1];
        }

}
