import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 4;
        int[] dp = new int[n+1];
        int res = findFibonacci(n,dp);
        System.out.println("Result is "+ res);
    }

    private static int findFibonacci(int n,int[] dp) {
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        Arrays.stream(dp).forEach(System.out::println);
        return dp[n];
    }
}
