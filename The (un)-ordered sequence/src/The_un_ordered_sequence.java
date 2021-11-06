import java.util.ArrayList;
import java.util.Scanner;

class The_un_ordered_sequence {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int x = -1, var;
        ArrayList<Integer> List = new ArrayList<>();
        while (x != 0) {
            var = x;
            x = sc.nextInt();
            if (x != var && x!=0)
                List.add(x);
        }

        boolean ascending = true, descending = true;
        for (int i = 1; i < List.size() && (ascending || descending); i++) {
            ascending = ascending && List.get(i) >= List.get(i - 1);
            descending = descending && List.get(i) <= List.get(i - 1);

        }
        if (ascending || descending == true)
            System.out.println(true);
        else System.out.println(false);
    }
}
