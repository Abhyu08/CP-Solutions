
import java.util.Scanner;

class Solution {

    static int sieveOfEratosthenes(int SP) {
        // code here
        //SP // Starting Position
        int N = 10000,n=-1; //palindrome Upto --> 10^4

        boolean[] arr = new boolean[N + 1];
        //mark all odd with 1
        for (int i = 3; i <= N; i += 2)//i should under sqrt(n) or i^2 < N
            arr[i] = true;

        for (int i = 3; i*i <= N; i += 2) {
            if (arr[i] == true)
                for (int j = i * i; j <= N; j += i)
                    arr[j] = false;
        }
        arr[2] = true;
        arr[0]=arr[1]=false;
        for (int i = SP; i <= N; i++) {
            if (arr[i] == true)
                n = isPalindrome(i);
            if(n!=-1)
                return n;
        }
        return -1;
    }

    static int isPalindrome(int N) {
        //check palindrome
        StringBuilder str = new StringBuilder(Integer.toString(N));
        str.reverse();
        int Rev_no = Integer.parseInt(String.valueOf(str));
        if (Rev_no == N) {
            return N;
        } else return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        int n = sieveOfEratosthenes(N);
        if(n!=-1)
            System.out.println(n);
        else System.out.println("Not Found");
    }
}
