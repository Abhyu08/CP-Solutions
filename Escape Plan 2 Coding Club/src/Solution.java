/*
 int n = in.nextInt(), m = in.nextInt(),
                a[][] = new int[n][m], k = in.nextInt(),
                b[][] = new int[k][2], i, x = 0, y = 0, j, z;
        double sum = 0, max = -1;
        for (i = 0; i < k; i++) {
            b[i][0] = in.nextInt();
            b[i][1] = in.nextInt();
            a[b[i][0] - 1][b[i][1] - 1] = 1;
        }
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= m; j++) {
                sum = 0;
                if (a[i - 1][j - 1] != 1)
                    for (z = 0; z < k; z++) {
                        sum = sum + Math.sqrt(Math.pow(i - b[z][0], 2) + Math.pow(j - b[z][1], 2));
                    }
                if (sum > max) {
                    max = sum;
                    x = i;
                    y = j;
                }
            }
        }
           System.out.println(x + " " + y);


* */

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
    }
}

