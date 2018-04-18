package Dynamic_Programming.G4G;

public class DP_03_Longest_Common_Subsequence {

    // Simple Recursive of LCS problem
    /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
    private int lcs(char[] X, char[] Y, int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (X[m-1] == Y[n-1])
            return 1 + lcs(X,Y, m-1, n-1);
        else
            return Math.max(lcs(X,Y, m, n-1), lcs(X,Y,m-1, n));
    }

    /* Overlapping Substructure -> Memoization or Tabulation */
    private int lcs2(char[] X, char[] Y, int m, int n) {
        int L[][] = new int[m+1][n+1];

        /* Following steps build L[m+1][n+1] in bottom up fashion.
        * Note that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1]
        * */
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0 )
                    L[i][j] = 0;
                else if (X[i-1] == Y[j-1])
                    L[i][j] = 1 + L[i-1][j-1];
                else
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
            }
        }
        return L[m][n];
    }

    public static void main(String[] args) {
        DP_03_Longest_Common_Subsequence lcs = new DP_03_Longest_Common_Subsequence();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        int m = X.length;
        int n = Y.length;
        System.out.println("Length of LCS 1 is " + " " + lcs.lcs(X,Y, m, n));
        System.out.println("Length of LCS 2 is " + " " + lcs.lcs2(X,Y, m, n));
    }
}
