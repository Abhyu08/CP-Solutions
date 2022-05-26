import java.util.Scanner;

class Solution {
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target)
                return new int[]{left + 1, right + 1};
            else if (sum > target) right--;
            else left++;
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int no = sc.nextInt();
        int[] arr = new int[no];
        for (int i = 0; i < no; i++)
            arr[i] = sc.nextInt();
        int target = sc.nextInt();

        int[] result = twoSum(arr, target);
        for (int i = 0; i < result.length; i++)
            System.out.print(result[i] + " ");
        System.out.println();
    }
}
/*
4
2 7 11 15
9

3
2 3 4
6

 */