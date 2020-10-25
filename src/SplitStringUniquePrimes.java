public class SplitStringUniquePrimes {


    public static void main(String[] args) {
        int n = 11373;
        System.out.println(solve(n));
    }

    private static int solve(int n) {
        int mod = (int)1e9 + 7;
        boolean[] arr = new boolean[(int)1e6 + 1];
        Arrays.fill(arr, true);
        for(int i=2;i*i<=(int)1e6;i++) {
            if(arr[i]) {
                for(int j=i;j*i<=(int)1e6;j++) {
                    arr[i*j] = false;
                }
            }
        }
        arr[1] = false;
        arr[0] = false;
        String s = String.valueOf(n);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for(int i=1;i<=s.length();i++) {
            for(int j=Math.max(0, i-6);j<i;j++) {
                if(arr[Integer.parseInt(s.substring(j, i))]) {
                    dp[i] = (dp[i] + dp[j]) % mod;
                }
            }
        }
        return dp[s.length()];
    }

}