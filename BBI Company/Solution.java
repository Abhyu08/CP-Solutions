package tester;

import java.util.Scanner;
/*
Q: https://drive.google.com/drive/folders/1-murTquN1tqnbV4aF5RTVmFb9KFQO_dS
 : Drive/Company Question/BBI/Coding Question
 */

public class Solution {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter inputs size : ");
        int no = sc.nextInt() + 1;
        String[] arr = new String[no];
        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.nextLine();

        System.out.println(total(arr));
    }

    public static String total(String[] groceryList) {
        StringBuilder str = new StringBuilder();
        int total = 0;

        for (int i = 0; i < groceryList.length; i++) {
            String[] stringarray = groceryList[i].split("[, . ' ; \" { } | / \\  ]+");

            try {
                int price = Math.abs(Integer.parseInt(stringarray[1]));
                int units = Math.abs(Integer.parseInt(stringarray[2]));

                int t = price * units;
                total += t;
                str.append("+" + t);

            } catch (Exception e) {
                continue;
            }
        }
        if (total == 0)
            str.append("0");

        str.append("=" + total);
        String result = str.substring(1);

        return result;
    }

}
/*
//Input1:
apple 5 1
oranges 6 1

//Input2:
bread -1;1
milk -2;1

//Input3:
butter M N
milk 1 1

//Input4:
cucumber -2 10

//OUTPUT:
//
//enter inputs size : 1
//cucumber -2 10
//20=20


*/
