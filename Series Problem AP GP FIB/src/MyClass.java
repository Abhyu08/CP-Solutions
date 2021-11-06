import java.util.Scanner;

class MyClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int result = new UserMainCode().GetNextSeriesElement(n, arr);
        System.out.println(result);
    }

}

class UserMainCode {
    public int GetNextSeriesElement(int input1, int[] input2) {
        int result;
        if (input1 >= 3) {
            int d1 = input2[1] - input2[0];
            int d2 = input2[2] - input2[1];
            if (input2[0] == input2[1] && input2[2] == 2) {
                result = fib(input1 + 1);
            } else if (d1 == d2 && input2[1] != input2[2]) {
                result = AP(input2[0], d1, input1 + 1);
            } else if (input2[2] % input2[0] == 0 && input2[1] % input2[0] == 0) {
                result = GP(input2[0], input2[0], input1 + 1);
            } else
                return -999;
        } else {
            return -999;
        }
        return result;
    }

    public static int fib(int n) {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

    public static int GP(int a, int r, int N) {
        return (a * (int) (Math.pow(r, N - 1)));
    }

    public static int AP(int a, int d, int N) {
        return (a + (N - 1) * d);
    }

}

