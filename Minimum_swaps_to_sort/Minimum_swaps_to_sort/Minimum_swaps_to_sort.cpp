// Minimum_swaps_to_sort.cpp : This file contains the 'main' function. Program execution begins and ends there.
//
// { Driver Code Starts
#include<stdc++.h>
using namespace std;

// } Driver Code Ends


class Solution
{
public:
	//Function to find the minimum number of swaps required to sort the array. 
	int minSwaps(vector<int>& nums)
	{
		int cnt = 0;
		vector<int> sorted = nums;
		map<int, int> maps;
		sort(sorted.begin(), sorted.end());
		for (int i = 0; i < sorted.size(); i++) {
			maps[sorted[i]] = i;
		}
		for (int i = 0,temp=0; i < nums.size(); i++) {
			if (sorted[i] != nums[i]){
				while (sorted[i] != nums[i]) {
					int index = maps[nums[i]];
					temp = nums[index];
					nums[maps[nums[i]]] = nums[i]; 
					nums[i] = temp;
					cnt++;
				}
		    }
			
		}
		return cnt;
	}
};
/*
9
7 16 14 17 6 9 5 3 18
*/

// { Driver Code Starts.
int main() {

		int n;
		cin >> n;
		vector<int>nums(n);
		for (int i = 0; i < n; i++)
			cin >> nums[i];
		Solution obj;
		int ans = obj.minSwaps(nums);
		cout << ans << "\n";
	return 0;
}  // } Driver Code Ends