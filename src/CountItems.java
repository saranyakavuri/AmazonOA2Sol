public class CountItems {


    static int count = 0;
    public static int countTeams(int num, int[] skills, int minAssociates, int minLevel, int maxLevel) {
        _countTeams(skills, minAssociates, minLevel, maxLevel, 0);
        return count;
    }

    private static void _countTeams(int[] skills, int minAssociates, int minLevel, int maxLevel, int currIndex) {
        if (minAssociates <= 0) {
            count++;
        }
        if (currIndex == skills.length) {
            return;
        }

        for (int i = currIndex; i < skills.length; i++) {
            if(skills[i] >= minLevel && skills[i] <= maxLevel) {
                _countTeams(skills, minAssociates - 1, minLevel, maxLevel, i+1);
            }
        }

    }


}
