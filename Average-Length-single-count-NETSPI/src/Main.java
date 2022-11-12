import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int temp = sc.nextInt();
        int sum = 0 ;
        int sq_count = 0;
        while(temp != -1){
            list.add(temp);
            temp = sc.nextInt();

        }
        for(int i=0;i<list.size();i++){
            if(list.get(i) <= 9) {
                sq_count++;
            }
            if(i == list.size() - 1 && sq_count > 0){
                result.add(sq_count);
            }else if(list.get(i) > 9){
                if(sq_count > 0) {
                    result.add(sq_count);
                }
                sq_count = 0;
            }
        }
        for(int var : result)
            sum+=var;
        System.out.println(sum/result.size());
    }
}
/*
31
6
8
2
121
6
2
371
661
6
-1

 */