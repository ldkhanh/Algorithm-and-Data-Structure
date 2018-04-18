package Dynamic_Programming.G4G;

public class DP_05_Largest_Sum_Conti_Subarray {
    /*  Kadane's Algorithm  */
    private static int maxSubSum(int a[]) {
        int maxT = Integer.MIN_VALUE;
        int max = 0;
        for (int e : a) {
            max += e;
            if (maxT < max) maxT = max;
            if (max < 0 ) max = 0;
        }
        return maxT;
    }

    /*  Dynamic Programming */
    static int maxSubSum2(int[] a) {
        int maxT = a[0];
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            max = Math.max(a[i], max + a[i]);
            maxT = Math.max(maxT, max);
        }
        return maxT;
    }

    /* Print the subarray with the maximum sum, we maintain indices whenever we get the maximum sum. */
    static void maxsumsub3(int[] a) {
        int maxT = Integer.MIN_VALUE;
        int max = 0, start = 0, end = 0, s = 0;

        for (int i = 0; i < a.length; i++) {
            max += a[i];
            if (maxT < max) {
                maxT = max;
                start = s;
                end = i;
            }
            if (max < 0) {
                max = 0;
                s = i+1;
            }
        }
        System.out.println("Maximum contiguous sum is " + maxT);
        System.out.println("Starting index " + start);
        System.out.println("Ending index " + end);
    }

    public static void main(String[] args) {
        int[] a = {-2,-3,4,-1,-2,1,5,-3};
        System.out.println("Maximum contiguous sum 1 is " + maxSubSum(a));
        System.out.println("Maximum contiguous sum 2 is " + maxSubSum2(a));
        maxsumsub3(a);
    }
}
