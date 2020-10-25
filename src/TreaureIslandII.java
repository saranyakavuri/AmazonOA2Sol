public class TreaureIslandII {

    public class Main {
        final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        public int shortestPath(char[][] islands){
            if(islands.length == 0 || islands[0].length == 0) return -1;
            int R = islands.length, C = islands[0].length;
            Queue<int[]> queue = new LinkedList<>();
            int steps = 1;
            // add all sources to queue and set 'visited'.
            for(int i = 0; i < R; ++i){
                for(int j = 0; j < C; ++j){
                    if(islands[i][j] == 'S'){
                        queue.add(new int[]{i, j}); islands[i][j] = 'D';
                    }
                }
            }
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; ++i){
                    int[] pos = queue.poll();
                    for(int[] dir: dirs){
                        int x = pos[0] + dir[0], y = pos[1] + dir[1];
                        if(x < 0 || x >= R || y < 0 || y >= C || islands[x][y] == 'D') continue;
                        if(islands[x][y] == 'E') return steps;
                        queue.add(new int[]{x, y});
                        islands[x][y] = 'D';
                    }
                }
                ++steps;
            }
            return -1;
        }
        public static void main(String[] args) {
            Main main = new Main();
            char[][] testcase = { {'S', 'O', 'O', 'S'},
                    {'D', 'O', 'D', 'D'},
                    {'O', 'O', 'O', 'E'},
                    {'E', 'D', 'D', 'O'}};
            System.out.println(main.shortestPath(testcase));
        }
    }

}
