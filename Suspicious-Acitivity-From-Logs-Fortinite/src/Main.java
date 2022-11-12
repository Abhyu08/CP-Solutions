import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine());
//            System.out.println("-> " + list.get(i));
        }
        int threshold = sc.nextInt();
        List<String> result = processLogs(list,threshold);

        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }

    }

    public static List<String> processLogs(List<String> logs, int threshold){
        HashMap<String , Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        for(int i=0;i<logs.size();i++){
            String[] user_id_splits = logs.get(i).split(" ");
            for(int j=0;j<user_id_splits.length;j++){
                map.put(user_id_splits[j] , map.getOrDefault(user_id_splits[j],0) + 1);
            }
        }
        for(Map.Entry<String,Integer> var : map.entrySet()){
            if(var.getValue() > threshold){
                result.add(var.getKey());
            }
        }
        Collections.sort(result);
        return result;
    }
}
/*
4
9 7 50
22 7 20
33 7 50
22 7 30
3

4
1 2 50
1 7 70
1 3 20
2 2 17
2

 */