import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt() + 1;
        int count = 0;
        while (testcases-- > 0) {
            String str = sc.nextLine();
            if (str.equals("X++") || str.equals("++X")) {
                count++;
            } else if (str.equals("X--") || str.equals("--X"))
                count--;
        }
        System.out.println(count);
        sc.close();
    }
}
