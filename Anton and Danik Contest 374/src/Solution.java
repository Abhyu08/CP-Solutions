import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        int A = 0;
        int D = 0;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == 'D') {
                D++;
            } else A++;
        }
        if(D > A)
            System.out.println("Danik");
        else if(A > D)
            System.out.println("Anton");
        else System.out.println("Friendship");
    }
}
