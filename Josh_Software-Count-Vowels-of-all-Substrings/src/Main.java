// JAVA Code to implement the above approach

import java.io.*;
import java.util.*;

public class Main {

    // Function to return the total sum of
    // occurrences of all vowels
    static int vowel_calc(String s)
    {
        int n = s.length();

        // Variable to store the answer
        int totalOccurrences = 0;

        for (int i = 0; i < n; i++) {

            // Count of total occurrences of
            // current character
            int totalOccurrenceForCharInAllSubstrings
                    = (i + 1) * (n - i);

            char ch = s.charAt(i);

            // if the current character is a vowel
            if (ch == 'a' || ch == 'e' || ch == 'i'
                    || ch == 'o' || ch == 'u') {

                // Add the occurrences of current
                // character to the answer
                totalOccurrences
                        += totalOccurrenceForCharInAllSubstrings;
            }
        }

        // Return the total sum
        // of occurrences of vowels
        return totalOccurrences;
    }

    // Driver Code
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String s = "abcde";

        // Function Call
        System.out.println(vowel_calc(s));
    }
}
