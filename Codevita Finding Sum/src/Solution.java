import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input
        String input = sc.nextLine();
        String[] input1 = input.split(",");
        int n = Integer.parseInt(input1[0]);
        int x = Integer.parseInt(input1[1]);
        String array = sc.nextLine();
        String[] array1 = array.split(",");
        //Input Done...
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < array1.length; i++) {
            int temp = Integer.parseInt(array1[i]);
            if (temp % x == 0)
                set.add(temp);
            else
                list.add(temp);
        }
        //Input Done...
        int count = 0;
        int length = list.size();

        if (list.size() >= 2) {
            for (int i = 0; i < length - 1; i++) {
                int j = i + 1;
                //System.out.println(list.get(i));
                while (j < length) {
                    int curr_sum = list.get(i) + list.get(j);
                    if (curr_sum % x == 0) {
                        System.out.println(list.get(i) + " " + list.get(j));
                        count += set.size();
                    }
                    j++;
                }
            }
        } else
            count = set.size();

        System.out.println(count);
        System.exit(0);
    }
}
/*
4,5
5,10,15,20
5,5
3,7,12,13,15
4,5
3,7,13,15
 */