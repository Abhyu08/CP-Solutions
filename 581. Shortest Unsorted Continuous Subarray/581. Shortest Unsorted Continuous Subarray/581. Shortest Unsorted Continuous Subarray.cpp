// 581. Shortest Unsorted Continuous Subarray.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include<iostream>
#include<string>
#include<vector>
#include<unordered_map>
using namespace std;

class Solution {
public:
    int findUnsortedSubarray(vector<int>& list) {

        int min_no =   10e7;
        int max_no =  -10e7;
        int index_min = 0;
        int index_max = 0;
        int result = 0;
        for (int i = 1 , j=list.size()-1 ; i < list.size() && j > 0 ; i++ , j--) {
            if (list[i] < list[i - 1]) {
                min_no = min(min_no , list[i]);
                index_min = i; 
            }
            if (list[j] < list[j - 1]) {
                max_no = max(max_no, list[j-1]);
                index_max = j-1;
            }
        }
        int min_index = -1;
        int max_index = -1;
        for (int i = 0; i < list.size();i++) {
            
            if (min_index == -1 && min_no != 10e7) {
                if (min_no < list[i])
                    min_index = i; 
            }
            if ( max_no != -10e7) {
                if (max_no > list[i])
                    max_index = i;
            }
        }
        if (min_no == 10e7 && max_no == -10e7) {
            result = 0;
        }
        else if (min_no == 10e7) {
            result = abs(index_max - max_index);
        }
        else if (max_no == -10e7) {
            result = abs(index_min - min_index);
        }
        else {
            result = abs(max_index - min_index) + 1;
        }
        return result;
    }
};





int main()
{
    int n,temp;
    cin >> n;
    vector<int> list;
    for(int i=0;i<n;i++){
        cin >> temp;
        list.push_back(temp);
    }
    Solution sol;
    int result = sol.findUnsortedSubarray(list);
    cout << result << endl;
        
}
