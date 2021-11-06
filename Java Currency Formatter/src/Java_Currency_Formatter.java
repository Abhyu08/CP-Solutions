
import java.util.Scanner;

public class Java_Currency_Formatter {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        double pay = (double) Math.round(payment * 100) / 100;

        String us = Java_Currency_Formatter.US(pay);
        System.out.println("US: $" + us);
        System.out.println("India: Rs." + us);
        System.out.println("China: ￥" + us);
        System.out.println("France: " + Java_Currency_Formatter.France(us));
    }

    private static String France(String us) {
        char[] france = us.toCharArray();
        for(int i=0;i<france.length;i++){
            if(france[i] == '.')
                france[i]=',';
            else if (france[i] == ',')
                france[i]=' ';
        }
        us = String.valueOf(france);
        us = us +" €";
        return us;
    }

    private static String US(double payment) {
        long pay = (long) payment;
        int ment = (int) (payment * 100 - pay * 100);
        int Digits = Java_Currency_Formatter.Count_Digits(pay);

        String test = Long.toString(pay);
        char[] str = test.toCharArray();

        int skip = Digits % 3;
        int count = Digits / 3;
        int repeat = 3;
        if (Digits % 3 == 0) {
            skip = 3;
            count--;
        }
        char[] finall = new char[Digits + count];
        for (int i = 0; i < skip; i++)
            finall[i] = str[i];
        int j = skip;
        for (int i = skip; i < str.length; i++) {
            if (count > 0 && repeat == 3) {
                finall[j] = ',';
                j++;
                count--;
                repeat = 0;
            }
            finall[j] = str[i];
            j++;
            repeat++;
        }
        test = String.valueOf(finall);
        if(ment !=0)
        test = test + "." + Integer.toString(ment);
        else
            test = test + ".00";
        return test;
    }

    public static int Count_Digits(long payment) {
        int count = 0;
        while (payment > 0) {
            payment /= 10;
            count++;
        }
        return count;
    }

}
