public class UtilizationChecks {

    private static final int LIMIT = 2 * 100_000_000;

    public static int finalInstances(int instances, List<Integer> averageUtil) {
        for (int i = 0; i < averageUtil.size(); i++) {
            int util = averageUtil.get(i);
            if (util < 25) {
                if (instances > 1) {
                    instances = instances / 2 + ((instances % 2 == 0) ? 0 : 1);
                    i += 10;
                }
            } else if (util > 60) {
                int newInstances = 2 * instances;
                if (newInstances <= LIMIT) {
                    instances = newInstances;
                    i += 10;
                }
            }
        }
        return instances;
    }

}
