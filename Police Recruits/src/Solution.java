import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int crime = 0;
        int police = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            if (temp == -1) {
                if (police <= 0)
                    count++;
                else police--;
            } else police+=temp;
        }
        System.out.println(count    );
    }
}
