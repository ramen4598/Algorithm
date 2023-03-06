#include<iostream>
#include<vector>
using namespace std;

int main () {
	vector<int> a {1,2,3,3,3,4};
	cout <<"lower_bound(a.begin(), a.end(),3) : "<< &*lower_bound(a.begin(), a.end(), 3) << endl;
	cout << "a.begin() : "<< &*a.begin() << endl;
	cout << "a.begin() + 1 : " << &*(a.begin() + 1) << endl;

	cout << "&*lower_bound(a.begin(), a.end(), 3) - &*a.begin() : ";
	cout << &*lower_bound(a.begin(), a.end(), 3) - &*a.begin() << endl;
	cout << "lower_bound(a.begin(), a.end(), 3) - a.begin() : ";
	cout << lower_bound(a.begin(), a.end(), 3) - a.begin() << endl;

	cout << "(a.begin() + 2) - a.begin() : ";
	cout << (a.begin() + 2) - a.begin() << endl;
	return 0;
}
