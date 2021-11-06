import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 10)
            n = 0;
        else
            n-=10;
        if (n == 10)
            System.out.println("15");
        else if (n == 0 || n > 11)
            System.out.println("0");
        else
            System.out.println("4");
    }
}
