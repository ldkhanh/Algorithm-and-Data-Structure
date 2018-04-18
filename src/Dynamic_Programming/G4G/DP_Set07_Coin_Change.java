package Dynamic_Programming.G4G;
import java.io.*;
import java.util.Arrays;

public class DP_Set07_Coin_Change {
    // Returns the count of ways we can
    // sum S[0..m-1] coins to get sum n
    private static int count(int S[], int m, int n) {
        // If n is o then there is 1 solution
        if (n == 0 ) return 1;
        // If n is less than 0 then no solution  exists
        if (n < 0 ) return 0;
        // If there are no coins and n >= 0, then no solution exists
        if (m <= 0 && n >= 1)   return 0;

        // Count is sum of solution that do not contain mth coin && contain at least one coin mth.
        // Including S[m-1] && excluding S[m-1]
        return count(S, m-1, n) + count(S, m, n-S[m-1]);
    }


    /*  Overlapping Subproblems  */

    private static int countWay(int S[], int m, int n) {
        // Time complexity of this function: O(mn)
        // Space complexity of this function: O(n)

        // table[i] will storing the number of solutions
        // for value i. We need n+1 rows as the table is constructed in bottom up manner using the base case (n=0)
        int[] table = new int[n+1];
        //Initialize all table value as 0
        Arrays.fill(table, 0);      // O(n)
        //Base case (If given value is 0)
        table[0] = 1;

        /* Pick all coins one by one and update the table[] values
        * after the index greater than or equal to the value of picked coin
        * */

        for(int i = 0; i < m; i++)
            for (int j = S[i]; j <= n; j++)
                table[j] += table[j-S[i]];
        return table[n];
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3};
        int m = arr.length;
        System.out.println(count(arr,m,4));
        System.out.println(countWay(arr,m,4));
    }
}
