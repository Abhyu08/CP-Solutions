
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Solution {
    public static void main(String[] args) {

        //First Method to sync Arraylist
        List AL = Collections.synchronizedList(new ArrayList<String>());
        AL.add("1");
        AL.add("2");
        AL.add("3");

        /*
        Second Method to sync (Thread safe)-->
         CopyOnWriteArrayList AL = new CopyOnWriteArrayList<String>();
        AL.add("1");
        AL.add("2");
        AL.add("3");
         */

        Iterator<String> iterator = AL.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}
