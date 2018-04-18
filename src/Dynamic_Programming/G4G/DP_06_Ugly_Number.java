package Dynamic_Programming.G4G;

public class DP_06_Ugly_Number {
    public static void main(String[] args) {
        DP_06_Ugly_Number obj = new DP_06_Ugly_Number();
        int no = obj.getNth_UglyNo(150);
        System.out.println("150th ugly no. is " + no);
    }
    private int maxDivide(int a, int b) {
        while ( a % b == 0)
            a = a/b;
        return a;
    }
    private int isUgly(int no) {
        no = maxDivide(no, 2);
        no = maxDivide(no, 3);
        no = maxDivide(no, 5);
        return (no == 1)? 1: 0;
    }
    private int getNth_UglyNo(int n) {
        int i = 1;
        int count = 1; // ugly number count
        while (n > count) {
            i++;
            if (isUgly(i) == 1)
                count++;
        }
        return i;
    }
}
