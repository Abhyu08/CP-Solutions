import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);
        int n  =sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(sc.nextInt());

        List<String> result = romanizer(list);
        for(int i=0;i<n;i++)
            System.out.println(result.get(i));
    }

    public static List<String> romanizer(List<Integer> numbers) {

        TreeMap<Integer, String> map = new TreeMap<Integer, String>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(8, "VIII");
        map.put(7, "VII");
        map.put(6, "VI");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(3, "III");
        map.put(2, "II");
        map.put(1, "I");

        List<String> result = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++)
            result.add(converToRoman(numbers.get(i), map));

        return result;
    }

    public static String converToRoman(int number, TreeMap<Integer, String> map) {

        int l = map.floorKey(number);
        if (number == l) {
            return map.get(number);
        }
        return map.get(l) + converToRoman(number - l, map);
    }
}
/*
5
1
2
3
4
5

5
75
80
99
100
50


 */