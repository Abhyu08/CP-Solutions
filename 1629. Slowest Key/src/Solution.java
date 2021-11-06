import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.nextLine();
        String str = sc.nextLine();
        char result = new Solution().slowestKey(arr, str);
        System.out.println(result);
    }

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int max = 0;
        char element = 'a';
        int prev = 0;
        for (int i = 0; i < releaseTimes.length; i++) {
            if (max < releaseTimes[i] - prev) {
                max = releaseTimes[i] - prev;
                element = (char) keysPressed.charAt(i);
            } else if (max == releaseTimes[i] - prev) {
                if (element < keysPressed.charAt(i))
                    element = (char) keysPressed.charAt(i);
            }
            prev = releaseTimes[i];
        }
        return element;
    }
}
