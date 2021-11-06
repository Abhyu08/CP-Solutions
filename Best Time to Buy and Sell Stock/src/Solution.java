import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int no = sc.nextInt();
        int[] arr = new int[no];
        int[] temp = new int[no];
        int max = temp[no - 1];
        for (int i = 0; i < no; i++) {
            int t = sc.nextInt();
            arr[i] = t;
            temp[i] = t;
        }

        for (int i = no - 1; i >= 0; i--) {
            if (temp[i] >= max) {
                max = temp[i];
            } else
                temp[i] = max;
        }
        max = Integer.MIN_VALUE;
        for (int i = 0; i < no; i++) {
            if ((temp[i] - arr[i]) >= max)
                max = temp[i] - arr[i];
        }
       // System.out.println(max);
    }
}
