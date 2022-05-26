import java.util.Scanner;

class Solution {
    public static int largestAltitude(int[] gain) {
        int max = Math.max(gain[0], 0);
        for (int i = 1; i < gain.length; i++) {
            gain[i] += gain[i - 1];
            if (gain[i] > max) max = gain[i];
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int no = sc.nextInt();
        int[] arr = new int[no];
        for (int i = 0; i < no; i++)
            arr[i] = sc.nextInt();
        System.out.println(largestAltitude(arr));
    }
}