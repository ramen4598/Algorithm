#include <iostream>
#include <vector>
using namespace std;

//sort(first, last, *커스텀비교함수)
vector<int> a;
int b[5];
int main(){
	for(int i=5; i>=1; i--) b[i-1] =i;
	for(int i=5; i>=1; i--) a.push_back(i);
	//ascending order default
	sort(b, b+5);
	sort(a.begin(), a.end());
	for(int i : b) cout << i << ' ';
	cout << endl;
	for(int i : a) cout << i << ' ';
	cout << endl;
	
	//ascending order Explicitly
	sort(b, b+5, less<int>());
	sort(a.begin(),a.end(),less<int>());
	for(int i : b) cout << i << ' ';
	cout << endl;
	for(int i : a) cout << i << ' ';
	cout << endl;
	
	//decending order Explicitly
	sort(b, b+5, greater<int>());
	sort(a.begin(), a.end(), greater<int>());
	for(int i : b) cout << i << ' ';
	cout << endl;
	for(int i : a) cout << i << ' ';
	cout << endl;

	return 0;
}
/*
1 2 3 4 5 
1 2 3 4 5 
1 2 3 4 5 
1 2 3 4 5 
5 4 3 2 1 
5 4 3 2 1 
*/
