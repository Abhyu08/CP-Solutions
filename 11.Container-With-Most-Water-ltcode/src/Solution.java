import java.util.Scanner;

class Solution {
    public static int maxArea(int[] height) {
        int len = height.length;
        int left = 0, right = len - 1;
        int maxWaterCapacity = 0, noOfContainers = right - left;
        for (int i = 0; i < len && left < right; i++, noOfContainers = right - left) {
            int waterCapacity = noOfContainers * Math.min(height[left], height[right]);
            maxWaterCapacity = Math.max(maxWaterCapacity, waterCapacity);
//            System.out.println("left=" + left + " right:" + right + " capacity : " + waterCapacity);
//            System.out.println("maxWaterCapacity : " + maxWaterCapacity);
            if (height[left] < height[right]) {
                left++;
            } else if (height[left] > height[right]) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return maxWaterCapacity;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int no = sc.nextInt();
        int[] arr = new int[no];

        for (int i = 0; i < no; i++)
            arr[i] = sc.nextInt();

        System.out.println(maxArea(arr));
    }
}
/*
9
1 8 6 2 5 4 8 3 7

2
1 1

 */