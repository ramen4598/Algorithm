#include <iostream>
#include <vector>

using namespace std;

int main() {
    int N, L;
    cin >> N >> L;

    for (int length = L; length <= 100; ++length) {
        // N이 리스트의 길이에 대한 등차수열의 합으로 표현 가능한지 확인
        int sum = (length * (length - 1)) / 2;
        
        if ((N - sum) % length == 0 && (N - sum) / length >= 0) {
            // 등차수열의 시작 값 계산
            int start = (N - sum) / length;

            // 길이가 100보다 작거나 같은 경우 출력
            if (length <= 100) {
                for (int i = 0; i < length; ++i) {
                    cout << start + i << " ";
                }
                cout << endl;
                return 0;
            }
        }
    }

    // 길이가 100보다 크거나 수열이 없는 경우
    cout << -1 << endl;
    return 0;
}
