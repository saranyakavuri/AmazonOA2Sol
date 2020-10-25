public class LongestStingMadeOfVowels {

    public class LongestVowels {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));

        public int solution(String s){
            int len = s.length();
            int left = 0;
            int right = len -1;
            int ans = 0;
            while (left <= right) {

                if (vowels.contains(s.charAt(left))) {
                    ans++;
                    left++;
                }

                if (vowels.contains(s.charAt(right))) {
                    ans++;
                    right--;
                }

                if (!vowels.contains(s.charAt(left)) && !vowels.contains(s.charAt(right))) {
                    ans += longestVowels(s, left, right);
                    return ans;
                }
            }
            return ans;
        }

        private int longestVowels(String s, int left, int right){
            int ans  = 0;
            int count = 0;
            for (int i = left; i <=right; i++){
                if (vowels.contains(s.charAt(i))){
                    count++;
                }else{
                    ans = Math.max(count, ans);
                    count = 0;
                }
            }
            return ans;
        }
    }



}
