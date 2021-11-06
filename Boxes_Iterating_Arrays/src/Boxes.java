import java.util.Arrays;
import java.util.Scanner;

public class Boxes {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr1 = new int[3];
        int[] arr2 = new int[3];

        for (int i = 0; i < 3; i++)
            arr1[i] = sc.nextInt();
        for (int i = 0; i < 3; i++)
            arr2[i] = sc.nextInt();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        boolean Box1 = true, Box2 = true;

        for (int i = 0; i < 3; i++) {
            Box1 = Box1 && arr1[i] > arr2[i];
            Box2 = Box2 && arr1[i] < arr2[i];
        }

        if(Box1 == true)
            System.out.println("Box 1 > Box 2");
        else if(Box2 == true)
            System.out.println("Box 1 < Box 2");
        else
            System.out.println("Incompatible");
    }//main
}//class
