import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        StringBuilder str = new StringBuilder();
        while (testcase-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            str.append(n * m + "\n");
        }
        System.out.println(str);
    }
}
