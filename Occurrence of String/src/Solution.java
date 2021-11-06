import java.util.Scanner;

/*  Problem Description ::

    FIND THE TOTAL NUMBER OF STRINGS FROM THE ARRAY WHICH CAN BE REFRAMED TO MATCH PATTERN OF STRING S PROVIDED
    ->YOU CAN ONLY REFRAME(CHANGING EXISTING CHAR) CHAR'S OF A STRING FORWARD A->B //AAAA --> BAAA
    I/P: 1.TOTAL NUMBERS OF STRING [ STRING[] ]
         2.ARRAY OF N STRINGS
         3.STRING(S) WHOSE OCCURRENCE ARE TO BE DETECTED FROM GRP OF STRINGS PROVIDED
    SAMPLE:
        2
        AAAA  BAAA
        BAAA2

        OUTPUT:
        2   //AAAA -> BAAA //COUNT OF BAAA = 2
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int n = sc.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
        }
        sc.nextLine();
        String pattern = sc.nextLine();
        for (int i = 0; i < n; i++) {
            int r = str[i].compareTo(pattern);
            if (r == 0 || r < 0)
                count++;
        }
        System.out.println("No of Occurrences of Pattern :: " + count);
    }
}
