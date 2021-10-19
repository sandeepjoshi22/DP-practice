import java.util.Arrays;

public class PatternMatching {
    public static void main(String[] args) {
        // LCS variation
        String P = "AAB";
        String S = "ABBABB";

        boolean result = isPatternMatching(P,S);
        System.out.println("Pattern matching result is :" + result);
    }

    private static boolean isPatternMatching(String p, String s) {
        int n = p.length();
        int m = s.length();
        int i=0,j=0;

        while(i<n && j<m){
            if(p.charAt(i) == s.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
        }

        if(i == n)
            return true;
        else return false;
    }
}
