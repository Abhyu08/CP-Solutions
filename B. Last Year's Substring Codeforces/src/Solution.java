import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class Solution {

    private static char[] string = {'2', '0', '2', '0'};


    //DRIVER FUNCTION
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder();
        int testcases = sc.nextInt();
        while (testcases-- > 0) {
            int n = sc.nextInt();
            sc.nextLine();
            String arr = sc.nextLine();
            if (arr.length() >= 4) {
                if (arr.charAt(0) == '2' && arr.charAt(n - 1) == '0') {

                    if (arr.charAt(1) == '0' && arr.charAt(n - 2) == '2') {
                        str.append("YES\n");
                    } else if (arr.charAt(1) != '0') {
                        if (arr.charAt(n - 3) == '0' && arr.charAt(n - 2) == '2') {
                            str.append("YES\n");
                        } else str.append("NO\n");
                    } else {
                        if (arr.charAt(2) == '2') {
                            str.append("YES\n");
                        } else str.append("NO\n");
                    }

                } else if (arr.charAt(0) != '2') {
                    int l = 3;
                    for (int i = n - 1; i >= 0 && l >= 0; i--, l--) {
                        if (arr.charAt(i) != string[l])
                            break;
                    }
                    if (l <= -1)
                        str.append("YES\n");
                    else str.append("NO\n");

                } else if (arr.charAt(n - 1) != '0') {

                    int l = 0;
                    for (int i = 0; i < n && l <= 3; i++, l++) {
                        if (arr.charAt(i) != string[l])
                            break;
                    }
                    if (l >= 4)
                        str.append("YES\n");
                    else str.append("NO\n");
                }
            } else str.append("NO\n");
        }
        System.out.println(str);
    }
}