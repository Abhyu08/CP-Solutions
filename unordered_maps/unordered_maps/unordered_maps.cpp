// unordered_maps.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include<iostream>
#include<string>
#include <vector>
#include<unordered_map>
using namespace std;
int main() {

	unordered_map<string, int> map;
	map["apple"] = 15;
	map["banana"] = 7;
	map["pomogenerade"] = 15;
	map["sugar"] = 101;

	string item;
	cin >> item;
	if (map.count(item) == 0)
		cout << item << " Not available" << endl;
	else
		cout << item << " is available , and its cost is " << map[item] << endl;

	for (pair<string, int> item : map)
		cout << item.first << "-" << item.second << endl;

	return 0;
}