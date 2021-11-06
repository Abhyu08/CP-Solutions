import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q1_x = sc.nextInt();
        int q1_y = sc.nextInt();
        int q2_x = sc.nextInt();
        int q2_y = sc.nextInt();
        if (q1_x == q2_x || q1_y == q2_y)
            System.out.println("YES");
        else {
            if (Math.abs(q1_x - q2_x) == Math.abs(q2_y - q1_y))
                System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
