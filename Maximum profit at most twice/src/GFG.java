/*
Previous Partially Accepted Solution : 123. Best Time to Buy and Sell Stock III

//class Solution {
//    public int maxProfit(int[] prices) {
//        int temp = 0;
//        int[] arr = new int[100000]; //store row_max upto n-1
//        int[] arr2 = new int[100000]; //store last index
//        Arrays.fill(arr, Integer.MIN_VALUE);
//        int length = prices.length;
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < length - 1; i++) {
//            int row_max = Integer.MIN_VALUE;
//            int c = -1;
//            for (int j = i + 1; j < length; j++, c++) {
//                temp = prices[j] - prices[i];
//                if (c >= 1 && j < length - 1) { //arr[i] + temp
//                    if (temp + arr[c] > max) {
//                        System.out.println("temp = " + temp + " arr[c]=" + arr[c] + " arr[j]=" + j + " i =" + i);
//                        max = temp + arr[c];
//                    }
//                }
//                if (j == length - 1) {
//                    arr2[i] = temp;
//                    continue;
//                } else if (temp >= row_max)
//                    row_max = temp;
//                if (arr[j] < row_max)
//                    arr[j] = row_max;
//            }
//        }
//        int m = max;
//        //-----------------
//        System.out.println("max  = " + m);
//        for (int i = 0; i < length - 1; i++) {
//            for (int j = 1; j < length - 1; j++) {
//                System.out.print(arr[j] + " ");
//            }
//            System.out.println(arr2[i]);
//        }
//        //-----------------
//        if (length >= 2)
//            max = Math.max(arr2[0], arr[length - 2]);
//        else
//            max = arr2[0];
//        int count = 0;
//        for (int i = 1; i < length - 1; i++) {
//            int add = 0;
//            if (i != 1 && arr[count] > 0) {
//                add = arr[count];
//            }
//            temp = arr2[i] + add;
//            if (temp >= max)
//                max = temp;
//            count++;
//        }
//        return Math.max(Math.max(max, 0), Math.max(m, 0));
//    }
//}
 */

import java.util.Arrays;
import java.util.Scanner;

public class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int result = new Solution().maxProfit(arr);
        System.out.println(result);
    }
}

class Solution {
    //    public int maxProfit(int[] prices) {
//        int[] dp = new int[1000000];
//        Arrays.fill(dp, 0);
//
//        //Profit From Right to Left :
//        int max = prices[prices.length - 1];
//        for (int i = prices.length - 1; i >= 0; i--) {
//            dp[i + 1] = Math.max(dp[i + 2], max - prices[i]);
//            max = Math.max(max, prices[i]);
//        }
//        //Profit From Left to Right :
//        int min = prices[0];
//        for (int i = 0; i < prices.length; i++) {
//            dp[i + 1] = Math.max(dp[i], dp[i + 1] + prices[i] - min);
//            min = Math.min(min, prices[i]);
//        }
//
//        return dp[prices.length];
//    }
    static int maxProfit(int price[]) {
        int n = price.length;
        // buy1 - Money lent to buy 1 stock
        // profit1 - Profit after selling
        // the 1st stock buyed.
        // buy2 - Money lent to buy 2 stocks
        // including profit of selling 1st stock
        // profit2 - Profit after selling 2 stocks
        int buy1, profit1, buy2, profit2;

        // Set initial buying values to
        // Integer.MAX_VALUE as we want to
        // minimize it
        buy1 = buy2 = Integer.MAX_VALUE;

        // Set initial selling values to
        // zero as we want to maximize it
        profit1 = profit2 = 0;

        for (int i = 0; i < n; i++) {

            // Money lent to buy the stock
            // should be minimum as possible.
            // buy1 tracks the minimum possible
            // stock to buy from 0 to i-1.
            buy1 = Math.min(buy1, price[i]);

            // Profit after selling a stock
            // should be maximum as possible.
            // profit1 tracks maximum possible
            // profit we can make from 0 to i-1.
            profit1 = Math.max(profit1, price[i] - buy1);

            // Now for buying the 2nd stock,
            // we will integrate profit made
            // from selling the 1st stock
            buy2 = Math.min(buy2, price[i] - profit1);

            // Profit after selling a 2 stocks
            // should be maximum as possible.
            // profit2 tracks maximum possible
            // profit we can make from 0 to i-1.
            profit2 = Math.max(profit2, price[i] - buy2);
        }
        return profit2;
    }
}

/*
10
1 2 4 2 5 7 2 4 9 0 -> 13
7
2 1 4 5 2 9 7 ->11
6
6 1 3 2 4 7   ->7
3
1 4 2
6
10 22 5 75 65 80
7
2 30 15 10 8 25 80
7
100 30 15 10 8 25 80
5
90 80 70 60 50
8
3 3 5 0 0 3 1 4
5
1 2 3 4 5
5
7 6 4 3 1

 */