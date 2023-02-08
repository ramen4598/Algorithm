#include <bits/stdc++.h>
using namespace std;

namespace BO {
	void A() {
		cout << "난 BOA에요" << endl;
    }
}
 
namespace NO {
	void A() {
		cout << "난 NOA에요" << endl;
    }
}

void Local(){
	using namespace BO; // 지역
	A(); // 가능!
}

int main(void)
{
	Local(); // SUCESS !!
	// A(); // ERROR!!!	
	return 0;
}