#include<iostream>
#include<vector>
using namespace std;

struct S{
	int x, y, z;
	//Overloading
	S(int X, int Y, int Z) : x(X), y(Y), z(Z) {}
	S(){x=-1; y=-1; z=-1;}
	bool operator < (const S & a) const{
		if(x== a.x){
			if(y == a.y) return z < a.z;
			return y < a.y;
		}
		return x < a.x;
	}
};

int main(){
	vector<S> v;

	v.push_back(S(1,2,3));
	v.push_back(S(10,20,30));
	v.push_back(S());

	cout << "v[0] : " << v[0].x << " " << v[0].y << " " << v[0].z << endl;
    cout << "v[1] : " << v[1].x << " " << v[1].y << " " << v[1].z << endl;
    cout << "v[2] : " << v[2].x << " " << v[2].y << " " << v[2].z << endl;

	cout << "v[0]<v[1] : " << (v[0]<v[1]) << '\n' ;

	return 0;
}
/*
v[0] : 1 2 3
v[1] : 10 20 30
v[2] : -1 -1 -1
v[0]<v[1] : 1
*/
