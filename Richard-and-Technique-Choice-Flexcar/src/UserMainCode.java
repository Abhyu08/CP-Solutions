import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class UserMainCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] efforts = new int[n];
        int[] benifits = new int[n];
        int available_efforts;

        for(int i=0;i<n;i++){
            efforts[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            benifits[i] = sc.nextInt();
        }
        available_efforts = sc.nextInt();

        System.out.println(new UserMainCode().maxBenefit(n,efforts,benifits,available_efforts));
    }

    public int maxBenefit(int input1, int[] input2 , int[] input3 , int input4){

        int result_fwd = 0;
        int result_bwd = 0;
        int[][] cmn_arr = new int[input1][2];

        for(int i=0;i<input1;i++){
            cmn_arr[i][0] = input2[i];
            cmn_arr[i][1] = input3[i];
        }


        Arrays.sort(cmn_arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] > o2[1]){
                    return -1;
                }else if(o1[1] == o2[1]){
                    return 0;
                }else{
                    return 1;
                }
            }
        });

        int curr_eff_left = input4;
        for(int i=0;i<input1;i++){
            if(curr_eff_left >= cmn_arr[i][0]){
                result_fwd+=cmn_arr[i][1];
                curr_eff_left-=cmn_arr[i][0];
            }
        }
        curr_eff_left = input4;
        for(int i=input1-1;i>=0;i--){
            if(curr_eff_left >= cmn_arr[i][0]){
                result_bwd+=cmn_arr[i][1];
                curr_eff_left-=cmn_arr[i][0];
            }
        }

        return Math.max(result_fwd,result_bwd);
    }

}
/*
4
10 10 10 10
10 11 12 15
20

3
10 20 10
10 20 11
20

 */