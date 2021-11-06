import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] arr = new char[n][m];
        int x = -1, y = -1;
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++)
                arr[i][j] = str.charAt(j);
        }//input over--------------------------------------
        int index2 = -1;
        boolean bool = true;
        for (int i = 0; i < n && bool == true; i++)
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 'B') {
                    x = i + 1;
                    y = j + 1;
                    index2 = y;
                    bool = false;
                    break;
                }
            }
        for (int j = y; j < m; j++) {
            if (arr[x - 1][j] == 'B')
                index2 = j + 1;
            else break;
        }
        if (index2 == y) {
            System.out.println(x + " " + y);
        } else {
            x = x + (index2 - y) / 2;
            y = y + ((index2 - y) / 2);
            System.out.println(x + " " + y);
        }
    }
}

