import java.util.*;

class Solution {
    public static String Substring(String str, int left, int right) {
        char[] arr = new char[right - left + 2];
        for (int i = left, j = 0; i <= right; i++, j++)
            arr[j] = str.charAt(i);
        return (String.valueOf(arr));
    }

    public static String ReverseOrder(char[] str) {
        int length = str.length;
        char temp;
        for (int i = 0, j = length - 1; i < j; i++, j--) {
            temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
        return String.valueOf(str);
    }

    private static HashMap sortByValues(HashMap map) {
        List list = new LinkedList(map.entrySet());
        // Defined Custom Comparator here
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {

                int cmp = ((Comparable) ((Map.Entry) (o1)).getValue())
                        .compareTo(((Map.Entry) (o2)).getValue());
                if (cmp == 0) {
                    String line1 = (String) ((Map.Entry) (o1)).getValue();
                    String line2 = (String) ((Map.Entry) (o2)).getValue();
                    int i = 0;
                    int a = 0;
                    while (line1.charAt(i) != ' ') {
                        a += a * 10 + line1.charAt(i) - '0'; //problem
                        i++;
                    }
                    i = 0;
                    int b = 0;
                    while (line2.charAt(i) != ' ') {
                        b += b * 10 + line2.charAt(i) - '0';
                        i++;
                    }
                    return (a < b ? -1 : 1);
                } else return cmp;
            }
        });

        // Here I am copying the sorted list in HashMap
        // using LinkedHashMap to preserve the insertion order
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }

    public static void main(String[] args) {
        HashMap<String, String> hmap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int queries = sc.nextInt();
        String[] indexes = new String[queries];
        String[] arr = new String[queries];
        for (int i = 0; i < queries; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            indexes[i] = a + " " + b;
            if (a == b)
                arr[i] = str.charAt(a - 1) + "";
            else arr[i] = Substring(str, a - 1, b - 1);
            char[] str1 = arr[i].toCharArray();
            Arrays.sort(str1);
            arr[i] = ReverseOrder(str1);
            hmap.put(indexes[i], arr[i]);
        }
        hmap = sortByValues(hmap);
        for (Map.Entry<String, String> entry : hmap.entrySet()) {
            //System.out.println(entry.getKey() + " " + entry.getValue());
            System.out.println(entry.getKey());
        }
    }
}