#include<iostream>
#include<vector>
using namespace std;

//iterator erase (const_iterator first, const_iterator last);
int main(){
	vector<int> s {4, 3, 3, 5, 1, 2, 3};
	s.erase(unique(s.begin(), s.end()), s.end());
	for(int i : s) cout << i << " ";
	cout << endl;

	vector<int> s2 {4, 3, 3, 5, 1, 2, 3};
	sort(s2.begin(), s2.end());
	s2.erase(unique(s2.begin(), s2.end()), s2.end());
	for(int i : s2) cout << i << " ";
	cout << endl;

	return 0;
}
/*
4 3 5 1 2 3
1 2 3 4 5
*/
