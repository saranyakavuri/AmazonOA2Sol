public class CONNECTROPES {



    public class Main {
        private void printArray(int[] A){
            System.out.print("[ ");
            for(int i: A) System.out.print(i + " ");
            System.out.println("] ");
        }
        public int connectRopes(int[] ropes){
            int len = ropes.length;
            if(len == 0) return 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int rope: ropes) pq.add(rope);
            int costs = 0;
            while(pq.size() > 1){
                int rope1 = pq.poll();
                int rope2 = pq.poll();
                int ropeNew = rope1 + rope2;
                costs += ropeNew;
                pq.add(ropeNew);
            }
            return costs;
        }
        public static void main(String[] args) {
            Main main = new Main();
            int[][] testcases = {{8, 4, 6, 12},
                    {20, 4, 8, 2},
                    {1, 2, 5, 10, 35, 89},
                    {2, 2, 3, 3}};
            for(int i = 0; i < testcases.length; ++i){
                main.printArray(testcases[i]);
                System.out.println(main.connectRopes(testcases[i]));
            }
        }
    }

}
