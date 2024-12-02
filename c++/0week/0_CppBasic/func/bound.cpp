#include<iostream>
#include<vector>
using namespace std;

// return iterator
// Must only be used in an ordered array.
int main(){
	vector<int> a {1,2,3,3,3,4};
	// where the 3 is located. (count from 0)
	cout << lower_bound(a.begin(), a.end(), 3) - a.begin() << endl;
	// 2
	cout << upper_bound(a.begin(), a.end(), 3) - a.begin() << endl;
	// 5
	return 0;
}
