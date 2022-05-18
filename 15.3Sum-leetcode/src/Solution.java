import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {


    public List<List<Integer>> threeSum(int[] nums) {

        int len = nums.length;
        int i = 0, j = i + 1, k = len - 1;
        List<List<Integer>> list = new ArrayList<>();


        //1.To Check if the length >=3
        if (len < 3) {
            return list;
        }

        //2.Sort the array
        Arrays.sort(nums);

        //3.TOTAL 3 integers (produce)--> 0(ZERO)
        //Follow the constraints : cannot choose same index if its already in use by the other two
        for (i = 0; i < len - 2 && nums[i] <= 0; i++,j = i + 1,k = len - 1) {

            //condition to skip the same elements to avoid duplicate lists in result
            if (i == 0 || (nums[i - 1] != nums[i])) {
                while (j < k) {

                    if (nums[i] + nums[j] + nums[k] == 0) {
                        list.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[k])));
                        while (k > j && nums[j] == nums[j + 1]) j++;
                        while (k > j && nums[k] == nums[k - 1]) k--;
                        j++;k--;
                    } else if (nums[i] + nums[j] + nums[k] > 0) {
                        while (k > j && nums[k] == nums[k - 1]) k--;
                        k--;
                    } else {
                        while (k > j && nums[j] == nums[j + 1]) j++;
                        j++;
                    }
                }
            }

        }

        //3. return the List
        return list;
    }





    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int no = sc.nextInt();
        int[] arr = new int[no];

        for (int i = 0; i < no; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(new Solution().threeSum(arr));
    }
}
/*Testcase:
6
-1 0 1 2 -1 -4

~
[[-1,-1,2],[-1,0,1]]
 */