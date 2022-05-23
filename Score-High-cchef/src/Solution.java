import java.util.Scanner;

 class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        StringBuilder result = new StringBuilder();

        while (testcase-- > 0) {
            int score = sc.nextInt();
            int max_marks = 0;
            for (int i = 0; i < 4; i++) {
                max_marks = Math.max(sc.nextInt(), max_marks);
            }
            result.append(max_marks).append("\n");
        }
        System.out.println(result);
    }
}
