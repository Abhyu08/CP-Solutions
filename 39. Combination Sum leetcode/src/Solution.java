import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class Solution {

    /*
    //recursion
    public void combination_Sum(int[] candidates, int[] dp, int target, int sum, ArrayList<Integer> list, List<List<Integer>> result) {
        if (sum > target) {
            return;
        } else if (sum == target) {
            //System.out.println("Regular List -->" + list);
            int prev = list.get(0);
            for (int var : list) {
                if (prev > var) {
                    return;
                } else
                    prev = var;
            }
            result.add(new ArrayList<Integer>());
            int index = result.size() - 1;
            for (int var : list) {
                result.get(index).add(var);
            }
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            if (sum + candidates[i] > target)
                continue;
            list.add(candidates[i]);
            combination_Sum(candidates, dp, target, sum + candidates[i], list, result);
            list.remove(list.size() - 1);
        }
    }
*/
    public void combination_Sum2(int[] candidates, int[] dp, int target, ArrayList<Integer> list, List<List<Integer>> result) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            int prev = list.get(0);
            for (int var : list) {
                if (prev > var) {
                    return;
                } else
                    prev = var;
            }
            result.add(new ArrayList<Integer>());
            int index = result.size() - 1;
            for (int var : list) {
                result.get(index).add(var);
            }
        } else {
            for (int i = 0; i < candidates.length; i++) {
                if (target - candidates[i] < 0)
                    continue;
                list.add(candidates[i]);
                combination_Sum2(candidates, dp, target - candidates[i], list, result);
                list.remove(list.size() - 1);
            }
        }
    }

    //Main function
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int[] dp = new int[candidates.length];
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //combination_Sum(candidates, dp, target, 0, new ArrayList<Integer>(), result);
        combination_Sum2(candidates, dp, target, new ArrayList<Integer>(), result);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int target = sc.nextInt();
        Solution sl = new Solution();
        List<List<Integer>> result = sl.combinationSum(arr, target);
        System.out.println(result);
    }
}
/*
3
2 3 5
8

4
2 4 6 8
8

4
2 3 6 7
7

2
7 14
300

 */