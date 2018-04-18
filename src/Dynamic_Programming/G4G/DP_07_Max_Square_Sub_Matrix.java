package Dynamic_Programming.G4G;

/* Java code for maximum size square sub-matrix with all 1s */
public class DP_07_Max_Square_Sub_Matrix {
    private static void printMaxSubSquare(int M[][]) {
        int i,j;
        int R = M.length;               // No of rows in M[][]
        int C = M[0].length;            // No of columns in M[][]
        int S[][] = new int[R][C];

        int maxS, maxI, maxJ;

        /* Set first column of S[][] */
        for (i = 0; i < R; i++)         S[i][0] = M[i][0];
        /* Set first row of S[][] */
        for (j = 0; j < C; j++)         S[0][j] = M[0][j];
        /* Construct other entries of S[][] */
        for (i = 1; i < R; i++) {
            for (j = 1; j < C; j++) {
                if (M[i][j] == 1)
                    S[i][j] = Math.min(S[i][j-1], Math.min(S[i-1][j], S[i-1][j-1])) + 1;
                else
                    S[i][j] = 0;
            }
        }

        /*  Find the maximum entry, and indexes of maximum entry in S[][] */
        maxS = S[0][0]; maxI = 0; maxJ = 0;
        for (i = 0; i < R; i++) {
            for (j = 0; j < C; j++) {
                if (maxS < S[i][j]) {
                    maxS = S[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }
        System.out.println("Maximum size sub-matrix is: ");
        for (i = maxI; i > maxI - maxS; i--) {
            for (j = maxJ; j > maxJ - maxS; j--) {
                System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int M[][] =  {{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};
        printMaxSubSquare(M);
    }
}
