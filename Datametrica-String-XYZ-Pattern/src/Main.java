import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(getMaxCount(s));
    }
    public static int getMaxCount(String str){
        int index = str.indexOf( "XYZ") ;
        int count = 0;
        while (index >= 0){
            str = str.replaceFirst("XYZ" , "YZX");
            index = str.indexOf( "XYZ") ;
            count++;
        }
        return count;
    }
}
/*
XYZXYZ

 */