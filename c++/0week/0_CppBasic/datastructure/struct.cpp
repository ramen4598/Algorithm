#include<iostream>
#include<vector>
using namespace std;

struct Car{
	int a, b;
	double c, d, e;
};

void print(Car car){
	cout << car.a << " " << car.b << " " << car.c << " " << car.d << " " << car.e << '\n'; 
}

int main(){
	Car car = {1, 1, 1, 1, 1};
	print(car);
	vector<Car> sonata;
	sonata.push_back({1, 2, 3, 4, 5}); 
	sonata.push_back({1, 2, 3, 4, 6}); 
	sonata.push_back({}); 
	sonata.push_back({1, 3}); 
	for(Car car : sonata){
        print(car);
    }
	return 0;
}
/*
1 1 1 1 1
1 2 3 4 5
1 2 3 4 6
0 0 0 0 0
1 3 0 0 0
*/
