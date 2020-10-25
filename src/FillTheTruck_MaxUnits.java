public class FillTheTruck_MaxUnits {

    public static long getMaxUnits(List<Long> boxes, List<Long> unitsPerBox, long truckSize) {
        // key: size, value: idx
        // sort by units per box
        // get number of boxes from map based on size
        Map<Long, Long> map = new HashMap<>();

        for (int i = 0; i < boxes.size(); i++) {
            Long boxIdx = boxes.get(i);
            Long size = unitsPerBox.get(i);

            map.put(size, boxIdx);
        }

        Collections.sort(unitsPerBox, Collections.reverseOrder());

        long res = 0;

        for (Long boxSize : unitsPerBox) {
            // greedy fill the truck with the highest value boxes
            Long boxCount = map.get(boxSize);

            if (truckSize < 0) {
                return res;
            }

            // if we have exact space in the truck for all packages of this size
            if (truckSize == boxCount) {
                res += (boxCount * boxSize);
                return res;
            }

            // if space is still left, add to result, and decrement truck size by expected amount
            if (truckSize > boxCount) {
                res += (boxCount * boxSize);
                truckSize -= boxCount;
            } else {
                res += (truckSize * boxSize);
                return res;
            }

        }

        return res;
    }
}


