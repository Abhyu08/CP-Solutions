import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        String filename = "C:\\Users\\ghata\\Desktop\\dataset_91069.txt";
        File file = new File(filename);
        try {
            Scanner sc = new Scanner(file);
            sc.next();
            sc.next();
            Long max = 0l;
            int year = 0;
            sc.next();
            String temp = sc.next();
            while (sc.hasNext()) {
                temp = temp.replaceAll(",","");
                Long tt = Long.valueOf(temp);
                String yr = sc.next();
                String s = sc.next();
                s = s.replaceAll(",","");
                if (Long.valueOf(s) - tt > max) {
                    max = Long.valueOf(s) - tt;
                    year = Integer.valueOf(yr);
                }
                temp = s;
            }
            System.out.println(year);
        } catch (IOException e) {
            System.out.println("File Not found" + e.getMessage());
        }
    }
}
