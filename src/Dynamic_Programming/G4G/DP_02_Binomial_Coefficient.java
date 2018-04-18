package Dynamic_Programming.G4G;

public class DP_02_Binomial_Coefficient {
    static int binomialCoeff(int n, int k) {
        // Base case
        if (k == 0 || k == n)
            return 1;
        return binomialCoeff(n-1, k-1)  + binomialCoeff(n-1,k);
    }

    // Overlapping Subproblem
    // Returns value of Binomial Coefficient C(n,k)
    private static int binomialC2(int n, int k) {
        int C[][] = new int[n+1][k+1];
        int i,j;
        // Calculate value of Binomial Coefficient in bottom up manner
        for (i = 0; i <= n; i++) {
            for (j = 0; j <= Math.min(i,k); j++) {
                // Base Cases
                if (j == 0 || j == i)
                    C[i][j] = 1;
                // Calculate value using previously stored values
                else
                    C[i][j] = C[i-1][j-1] + C[i-1][j];
            }
        }
        return C[n][k];
    }

    // Space optimized version
    private static int binomialC3(int n, int k) {
        int C[] = new int[k+1];

        //nC0 is 1
        C[0] = 1;
        for (int i = 1; i <= n; i++) {
            // Compute next row of pascal
            // triangle using the previous row
            for (int j = Math.min(i,k); j > 0; j--)
                C[j] = C[j] + C[j-1];
        }
        return C[k];
    }

    public static void main(String[] args) {
        int n = 5, k = 2;
        System.out.printf("Value of C(%d,%d) is %d ", n, k, binomialCoeff(n,k));
        System.out.printf("\nValue of C("+n+","+k+") is " + binomialC2(n,k));
        System.out.printf("\nValue of C("+n+","+k+") is " + binomialC3(n,k));
    }
}
