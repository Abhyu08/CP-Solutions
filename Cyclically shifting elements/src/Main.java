import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i]=scan.nextInt();
        scan.close();
        System.out.print(arr[n-1]+" ");
        for(int i=0;i<n-1;i++)
            System.out.print(arr[i]+" ");
    }
}
