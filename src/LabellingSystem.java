public class LabellingSystem
{
    public static String newLabel(String originalLabel, int limit) {
        int n = originalLabel.length();
        int[] charset = new int[128];
        for (int i = 0; i < n; i++) {
            charset[originalLabel.charAt(i)]++;
        }
        StringBuilder newLabel = new StringBuilder(n);
        for (int i = charset.length - 1; i >= 0; i--) {
            int count = 0;
            while (charset[i] > 0) {
                newLabel.append((char) i);
                charset[i]--;
                count++;
                if (charset[i] > 0 && count == limit) {
                    Character next = nextAvailableChar(charset, i);
                    if (next == null) return newLabel.toString();
                    newLabel.append(next);
                    count = 0;
                }
            }
        }
        return newLabel.toString();
    }

    private static Character nextAvailableChar(int[] charset, int start) {
        for (int i = start - 1; i >= 0; i--) {
            if (charset[i] > 0) {
                charset[i]--;
                return (char) i;
            }
        }
        return null;
    }











}
