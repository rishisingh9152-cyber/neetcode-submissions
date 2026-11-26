class Solution {
    public int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1; // s.charAt(0) != '0' is already checked

        for (int i = 2; i <= n; i++) {
            char oneChar = s.charAt(i - 1);
            if (oneChar != '0') {
                dp[i] += dp[i - 1];
            }

            int twoDigit = (s.charAt(i - 2) - '0') * 10 + (oneChar - '0');
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
    }

