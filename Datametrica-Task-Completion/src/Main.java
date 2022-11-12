import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++)
            arr[i] = sc.nextInt();
        System.out.println(findMaxTasks(N,M,arr));
    }
    public static int findMaxTasks(int N , int M , int[] A){
        int count = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int var : A)
            list.add(var);
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            if(list.get(i) <= M ){
                count++;
                M += list.get(i);
            }
        }
        return count;
    }
}
/*
4 38
45 850  670 32

 */