import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<n;i++)
            list.add(sc.nextInt());

        List<Integer> result = reverseArray(list);
        for(int i=0;i<n;i++)
            System.out.println(result.get(i));

    }
    public static List<Integer> reverseArray(List<Integer> arr){
        List<Integer> result = new ArrayList<>();
        for(int i=arr.size()-1;i>=0;i--)
            result.add(arr.get(i));
        return result;
    }
}