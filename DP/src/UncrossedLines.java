public class UncrossedLines {
    public static void main(String[] args) {
        int[] nums1 = {2,5,1,2,5};
        int[] nums2 = {10,5,2,1,5,2};
        int n= nums1.length;
        int m= nums2.length;
        int[][] dp = new int[n+1][m+1];
        
        int count = maxUncrossedLines(nums1,nums2,n,m,dp);
        System.out.println("Maximum number of uncrossed lines is " + count);
    }

    private static int maxUncrossedLines(int[] nums1, int[] nums2, int n, int m, int[][] dp) {
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){

                if(i==0 || j==0)
                    dp[i][j]=0;
                else
                if(nums1[i-1] == nums2[j-1])
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }

        return dp[n][m];
    }
}
