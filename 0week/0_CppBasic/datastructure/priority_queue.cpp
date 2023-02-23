#include<iostream>
#include<vector>
#include<queue>
#include<functional> //greater, less
using namespace std;

//vector를 greater<...>로 정렬한다. + queue는 back에서부터 출력한다 
//이에 sort()와는 반대의 차순으로 출력된다.
priority_queue<int, vector<int>, greater<int>> pq; 
priority_queue<int> pq2;
priority_queue<int, vector<int>, less<int>> pq3;

int main(){
	for(int i = 5; i>=1; i--){
		pq.push(i);
		pq2.push(i);
		pq3.push(i);
	}
	while(pq.size()){
		cout << pq.top() << " : " << pq2.top() << " : " << pq3.top() << '\n';
		pq.pop(); pq2.pop(); pq3.pop();
	}
	return 0;
}
/*
1 : 5 : 5
2 : 4 : 4
3 : 3 : 3
4 : 2 : 2
5 : 1 : 1
*/
