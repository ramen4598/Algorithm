#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

const int MAX_SIZE = 20;

vector<int> calculateMaxSum(const vector<int>& larger, const vector<int>& smaller) {
    vector<int> sums;
    int gap = larger.size() - smaller.size();

    for (int i = 0; i <= gap; i++) {
        int sum = 0;
        for (size_t j = 0; j < smaller.size(); j++) {
            sum += smaller[j] * larger[j + i];
        }
        sums.push_back(sum);
    }

    return sums;
}

int findMaxSum(vector<int>& a, vector<int>& b) {
    vector<int> vec;

    if (a.size() > b.size()) 
        vec = calculateMaxSum(a, b);
    else 
        vec = calculateMaxSum(b, a);

    return *max_element(vec.begin(), vec.end());
}

int main() {
    int T;
    cin >> T;

    for (int test_case = 1; test_case <= T; ++test_case) {
        int n, m;
        cin >> n >> m;

        vector<int> a(n), b(m);

        for (int& ai : a) cin >> ai;
        for (int& bi : b) cin >> bi;

        cout << "#" << test_case << " " << findMaxSum(a, b) << "\n";
    }

    return 0;
}
