import java.util.Scanner;

class Solution {
    static int isPalindrome(String str) {
        StringBuilder Str = new StringBuilder(str);
        Str.reverse();
        if (str.equals(Str.toString()))
            return 1;
        else return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int queries = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();

        for (int i = 0; i < queries; i++) {
            int N = -1;
            int l = sc.nextInt()-1;
            int r = sc.nextInt();
            String Str = new String(s.substring(l, r));
            N = isPalindrome(Str);
            if (N != -1)
                System.out.println("yes");
            else System.out.println("no");
        }
    }
}

