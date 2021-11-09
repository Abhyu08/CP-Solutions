
#include<iostream>
#include<string>
#include<vector>
#include<unordered_map>
using namespace std;

class Solution {
public:
	int longestMountain(vector<int>& list) {

		int n = list.size();
		int max_peak_length = 0;
		for (int i = 1; i < n - 1;) {
			int length = 1;
			if (list[i] > list[i - 1] && list[i] > list[i + 1]) {
				int pre = i;
				while (pre > 0 && list[pre] > list[pre - 1]) { // inc
					pre--;
					length++;
				}

				while (i < n - 1 && list[i] >  list[i + 1]) { //desc
					i++;
					length++;
				}
				max_peak_length = max(max_peak_length, length);
			}
			else
				i++;

		}
		return max_peak_length;
	}
};

int main() {

	int n;
	cin >> n;
	vector<int> list;
	for (int i = 0, temp = 0; i < n; i++) {
		cin >> temp;
		list.push_back(temp);
	}
	Solution sol;
	int max_peak_length = sol.longestMountain(list);
	cout << max_peak_length << endl;
	return 0;
}