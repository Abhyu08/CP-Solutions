// minimum_difference.cpp : This file contains the 'main' function. Program execution begins and ends there.
//
#include<vector>
#include<algorithm>
#include<climits>
#include<iostream>
#include<unordered_set>
using namespace std;

class Solution {
public:
    pair<int, int> minDifference(vector<int> a, vector<int> b) {
        //Complete this method
        unordered_set<int> s;
        for (int num : b)
            s.insert(num);

        for (int num : a) {
            int less = num - 2;
            int more = num + 2;
            if (s.find(less) != s.end()) {
                return { num , less };
            }
            else if (s.find(more) != s.end()) {
                return { num , more };
            }
            else if (s.find(num) != s.end()) {
                return  { num , num };
            }
        }
        return {0,0};
    }
};
int main() {
    int n, m;
    cin>> n >> m;
    vector<int> a;
    vector<int> b;
    for (int i = 0,temp = 0; i < n; i++) {
        cin >> temp;
        a.push_back(temp);
    }
    for (int i = 0,temp = 0; i < n; i++) {
        cin >> temp;
        b.push_back(temp);
    }
    Solution sol;
    pair<int, int > result = sol.minDifference(a,b);
    cout << result.first <<" " << result.second << endl;
    return 0;
}