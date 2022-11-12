
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner sc  = new Scanner(System.in);

        int n = sc.nextInt();
        Integer arr[] = new Integer[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        sortBySetBitCount(arr, n);
        printArr(arr, n);
        System.out.println();
    }

    private static void printArr(Integer[] arr, int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    private static Integer[] sortBySetBitCount(Integer[] arr, int n)
    {
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer arg0, Integer arg1)
            {
                if (Integer.bitCount(arg0) <= Integer.bitCount(arg1))
                    return -1;
                else
                    return 1;
            }
        });
        return arr;
    }
}


/*
9
5 2 3 9 4 6 7 15 32

 */