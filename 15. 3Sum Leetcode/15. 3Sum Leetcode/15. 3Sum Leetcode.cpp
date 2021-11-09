// 15. 3Sum Leetcode.cpp : This file contains the 'main' function. Program execution begins and ends there.
//
#include <iostream>
#include <algorithm>
#include <vector>
#include <set>
using namespace std;

class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& num) {
        vector<vector<int >> result;
        sort(num.begin(), num.end());
        if (num.size() < 3)
            return result;
        for (int i = 0; i < num.size()-3; i++) {
            int j = i + 1;
            int k = num.size() - 1;
            while (j < k) {
                int curr_sum = num[i] + num[j] + num[k];
                if (curr_sum == 0) {
                    result.push_back({ num[i] , num[j], num[k] });

                    j++;
                    k--;
                }
                else if (curr_sum > 0) {
                    k--;
                }
                else {
                    j++;
                }
            }
        }
        return result;
    }
};



int main()
{
    vector<int> nums;
    int no;
    cin >> no;
    for (int i = 0; i < no; i++) {
        int temp;
        cin >> temp;
        nums.push_back(temp);
    }
    Solution sol;
    vector<vector<int>> result = sol.threeSum(nums);
    for (auto number : result) {
        for (int num : number) {
            cout << num << " ";
        }
        cout << endl;
    }
    return 0;
}
