import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.Scanner;

public class Solution {
    public static String ReadFilesAsStrings(String filename) throws IOException {
        return new String (Files.readAllBytes(Path.of(filename)));
    }
    public static void main(String[] args)  {
        String filename = "C:\\Users\\ghata\\Desktop\\dataset_91007.txt";
        File file  = new File(filename);
        try{
            Scanner sc = new Scanner(file);
            int max = -1;
            while(sc.hasNext()){
                String s = sc.next();
                if(max < Integer.valueOf(s))
                    max = Integer.valueOf(s);
            }
            System.out.println(max);
        }catch (IOException e){
            System.out.println("File Not found"+e.getMessage());
        }
    }
}
