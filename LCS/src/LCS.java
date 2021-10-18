public class LCS {
    public static void main(String[] args) {
        String X = "ABCDGH";
        String Y = "AEDFHR";
        int len;
        String lcsString;
        int[][] dp = new int[X.length()+1][Y.length()+1];
        len = longestLCSLen(X,Y,X.length(),Y.length(),dp);
        System.out.println("Length of longest LCS is " + len);
        lcsString = printLongestLCSString(X,Y,X.length(),Y.length(),dp);
        System.out.println("Longest LCS is " + lcsString);
    }

    public static String printLongestLCSString(String x, String y, int n, int m,int[][] dp) {
        StringBuilder sb = new StringBuilder();
        while(dp[n][m] > 0){
            if(dp[n][m] > dp[n-1][m-1]){

                if(dp[n-1][m] == dp[n][m-1] && dp[n-1][m-1] == dp[n][m-1]){
                    sb.append(x.charAt(n-1));
                    n--;
                    m--;
                }else
                    if(dp[n][m-1] > dp[n-1][m])
                        m--;
                    else n--;

            }else{
                n--;
            }
        }
        return sb.reverse().toString();
    }

    public static int longestLCSLen(String x, String y, int n, int m,int[][] dp) {
       // int[][] dp = new int[n+1][m+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0 || j==0)
                    dp[i][j]=0;
                else if(x.charAt(i-1)==y.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}
