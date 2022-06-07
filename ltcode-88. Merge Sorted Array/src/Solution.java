import java.util.Scanner;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] arr = new int[nums1.length];
        for(int i=0 , index1 = 0, index2 = 0;i<arr.length;i++){
            if(index1 < m && index2 < n){
                if(nums1[index1] < nums2[index2]){
                    arr[i] = nums1[index1];
                    index1++;
                }else{
                    arr[i] = nums2[index2];
                    index2++;
                }
            }else if(index1 < m){
                arr[i] = nums1[index1];
                index1++;
            }else{
                arr[i] = nums2[index2];
                index2++;
            }
        }
        for(int i=0;i<arr.length;i++)
            nums1[i] = arr[i];

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int no1 = sc.nextInt();
        int[] arr1 = new int[no1];

        for (int i = 0; i < no1; i++) {
            arr1[i] = sc.nextInt();
        }
        int no2 = sc.nextInt();
        int[] arr2 = new int[no2];

        for (int i = 0; i < no2; i++) {
            arr2[i] = sc.nextInt();
        }
        merge(arr1, no1, arr2, no2);

    }
}
/*
6
4 5 6 0 0 0
3
1 2 3

 */