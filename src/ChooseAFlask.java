import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChooseAFlask {

    public static int chooseFlask(int numOrders, List<Integer> requirements,
                                  int flaskTypes, int totalMarks, List<PairInt> markingsList) {
        List<Integer>[] markings = groupMarkings(flaskTypes, markingsList);
        int minWaste = Integer.MAX_VALUE;
        int flask = -1;
        for (int type = 0; type < flaskTypes; type++) {
            int waste = getWaste(requirements, markings[type]);
            if (waste < minWaste) {
                minWaste = waste;
                flask = type;
            }
        }
        return flask;
    }

    private static List<Integer>[] groupMarkings(int flaskTypes, List<PairInt> markingsList) {
        List<Integer>[] markings = new List[flaskTypes];
        Arrays.setAll(markings, (i) -> new ArrayList<>());
        for (PairInt marking : markingsList) {
            markings[marking.first].add(marking.second);
        }
        return markings;
    }

    private static int getWaste(List<Integer> requirements, List<Integer> markings) {
        int waste = 0;
        int i = 0;
        for (Integer req : requirements) {
            while (i < markings.size() && markings.get(i) < req) i++;
            if (i >= markings.size()) return Integer.MAX_VALUE;
            waste += markings.get(i) - req;
        }
        return waste;
    }


}
