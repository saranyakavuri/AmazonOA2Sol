public class CountLRUCacheMiss {

    public static int lruCacheMisses(int num, List<Integer> pages, int maxCacheSize) {
        if(num==0) return 0;
        int misses=0;

        //CREATE A DOUBLE-ENDED QUEUE OF SIZE MAXCACHE SIZE
        Deque<Integer> dq= new LinkedList<>();
        for(int page: pages) {
            if(dq.isEmpty()) {
                misses++;
                dq.add(page);
            } else {
                //DQ CONTAINS THE PAGE
                if(dq.contains(page)) {
                    dq.remove(page);
                    dq.addFirst(page);
                } else { //DQ DOESN'T CONTAIN THE PAGE
                    misses++;
                    if(dq.size()==maxCacheSize) dq.removeLast();
                    dq.addFirst(page);
                }
            }
        }
        return misses;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(lruCacheMisses(6, Arrays.asList(1,2,1,3,1,2), 2));
    }
}


}
