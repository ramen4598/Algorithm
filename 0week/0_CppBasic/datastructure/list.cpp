#include<iostream>
#include<list>
using namespace std;

/*
//list
class Node {
public:
	int data;
	Node* next;
	Node(){
		data = 0;
		next = NULL;
	}
	Node(int data){
		this->data = data;
		this->next = NULL;
	}
};
*/

list<int> a;
void print(list<int> a){
	for(auto it : a) cout << it << " ";
	cout << endl;
}
int main(){
	for(int i=1; i<=3; i++)a.push_back(i);
	for(int i=1; i<=3; i++)a.push_front(i);

	auto it = a.begin();
	it++;
	a.insert(it, 100);
	print(a);

	it = a.begin();
	it++;
	a.erase(it);
	print(a);

	a.pop_front();
	a.pop_back();
	print(a);

	cout << a.front() << " : " << a.back() << endl;
	a.clear();
	return 0;
}
/*
3 100 2 1 1 2 3 
3 2 1 1 2 3 
2 1 1 2 
2 : 2
*/
