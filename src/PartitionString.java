public class PartitionString {
    List<Integer> out = new ArrayList<>();
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i=0; i<S.length(); i++) {
        map.put(S.charAt(i), i);
    }
    Integer end=0, begin=0;
    System.out.print(map);
    for (int i=0; i<S.length(); i++) {
        Integer index = map.get(S.charAt(i));
        if (index.intValue() > end.intValue()) {
            end = index;
        }
        if(i == end.intValue()) {
            out.add(end.intValue() - begin.intValue() + 1);
            begin = i + 1;
        }
    }
    return out;

}
