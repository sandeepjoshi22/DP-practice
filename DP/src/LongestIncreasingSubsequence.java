import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        //LIS
        int[] nums = {99,100,1,2,101,3};
        //int[] nums = {1,100,3,2,6};
        int[] res = new int[nums.length];
        int len = findLISLength(nums,res);
        System.out.println("Length of LIS is " + len);

        printLIS(nums,res,len);
    }

    private static void printLIS(int[] nums, int[] res,int len) {

        ArrayList<Integer> list = new ArrayList<>();
        while(len>0){
            for(int i=0;i<res.length;i++){
                if(res[i] == len ) {
                    if(list.size()== 0 || Collections.max(list) > res[i]){
                        list.add(nums[i]);
                        len--;
                        break;
                    }

                }
            }
        }
        Collections.reverse(list);
        System.out.println("LIS is ");
        System.out.println(list);
    }

    private static int findLISLength(int[] nums, int[] res) {
        for(int i=0;i<res.length;i++)
            res[i]=1;

        for(int i=1;i<nums.length;i++){
            int j=0;
            while(j<i){
                if(nums[j] < nums[i] && res[j] >= res[i])
                    res[i] = 1 + res[j];
                j++;
            }
        }

        Arrays.stream(res).forEach(System.out::println);

        System.out.println(Arrays.toString(res));

        return Arrays.stream(res).max().getAsInt();

    }
}
