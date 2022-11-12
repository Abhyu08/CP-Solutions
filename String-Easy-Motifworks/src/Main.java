import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(check_easy(s));

    }

    public static String check_easy (String s){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) >= 65 && s.charAt(i) <= 90)
                return "NO";
        }
        return "YES";
    }
}