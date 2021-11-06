//put imports you need here

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] abcd = new String[4];
        for (int i = 0; i < 4; i++)
            abcd[i] = sc.nextLine();

        for (int i = 3; i >= 0; i--) {
            String[] line = abcd[i].trim().split(" ");
            for (int j = line.length - 1; j >= 0; j--) {
                System.out.println(line[j]);
            }
            // System.out.println(line[j]);
        }
        sc.close();
    }
}