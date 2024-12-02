#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int n = 5;
int a[5] = {1, 2, 3, 4, 5}; 

int main() {
	for(int i = 0; i < n; i++){
		for(int j = i + 1; j < n; j++){
			for(int k = j + 1; k < n; k++){
				cout << a[i] << " " << a[j] << " " << a[k] << '\n';
			} 
		}
	}
	return 0;
}
/*
1 2 3
1 2 4
1 2 5
1 3 4
1 3 5
1 4 5
2 3 4
2 3 5
2 4 5
3 4 5
*/
