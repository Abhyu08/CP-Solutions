

public class Main {
    static void PassByReference(int[] a) {
        for (int i = 0; i < a.length; i++)
            a[i] = 10;
        for (int i = 0; i < a.length; i++)
            System.out.print("\t" + a[i]);
        System.out.println("---------");
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("before=>");
        for (int i = 0; i < arr.length; i++)
            System.out.print("\t" + arr[i]);
        System.out.println();
        System.out.println("after=>");
        PassByReference(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.print("\t" + arr[i]);
    }

}

