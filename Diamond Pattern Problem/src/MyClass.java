import java.util.Scanner;

class MyClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int N = sc.nextInt();
        long count = 1;
        for (int i = 1; i <= N; i++) {
            if (i == 1) {
                str.append(count + "\n");
                count++;
                continue;
            }

            for (int j = 0; j < i; j++) {
                if (j != 0) {
                    str.append("*");
                }
                str.append(count);
                count++;
            }
            if (i != N)
                str.append("\n");
        }
        result.append(str);
        String[] strings = str.reverse().toString().split("\n");

        for (int i = strings.length - 1; i >= 0; i--) {
            str2.append(strings[i] + "\n");
        }
        result.append(str2.reverse());
        System.out.println(result);
    }


}