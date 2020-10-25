public class NearestCity {

    public static void main(String[] args) {
        String[] cities = { "c1", "c2", "c3" };
        int[] xs = { 3, 2, 1 };
        int[] ys = { 3, 2, 3 };
        String[] queries = { "c1", "c2", "c3" };
        System.out.println(Arrays.toString(solve(cities, xs, ys, queries)));

    }

    private static String[] solve(String[] cities, int[] xs, int[] ys, String[] queries) {
        String[] res = new String[queries.length];
        Map<Integer, TreeMap<Integer, String>> xMap = new HashMap<>();
        Map<Integer, TreeMap<Integer, String>> yMap = new HashMap<>();
        Map<String, int[]> nodeMap = new HashMap<>();
        for(int i=0;i<cities.length;i++) {
            nodeMap.put(cities[i], new int[] {xs[i], ys[i]});
            xMap.putIfAbsent(xs[i], new TreeMap<>());
            yMap.putIfAbsent(ys[i], new TreeMap<>());
            xMap.get(xs[i]).put(ys[i], cities[i]);
            yMap.get(ys[i]).put(xs[i], cities[i]);
        }
        for(int i=0;i<queries.length;i++) {
            int[] node = nodeMap.get(queries[i]);
            TreeMap<Integer, String> ym = xMap.getOrDefault(node[0], new TreeMap<>());
            TreeMap<Integer, String> xm = yMap.getOrDefault(node[1], new TreeMap<>());
            Integer yl = ym.lowerKey(node[1]), yh = ym.higherKey(node[1]);
            Integer xl = xm.lowerKey(node[0]), xh = xm.higherKey(node[0]);
            int dist = Integer.MAX_VALUE;
            if(yl != null && Math.abs(yl - node[1]) <= dist) {
                dist = Math.abs(yl - node[1]);
                res[i] = res[i] == null ? ym.get(yl) : res[i].compareTo(ym.get(yl)) > 0 ? ym.get(yl) : res[i];
            }
            if(yh != null && Math.abs(yh - node[1]) <= dist) {
                dist = Math.abs(yh - node[1]);
                res[i] = res[i] == null ? ym.get(yh) : res[i].compareTo(ym.get(yh)) > 0 ? ym.get(yh) : res[i];
            }
            if(xl != null && Math.abs(xl - node[0]) <= dist) {
                dist = Math.abs(xl - node[0]);
                res[i] = res[i] == null ? xm.get(xl) : res[i].compareTo(xm.get(xl)) > 0 ? xm.get(xl) : res[i];
            }
            if(xh != null && Math.abs(xh - node[1]) <= dist) {
                dist = Math.abs(xh - node[1]);
                res[i] = res[i] == null ? xm.get(xh) : res[i].compareTo(xm.get(xh)) > 0 ? xm.get(xh) : res[i];
            }
            if(res[i] == null)
                res[i] = "None";
        }
        return res;
    }


}
