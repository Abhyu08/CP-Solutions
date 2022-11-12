import java.util.*;
import java.util.Scanner;

public class Main {

    public static int raisingPower(List<Integer> arr) {
        if (arr.size() <= 2)
            return 1;
        else {
            for (int i = 0; i < arr.size() - 1; i++) {
                int pow = (int) Math.pow(arr.get(i), arr.get(i + 1));
                arr.set(i, pow);
            }
            int index = 0;
            int max_element = Integer.MIN_VALUE;
            for (int i = 0; i < arr.size() - 1; i++) {
                if (max_element < arr.get(i)) {
                    max_element = arr.get(i);
                    index = i + 1;
                }
            }
            return index;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(sc.nextInt());

        System.out.println(raisingPower(list));
    }

}
/*
3
1 2 3

2
2 3

6
3 5 4 5 2 10

 */