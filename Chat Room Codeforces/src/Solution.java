import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = 0;
        boolean status = false;
        char[] arr = {'h', 'e', 'l', 'l', 'o'};
        for (int i = 0; i < str.length(); i++) {
            if (arr[k] == str.charAt(i)) {
                if (k == 4) {
                    status = true;
                    break;
                }
                k++;
            }
        }
        if (status)
            System.out.println("YES");
        else System.out.println("NO");
    }
}