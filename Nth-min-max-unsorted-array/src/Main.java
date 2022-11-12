import java.util.*;

//Find Kth Largest/Smallest Element in a UN-Sorted-Array without Sorting
//Necessary to understand min/max-Heap concept as it is used beneath Priority Queue Collection
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {10, 60, 12, 8, 55, 100, 22, 78};
        PriorityQueue<Integer> q_min = new PriorityQueue<>();
        PriorityQueue<Integer> q_max = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.stream(arr).forEach(var -> {
            q_min.add(var);
            q_max.add(var);
        });

        int kth = sc.nextInt();
        while (kth-- >= 0 && !q_min.isEmpty()) {
            if(kth == 0) System.out.println( "Kth - min " + q_min.peek() + "  Kth-Max " + q_max.peek());
            q_min.poll();
            q_max.poll();
        }
    }
}