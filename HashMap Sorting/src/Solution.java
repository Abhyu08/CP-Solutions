import java.util.*;

/* you can directly sort key values using TreeMap /\ Treeset by addAll in MAP\SET  */

public class Solution {
    public static void main(String[] args) {
        try {
            HashMap<Integer, String> hmap = new HashMap();
            hmap.put(1, "Ac");
            hmap.put(2, "Cc");
            hmap.put(3, "Z");
            hmap.put(4, "Y");
            hmap.put(0, "P");
            hmap.put(18, "Q");
            hmap.put(18, "R");
            System.out.println("Before sorting :");
            Set set = hmap.entrySet();
            for (Object o : set) {
                Map.Entry me = (Map.Entry) o;
                System.out.println(me.getKey() + " " + me.getValue());
            }
            System.out.println("After Sorting :");
            Map<Integer, String> map = SortKeyByValues(hmap);
            Set set1 = map.entrySet();
            Iterator iterator1 = set.iterator();
            for (Object o : set1) {
                Map.Entry me = (Map.Entry) o;
                System.out.println(me.getKey() + " " + me.getValue());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    ///// Array not being sorted...
    public static HashMap SortKeyByValues(HashMap hmap) {
        List linkedList = new LinkedList(hmap.entrySet());
        //----------
        Collections.sort(linkedList, new Comparator() {
            public int compare(Object o1, Object o2) {
                String line1 = (String) ((Map.Entry) o1).getValue();
                String line2 = (String) ((Map.Entry) o2).getValue();

                //System.out.print("l1 = " + line1 + "\tl2= " + line2 + "\t");
              //  System.out.println(".compareTo -> " + line1.compareTo(line2));

                return ((Comparable) (((Map.Entry) o1).getValue())).compareTo((Comparable) ((Map.Entry) o2).getValue());
            }
        });
        HashMap hashMap = new LinkedHashMap();
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Map.Entry me = (Map.Entry) iterator.next();
            hashMap.put(me.getKey(), me.getValue());
            // System.out.println("Values : " + me.getValue() + "\tKey : " + me.getKey());
        }
        return hashMap;
    }
}
