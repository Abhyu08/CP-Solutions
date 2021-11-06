import java.util.Scanner;
 //download all testcases
class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] days = {"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"};
        int testcases = sc.nextInt();
        while (testcases-- > 0) {
            int sum = 0;
            int total_pages = sc.nextInt();
            int[] read_per_day = new int[7];
            for (int i = 0; i < 7; i++) {
                read_per_day[i] = sc.nextInt();
                sum += read_per_day[i];
            }
            if (sum == 0)
                System.out.println("1 monday");
            else if (total_pages <= sum) {
                int temp = 0;
                for (int i = 0; i < 7; i++) {
                    temp += read_per_day[i];
                    if (temp >= total_pages) {
                        System.out.println(i + 1 + " " + days[i]);
                        break;
                    }
                }
            } else {
                int weeks = total_pages / sum;
                int left = total_pages % sum;
                if (left == 0) {
                    System.out.println(weeks * 7 + " " + days[6]);
                } else {
                    int temp = 0;
                    for (int i = 0; i < 7; i++) {
                        temp += read_per_day[i];
                        if (temp >= left) {
                            temp = weeks * 7 + i + 1;
                            System.out.println(temp + " " + days[i]);
                            break;
                        }
                    }
                }
            }
        }
    }
}