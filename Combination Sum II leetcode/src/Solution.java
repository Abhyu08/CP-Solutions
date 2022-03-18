import java.util.*;

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
    public void combination_Sum2(int[] candidates, int position, int[] dp, int target, ArrayList<Integer> list, List<List<Integer>> result) {
        if (target < 0 || position > candidates.length) {
            return;
        } else if (target == 0) {
//            int prev = list.get(0);
//            for (int var : list) {
//                if (prev > var) {
//                    return;
//                } else
//                    prev = var;
//            }
//            if (!result.contains(list))
            result.add(new ArrayList<>(list));
        } else {
            for (int i = position; i < candidates.length; i++) {
                if (target - candidates[i] < 0)
                    continue;
                else if (i == position || candidates[i] != candidates[i - 1]) {
                    list.add(candidates[i]);
                    combination_Sum2(candidates, i + 1, dp, target - candidates[i], list, result);
                    list.remove(list.size() - 1);
                }
            }
        }
    }


    //Main function
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int[] dp = new int[candidates.length];
        // HashSet<List<Integer>> result = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        //combination_Sum(candidates, dp, target, 0, new ArrayList<Integer>(), result);
        Arrays.sort(candidates);
        combination_Sum2(candidates, 0, dp, target, new ArrayList<>(), result);
        //return convertSetToList(result);
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
        List<List<Integer>> result = sl.combinationSum2(arr, target);
        System.out.println(result);
    }


}
/*
7
10 1 2 7 6 1 5
8

5
2 5 2 1 2
5

1
1
1

2
1 2
3

3
1 2 3
6

7
10 1 2 7 6 1 5
8

100
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
30

 */
