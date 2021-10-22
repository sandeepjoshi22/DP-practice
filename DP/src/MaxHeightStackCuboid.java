import java.util.Arrays;

public class MaxHeightStackCuboid {

    public static void main(String[] args) {
        int[][] cuboids = {{50,45,20},{95,37,53},{45,23,12}};
        //int[][] cuboids = {{38,25,45},{76,35,3}};
        //int[][] cuboids = {{5,4},{6,4},{6,7},{2,3}};
        int res = maxHeight(cuboids);
        System.out.println("Max height is " + res);
    }

    private static int maxHeight(int[][] cuboids) {
        /* Rotating all boxes such that height is max*/
        for (int[] cube : cuboids) Arrays.sort(cube);
        Arrays.stream(cuboids).map(Arrays::toString).forEach(System.out::println);
        System.out.println(" ");

        /* Sorting boxes such that w3>w2>w1 and l3>l2>l1 and h3>h2>h1*/
        Arrays.sort(cuboids, (a, b) -> (a[0] + a[1] + a[2]) - (b[0] + b[1] + b[2]));
        Arrays.stream(cuboids).map(Arrays::toString).forEach(System.out::println);

        int N = cuboids.length, res = 0;
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = cuboids[i][2];
        }
        System.out.println(" ");

        System.out.println(Arrays.toString(dp));

        for (int i = 1; i < N; i++){
            for (int j = 0; j < i; j++){
                if (cuboids[j][0] <= cuboids[i][0] &&
                        cuboids[j][1] <= cuboids[i][1] &&
                        cuboids[j][2] <= cuboids[i][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                }
            }
            res = Math.max(res, dp[i]);
        }

        System.out.println(Arrays.toString(dp));
        return res;
    }
}
