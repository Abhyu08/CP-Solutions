import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static int decTobinary(int num) {
        // Dec TO Binary Implementation .
        int result = 0;
        while (num > 0) {
            if (num % 2 != 0)
                result++;
            num /= 2;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String input = sc.nextLine();
        String[] arr = input.split(" ");
        List<Integer> list = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(arr[i]);
            int toBinary = decTobinary(num);
            list.add(toBinary);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (list.get(i) > list.get(j))
                    count++;
            }
        }
        System.out.println(count);
    }
}
/*
5
55 53 88 27 33 --> 8
8
120 21 47 64 72 35 18 98    --> 15
 */