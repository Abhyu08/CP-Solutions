import java.util.Scanner;

public class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        StringBuilder str = new StringBuilder();
        while (testcases-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            if (n == 1)
                str.append(arr[0]);
            else {
                int temp = n;
                for (int i = n-1; temp > 0; i = (i + 1) % n, temp--) {
                    str.append(arr[i] + " ");
                }
            }
            str.append("\n");
        }
        System.out.println(str);
    }
}
