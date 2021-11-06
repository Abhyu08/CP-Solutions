import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        sc.nextLine();
        for (int k = 1; k <= testcases; k++) {
            int total_levels = sc.nextInt();
            int current_level = sc.nextInt();
            int sword_level = sc.nextInt();
            sc.nextLine();
            int temp = (current_level - sword_level) * 2;
            if (temp < current_level) {
                current_level += temp + (total_levels - current_level);
            } else {
                current_level += total_levels;
            }
            System.out.println("Case #" + k + ": "+current_level);
        }
    sc.close();
    }
}