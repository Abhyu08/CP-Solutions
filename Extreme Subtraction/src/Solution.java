import java.util.Scanner;
/*Abhyu08*/
public class Solution {

    static boolean Right_to_Left(int[] arr, int n) {
        boolean one_time = true;
        int minus_no = arr[n - 1];
        arr[n - 1] = 0;
        int remaining_max_difference = 0;

        for (int i = n - 2; i >= 0; i--) {


            if (arr[i] < minus_no) {
                if (arr[i] < remaining_max_difference) {
                    boolean bool = Left_to_Right(arr, i, remaining_max_difference);
                    if (!bool)
                        return false;
                }
                minus_no = arr[i];
                arr[i] = remaining_max_difference;
                continue;
            } else if (arr[i] == remaining_max_difference)
                continue;

            int current_diff = arr[i] - minus_no;


            if (current_diff < remaining_max_difference) {
                boolean bool = Left_to_Right(arr, i, remaining_max_difference);
                if (!bool)
                    return false;
                if (one_time) {
                    i++;
                    one_time = false;
                }
                continue;
            } else if (remaining_max_difference < current_diff)
                remaining_max_difference = current_diff;
            arr[i] = current_diff;
        }
        return true;
    }


    static boolean Left_to_Right(int[] arr, int index, int given) {

        int minus_no = arr[0];
        int remaining_max_difference = 0;

        if (minus_no < given)
            return false;
        arr[0] = given ;
        for (int i = 1; i <= index; i++) {

            if (arr[i] < given)
                return false;

            if (arr[i] < minus_no) {
                if (arr[i] < remaining_max_difference)
                    return false;
                minus_no = arr[i];
                arr[i] = given ;
                continue;
            } else if (arr[i] == remaining_max_difference)
                continue;

            int current_diff = arr[i] - minus_no;


            if (current_diff < remaining_max_difference) {
                return false;
            } else if (remaining_max_difference < current_diff)
                remaining_max_difference = current_diff;
            arr[i] = given ;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        boolean state;
        while (testcases-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            state = Right_to_Left(arr, n);
            if (state)
                System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
/**/