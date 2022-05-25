import java.util.Scanner;

class Solution {

    public static boolean squareIsWhite(String coordinates) {
        // int number = Integer.parseInt(coordinates.charAt(1)+"");
        // if((coordinates.charAt(0) - 'a' ) % 2 == 0 && number % 2 ==0){
        //     //1.odd characters with even digits
        //     return true;
        // }else if((coordinates.charAt(0) - 'a' ) % 2 != 0 && number % 2 !=0){
        //     //2.even characters with odd digits
        //     return true;
        // }else return false;

        //0ms
        int x = (int) coordinates.charAt(0);
        int y = (int) coordinates.charAt(1);
        //System.out.println(x+" "+y);
        if ((x % 2 != 0 && y % 2 == 0) || (x % 2 == 0 && y % 2 != 0))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase-- > 0) {
            String coordinates = sc.next();
            str.append(squareIsWhite(coordinates)).append("\n");
        }
        System.out.println(str);
    }
}
/*
8
"a1"
"h3"
"c7"
"g6"
"e7"
"d8"
"c5"
"b2"

 */