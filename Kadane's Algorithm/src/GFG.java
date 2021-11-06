import java.util.Scanner;

class Kadane{

    // Function to find subarray with maximum sum
    // arr: input array
    // n: size of array
    int maxSubarraySum(int[] arr, int n){

        int max = Integer.MIN_VALUE;
        int current_min = 0;
        for (int i = 0; i < n; i++) {
            current_min = current_min + arr[i];
            if (current_min > max)
                max = current_min;
            if (current_min < 0)
                current_min = 0;
        }
        return max;

    }
}


public class GFG {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number_of_elements = sc.nextInt();
        int[] arr = new int[number_of_elements];
        for (int i = 0; i < number_of_elements; i++) {
            arr[i] = sc.nextInt();
        }
        Kadane kd = new Kadane();
        int maxSum = kd.maxSubarraySum(arr, number_of_elements);
        System.out.println(maxSum);
    }
}
