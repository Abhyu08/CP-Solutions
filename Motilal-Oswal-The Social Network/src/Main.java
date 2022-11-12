import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 1;
        int[] arr = new int[n];
        for (int i = 2; i <= n + 1; i++)
            arr[i - 2] = i;
        //10
        //-1 -1 -1 -1 -1 7 -1 -1 -1 11

        //Logic Implementation
        for(int i=0,flag = 0;i<n;i++,flag = 0){
            if(arr[i] == -1)
                continue;
            for(int j=i+1;j<n;j++){
                if(arr[j] == -1)
                    continue;
                else if(arr[j] % arr[i] == 0){
                    arr[j] = -1;
                    flag = 1;
                }
            }
            if(flag == 1)
                arr[i] = -1;
            else if(arr[i] * 2 <= n+1)
                arr[i] = -1;
            else
               count++;
        }

        System.out.println(count);

    }
}