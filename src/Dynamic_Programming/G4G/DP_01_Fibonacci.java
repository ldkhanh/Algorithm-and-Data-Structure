package Dynamic_Programming.G4G;

// Fibonacci Series using Dynamic Programming
public class DP_01_Fibonacci {

    static int fib(int n) {
        /* Declare an array to store Fibonacci numbers. */
        int f[] = new int[n+1];     //  1 extra to handle case, n = 0
        int i;

        /* 0th and 1st number of the series are 0 and 1*/
        f[0] = 0;
        f[1] = 1;

        for ( i =2; i <= n; i++) {
            /* Add the previous 2 numbers in the series*/
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }
    // Optimize the space used in above method:
    static int fib2(int n) {
        int a = 0, b = 1, c;
        if (n == 0) return a;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String args[]) {
        int n = 9;
        System.out.println(fib(n));
        System.out.println(fib2(n));
    }
}
