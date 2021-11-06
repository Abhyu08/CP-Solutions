import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        for(int j=1 ; j<=testcases ;j++){
            int count = 0;
            int n = sc.nextInt();
            int budget = sc.nextInt();

            int[] arr = new int[n+1];
            for (int i = 1; i <= n; i++)
                arr[i] = sc.nextInt();
           arr[0]=0;
            Arrays.sort(arr);
            for (int i = 1; i <= n; i++) {
                arr[i]+=arr[i-1];
                if (arr[i] <= budget)
                    count++;
            }
            System.out.println("Case #" + j + ": "+count);
        }
    }
}/*done*/
