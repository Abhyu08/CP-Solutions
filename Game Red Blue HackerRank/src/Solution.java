import java.util.Scanner;

/*  927 6627 --> 103 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if (n > m)
            System.out.println(n - m);
        else if (n * 2 == m)
            System.out.println("1");
        else {
            int count = Integer.MAX_VALUE, N = n, temp, c, inner_count = count, previous = -1, hit = 0;
            n++;
            while (true) {
                n--;
                temp = n;
                c = 0;
                if (n < 1)
                    break;
//---------------------------------------------
                if (hit == 20)       //avoid time wastage by searching further same results
                    break;
                else if (previous == count)
                    hit++;
                else hit = 0;
//----------------------------------------------
                while (temp < m) {
                    temp *= 2;
                    c++;
                }
                temp = c + temp - m;
                inner_count = Math.min(inner_count, temp);
                temp = N - n;
                previous = count;
                count = Math.min(inner_count + temp, count);
            }
            System.out.println(count);
        }
    }
}