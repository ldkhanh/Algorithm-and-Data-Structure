package Dynamic_Programming.G4G;

public class DP_06_Ugly_Number_DP {
    public static void main(String[] args) {
        DP_06_Ugly_Number_DP obj = new DP_06_Ugly_Number_DP();
        int no = obj.getNth_UglyNo(150);
        System.out.println("150th ugly no. is " + no);
    }
    private int getNth_UglyNo(int n) {
        int ugly[] = new int[n];        // To store ugly numbers
        int i2 = 0, i3 = 0, i5 = 0;
        int next_mul_2 = 2;
        int next_mul_3 = 3;
        int next_mul_5 = 5;
        int next_ugly_no = 1;

        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            next_ugly_no = Math.min(next_mul_2, Math.min(next_mul_3, next_mul_5));
            ugly[i] = next_ugly_no;
            if (next_ugly_no == next_mul_2) {
                i2++;
                next_mul_2 = ugly[i2]*2;
            }
            if (next_ugly_no == next_mul_3) {
                i3++;
                next_mul_3 = ugly[i3]*3;
            }
            if (next_ugly_no == next_mul_5 ) {
                i5++;
                next_mul_5 = ugly[i5] *5;
            }
        }
        return next_ugly_no;
    }
}
