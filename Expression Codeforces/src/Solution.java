import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        arr[2] = sc.nextInt();
        int max = -1;
        int temp = 0;
        temp = arr[0] * arr[1] + arr[2]; //1
        max = Math.max(temp, max);
        temp = arr[0] * (arr[1] + arr[2]); //2
        max = Math.max(temp, max);
        temp = arr[0] * arr[1] * arr[2]; //3
        max = Math.max(temp, max);
        temp = (arr[0] + arr[1]) * arr[2]; //4
        max = Math.max(temp, max);
        temp = arr[0] + arr[1] + arr[2]; //3
        max = Math.max(temp, max);
        //--------------------------------------
        temp = arr[2] * arr[1] + arr[0]; //1
        max = Math.max(temp, max);
        temp = arr[2] * (arr[1] + arr[0]); //2
        max = Math.max(temp, max);
        temp = arr[2] * arr[1] * arr[0]; //3
        max = Math.max(temp, max);
        //--------------------------------------------

        System.out.println(max);
    }
}