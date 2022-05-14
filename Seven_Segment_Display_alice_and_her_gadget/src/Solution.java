
import java.util.Scanner;
/*
Q. Alice and her Gadget
Alice recently bought a gadget, having seven-segment display. The gadget is having seven switches named a.b.delg, and each switch comesponds to a segment to be displayed in the gadget Alice found a string of numbers, now she decided to display each number in het gadget one by one. The gadget can display only one number from her string at a time. Numbers are displayed in the below pattern 14 15 segment outputs deplay abir 110 16 1 0 01010 2 7 o 1 Cunu 18 o 1 5 19 o 1 1 010 o o 20 1 JU 010 1 7-Segment Display 21 22 Alice is a bit lazy, she wants to do the minimum number of loggle Initially, all switc al
0122 Completed 00:51:49 Nice is a bit lazy she wants to do the minimum number of loggle Tribaly, all swiches ere ofl. Help Alice to find her that minimum number O DE Example 2 Considet Length = 2, N = 15. You must determine the minimum number of logges requred For displaying 1 we need to toggle 2 switches For displaying 5 after 1 we need to toggle 5 swiches. So, the answer would be Function description 15 Complete the sole function provided in the editor.
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        StringBuilder result = new StringBuilder();
        while (testcase-- > 0) {
            Seven_Segments.initialize();
            int no = sc.nextInt();
            int total_count = 0;
            String str = sc.next();

            for (int i = 0; i < str.length(); i++) {
                int number = str.charAt(i) - 48;
                total_count += Seven_Segments.minToggles(number);
            }
            result.append(total_count + "\n");
        }
        System.out.println(result);
    }

}

class Seven_Segments {

    static int[] current = {0, 0, 0, 0, 0, 0, 0};
    static int[] zero = {1, 1, 1, 1, 1, 1, 0};
    static int[] one = {0, 1, 1, 0, 0, 0, 0};
    static int[] two = {1, 1, 0, 1, 1, 0, 1};

    static int[] three = {1, 1, 1, 1, 0, 0, 1};
    static int[] four = {0, 1, 1, 0, 0, 1, 1};
    static int[] five = {1, 0, 1, 1, 0, 1, 1};
    static int[] six = {0, 0, 1, 1, 1, 1, 1};
    static int[] seven = {1, 1, 1, 0, 0, 0, 0};
    static int[] eight = {1, 1, 1, 1, 1, 1, 1};
    static int[] nine = {1, 1, 1, 0, 0, 1, 1};


    public static void initialize() {
        for (int i = 0; i < 7; i++)
            current[i] = 0;
    }

    public static int minToggles(int no) {
        int result = 0;

        switch (no) {

            case 0:
                result = checkDigits(current, zero);
                break;
            case 1:
                result = checkDigits(current, one);
                break;
            case 2:
                result = checkDigits(current, two);
                break;
            case 3:
                result = checkDigits(current, three);
                break;

            case 4:
                result = checkDigits(current, four);
                break;

            case 5:
                result = checkDigits(current, five);
                break;

            case 6:
                result = checkDigits(current, six);
                break;

            case 7:
                result = checkDigits(current, seven);
                break;
            case 8:
                result = checkDigits(current, eight);
                break;
            case 9:
                result = checkDigits(current, nine);
                break;
        }


        return result;
    }

    public static int checkDigits(int[] current, int[] no) {
        int c = 0;
//        System.out.println(Arrays.toString(current) + " \n" + Arrays.toString(no));
        for (int i = 0; i < 7; i++) {
            if (current[i] != no[i]) {
                current[i] = no[i];
                c++;
            }
        }
        return c;
    }
}
/*
2
2
13
3
123

1
3
123

 */