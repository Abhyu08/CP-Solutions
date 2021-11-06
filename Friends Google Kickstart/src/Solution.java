import java.util.Arrays;
import java.util.Scanner;


class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        sc.nextLine();

        for (int k = 1; k <= testcases; k++) {
            int friends = sc.nextInt();
            int queries = sc.nextInt();
            String result = "";
            sc.nextLine();
            String input = sc.nextLine();
            String[] Friends_Name = input.trim().split(" ");
            while (queries-- > 0) {

                int friend1 = sc.nextInt() - 1;
                int friend2 = sc.nextInt() - 1;
                int index1 = 0, index2 = 0;
                String sort1 = (String) Friends_Name[friend1];
                String sort2 = (String) Friends_Name[friend2];
                char[] sorted1 = sort1.toCharArray();
                char[] sorted2 = sort2.toCharArray();
                char[] original1 = new char[sorted1.length];
                char[] original2 = new char[sorted2.length];
                for (char i : sorted1)
                    original1[index1++] = i;
//-------------------------------------------------
                for (char i : sorted2)
                    original2[index2++] = i;
                index1 = 0;
                index2 = 0;
                Arrays.sort(sorted1);
                Arrays.sort(sorted2);
                int arr1_l = sort1.length();
                int arr2_l = sort2.length();
                boolean bool = false;
                char found = '1';
                while (index1 + 1 < arr1_l && index2 + 1 < arr2_l) {
                    if (sorted1[index1] == sorted2[index2]) {
                        found = sorted1[index1];
                        bool = true;
                        break;
                    }
                    if (sorted1[index1] < sorted2[index2])
                        index1++;
                    else index2++;
                }
                if (bool) {
                    index1 = 0;
                    index2 = 0;
                    bool = false;
                    sort1 = (String) Friends_Name[friend1];
                    sort2 = (String) Friends_Name[friend2];
                    while (index1 + 1 < arr1_l && index2 + 1 < arr2_l) {
                        if (sort1.charAt(index1) == found) {
                            index1++;
                            result = result + index1 + " ";
                            break;
                        } else if (sort2.charAt(index2) == found) {
                            index2++;
                            result = result + index2 + " ";
                            break;
                        }
                        index1++;
                        index2++;
                    }
                } else result = result + "-1 ";
            }
            System.out.println("Case #" + k + ": " + result);
        }
    }
} 