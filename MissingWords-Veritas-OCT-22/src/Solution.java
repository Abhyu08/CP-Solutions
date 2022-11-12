import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        String main_str = sc.nextLine();
        String sub_str = sc.nextLine();

        String[] main_str_arr = main_str.split(" ");
        String[] sub_str_arr = sub_str.split(" ");

        for(int i=0;i< sub_str_arr.length;i++)
            set.add(sub_str_arr[i]);

        for(int i=0;i<main_str_arr.length;i++){
            if(set.contains(main_str_arr[i])){
                continue;
            }else{
                System.out.println(main_str_arr[i]);
            }
        }
    }
}
/*
I am using HackerRank to improve Programming
am HackerRank to improve
 */