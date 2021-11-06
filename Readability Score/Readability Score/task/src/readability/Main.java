package readability;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static String ReadFileAsString(String filename) throws IOException {
        return (new String(Files.readAllBytes(Path.of(filename))));
    }

    public static double Readability_Index(double Words, double Sentences, double Characters) {
        double db = (4.71 * (Characters / Words)) + (0.5 * (Words / Sentences)) - 21.43;
        double fract = db - (long) db;
        fract = (long) (fract * 1e9 + 0.5) / 1e9;
        double db1 = (long) db + (float) ((int) (fract * 100)) / 100;
        db1 = Math.round(db1 * 100.0) / 100.0;
        return db1;
    }

    public static String Understandable_category(int score) {
        if (score == 1) {
            return "5-6";
        } else if (score == 2) {
            return "6-7";
        } else if (score == 3) {
            return "7-9";
        } else if (score == 4) {
            return "9-10";
        } else if (score == 5) {
            return "10-11";
        } else if (score == 6) {
            return "11-12";
        } else if (score == 7) {
            return "12-13";
        } else if (score == 8) {
            return "13-14";
        } else if (score == 9) {
            return "14-15";
        } else if (score == 10) {
            return "15-16";
        } else if (score == 11) {
            return "16-17";
        } else if (score == 12) {
            return "17-18";
        } else if (score == 13) {
            return "18-24";
        } else
            return "24+";
    }

    public static void main(String[] args) {

        try {
            String filename = args[0];
            System.out.println("The text is:\n" + ReadFileAsString(filename));
            String str = ReadFileAsString(filename);

            int count = 0;
            int characters = 0;

            //------------------------------------------
            Pattern p = Pattern.compile("\\w");
            Matcher mat = p.matcher(str);
            while (mat.find())
                characters++;
            int spaces = 0;
            p = Pattern.compile("\\s");
            mat = p.matcher(str);
            while (mat.find())
                spaces++;
            //------------------------------------------

            String[] Strings_Split = str.replaceAll("^[\\W]+", "").split("[!.?$]+");   //count Sentences

            String[] Words_Split;  //count words

            for (String var : Strings_Split) {
                Words_Split = var.replaceAll("^[\\s]+", "").split("[ ]+");
                count += Words_Split.length; //count words
            }

            int Sentences = Strings_Split.length;
            characters += str.length() - characters - spaces;
            double score = Readability_Index(count, Sentences, characters);

            System.out.println("Words: " + count);
            System.out.println("Sentences: " + Sentences);
            System.out.println("Characters: " + characters);
            System.out.println("The score is: " + score);
            System.out.println("This text should be understood by " + Understandable_category((int) Math.ceil(score)) + " year olds.");

        } catch (IOException e) {
            System.out.println("File not Found:" + e.getMessage());
        }
    }
}
