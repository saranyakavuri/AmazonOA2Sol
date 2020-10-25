public class CutoffRanks {

    public static int cutOffRank(int cutOffRank, int num, int[] scores) {
        int rank = 1;
        int position = 1;
        Arrays.sort(scores);
        for (int i = num - 1; i >= 0; i--) {
            if (i == num - 1 || scores[i] != scores[i + 1]) {
                rank = position;
                if (rank > cutOffRank) return position - 1;
            }
            position++;
        }
        return num;
    }
}
