
#include <limits>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {

    static const int NOT_FOUND = -1;

public:
    int minLength(const vector<int>& input, int minSumDistinctValues) const {
        int back = 0;
        long long sumDistinctValues = 0;
        int minLength = numeric_limits<int>::max();
        vector<int> valueToFrequency(*ranges::max_element(input) + 1);

        for (int front = 0; front < input.size() && minLength > 1; ++front) {
            if (++valueToFrequency[input[front]] == 1) {
                sumDistinctValues += input[front];
            }

            while (back <= front && sumDistinctValues >= minSumDistinctValues) {
                minLength = min(minLength, front - back + 1);
                if (--valueToFrequency[input[back]] == 0) {
                    sumDistinctValues -= input[back];
                }
                ++back;
            }
        }

        return minLength != numeric_limits<int>::max() ? minLength : NOT_FOUND;
    }
};
