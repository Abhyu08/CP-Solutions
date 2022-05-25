import java.util.Scanner;

public class Solution {

    /*

        //22 ms Solution..
        public static int[] countBits(int no) {

        int[] result = new int[no + 1];
        for (int k = 1, count = 0; k < no + 1; k++, count = 0) {
            String dTob = Integer.toBinaryString(k);
            for (int i = 0; i < dTob.length(); i++) {
                if (dTob.charAt(i) == '1') count++;
            }
            result[k] = count;
        }
        return result;
    }

     */
    public static int[] countBits(int no) {

        int[] result = new int[no + 1];
        //if odd ex: 7 -> 111 -> 3bits
        // 7/2 --> 3 -->(binary) 011 --> 2bits + 1 => 3bits in odd
        //if even 6/2 --> 3(decimal) --> 011(binary) => 2bits in even

        for (int k = 1, count = 0; k < no + 1; k++, count = 0) {
            if (k % 2 != 0) count += result[k / 2] + 1;
            else count += result[k / 2];
            result[k] = count;
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();

        while (testcase-- > 0) {
            int no = sc.nextInt();
            int[] result = countBits(no);
            for (int i = 0; i <= no; i++)
                System.out.print(result[i] + " ");

            System.out.println();
        }
    }
}
/*
4
2
5
10
20

 */