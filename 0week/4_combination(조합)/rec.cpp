#include<iostream>
#include<vector>
using namespace std;

int n = 7, k = 4, a[7] = {1, 2, 3, 4, 5, 6, 7}; 

void print(vector<int> b){
	for(int i : b)cout << i << " ";
    cout << '\n';
}

void combi(int start, vector<int> b){
	if(b.size() == k){
		print(b);
		return; 
	}
	for(int i = start + 1; i < n; i++){
		b.push_back(a[i]);
		combi(i, b);
		b.pop_back();
   	}
	return; 
}

int main() {
	vector<int> b;
	combi(-1, b);
	return 0; 
}
/*
1 2 3 4 
1 2 3 5 
1 2 3 6 
1 2 3 7 
1 2 4 5 
1 2 4 6 
1 2 4 7 
1 2 5 6 
1 2 5 7 
1 2 6 7 
1 3 4 5 
1 3 4 6 
1 3 4 7 
1 3 5 6 
1 3 5 7 
1 3 6 7 
1 4 5 6 
1 4 5 7 
1 4 6 7 
1 5 6 7 
2 3 4 5 
2 3 4 6 
2 3 4 7 
2 3 5 6 
2 3 5 7 
2 3 6 7 
2 4 5 6 
2 4 5 7 
2 4 6 7 
2 5 6 7 
3 4 5 6 
3 4 5 7 
3 4 6 7 
3 5 6 7 
4 5 6 7 
*/
