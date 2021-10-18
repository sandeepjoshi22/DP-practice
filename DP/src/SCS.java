public class SCS {
    public static void main(String[] args) {
        // Shortest Common SuperSequence

        String s1 = "abac";
        String s2 = "cab";
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        int len;
        len = findSCSLength(s1,s2,s1.length(),s2.length(),dp);
        System.out.println("Length of Shortest Common SuperSequence is " + len);

        String res;
        res = printSCS(s1,s2,s1.length(),s2.length(),dp);
        System.out.println("Shortest Common SuperSequence is " + res);
    }

    public static int findSCSLength(String s1, String s2, int n, int m, int[][] dp) {
        return (n+m)-LCS.longestLCSLen(s1,s2,n,m,dp);
    }

    public static String printSCS(String s1, String s2, int n, int m, int[][] dp) {
        String lcsString = LCS.printLongestLCSString(s1,s2,n,m,dp);

        StringBuilder res = new StringBuilder();
        int i=0,j=0,k=0; // 3 pointers : i -> LCS string, j -> s1 , k -> s2

        // Iterate over LCS string length
        while (i<lcsString.length()){
            // 1st element of s1 not matching 1st element of LCS string
            if(lcsString.charAt(i) != s1.charAt(j)){
                res.append(s1.charAt(j)); // Add it to result
                j++; // move pointer of s1
            } else if(lcsString.charAt(i) != s2.charAt(k)) {
                res.append(s2.charAt(k)); // Add it to result
                k++; // move pointer of s2
            }
            else{
                    res.append(lcsString.charAt(i));
                    i++;
                    j++;
                    k++;
                }
            }


        // Add remaining items in s1 and s2 to res
        while(j<s1.length()){
            res.append(s1.charAt(j));
            j++;
        }

        while(k<s2.length()){
            res.append(s2.charAt(k));
            k++;
        }

        return res.toString();
    }
}
