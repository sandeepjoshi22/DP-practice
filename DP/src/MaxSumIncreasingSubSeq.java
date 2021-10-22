import java.util.Arrays;

public class MaxSumIncreasingSubSeq {
    public static void main(String[] args) {
        //int[] arr = {3,4,5,10};
        //int[] arr = {1,101,2,3,100,4,5};
         int[] arr = {10,5,4,3};
        int max = maxSum(arr);
        System.out.println("Max sum is "+ max);
    }

    private static int maxSum(int[] arr) {
        int N = arr.length;
        int max = arr[0];
        int[] lis = new int[N];
        for(int i=0;i<N;i++)
            lis[i] = arr[i];

        for(int i=1;i<N;i++){
            for(int j=0;j<i;j++){
                if(arr[i] > arr[j]){
                    lis[i] = lis[i] + arr[j];
                }
            }
            max = Math.max(max,lis[i]);
        }
        System.out.println(Arrays.toString(lis));
        return max;
    }
}
