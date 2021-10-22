import java.util.Arrays;
import java.util.stream.Stream;

public class RussianDollEnvelopes {
    public static void main(String[] args) {
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        int res=maxEnvelopes(envelopes);
        System.out.println(res);
    }

    public static int maxEnvelopes(int[][] envelopes) {


        /* Sort array in asc order of a(width)*/
        Arrays.sort(envelopes,(a, b) -> Double.compare(a[0],b[0]));
        Arrays.stream(envelopes).map(Arrays::toString).forEach(System.out::println);

        int[] height = new int[envelopes.length];

        for(int i=0; i<height.length;i++){
            height[i]= envelopes[i][1];
        }

        System.out.println(Arrays.toString(height));

        int[] lis = new int[height.length];

        for(int i=0;i<lis.length;i++)
            lis[i]=1;
        int max = 0;
        for(int i=1;i<height.length;i++){
            for(int j=0;j<i;j++){
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1] && lis[i] <= lis[j] )
                    lis[i] = 1 + lis[j];
            }
            max = Math.max(max,lis[i]);
        }
        return max;

    }
}
