import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        scan.close();
        if (s.equals("                        "))
            System.out.println("0");
        else {
            String[] Split_Strings = s.replaceAll("^[\\W\\s]+", "").split("[\\s!,?._'@]+");
            System.out.println(Split_Strings.length);
            for (String str : Split_Strings)
                System.out.println(str);
        }
    }
}
