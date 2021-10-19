import java.util.Arrays;
import java.util.stream.Stream;

public class LRS {
    // Longest Repeating Subsequence
    public static void main(String[] args) {
        String str = "AABEBCDD";
        int len = findLRSLen(str);
        System.out.println("Length of LRS is "+ len);
        String res = printLRS(str);
        System.out.println("LRS String is "+ res);
    }

    private static String printLRS(String str) {
        int n = str.length();
        int m = n;

        String[][] dp = new String[n+1][m+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0 || j ==0)
                    dp[i][j] = "";
                else
                    if(str.charAt(i-1) == str.charAt(j-1) && i != j)
                        dp[i][j] = str.charAt(i - 1) + dp[i-1][j-1];
                    else
                        dp[i][j] = dp[i][j-1].length() > dp[i-1][j].length() ? dp[i][j-1] : dp[i-1][j];
            }
        }
        Stream.of(dp).map(Arrays::toString).forEach(System.out::println);
        StringBuilder sb = new StringBuilder();
        sb.append(dp[n][m]);
        return sb.reverse().toString();
    }

    private static int findLRSLen(String str) {
        int n = str.length();
        int m = n;
        int[][] dp = new int[n+1][m+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0 || j==0)
                    dp[i][j]=0;
                else
                    if(str.charAt(i-1)==str.charAt(j-1) && i != j)
                        dp[i][j] = 1 + dp[i-1][j-1];
                    else
                        dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[n][m];
    }
}
