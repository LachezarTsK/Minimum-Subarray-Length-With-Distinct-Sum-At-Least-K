
import java.util.Arrays;

public class Solution {

    private static final int NOT_FOUND = -1;

    public int minLength(int[] input, int minSumDistinctValues) {
        int back = 0;
        long sumDistinctValues = 0;
        int minLength = Integer.MAX_VALUE;
        int[] valueToFrequency = new int[Arrays.stream(input).max().getAsInt() + 1];

        for (int front = 0; front < input.length && minLength > 1; ++front) {
            if (++valueToFrequency[input[front]] == 1) {
                sumDistinctValues += input[front];
            }

            while (back <= front && sumDistinctValues >= minSumDistinctValues) {
                minLength = Math.min(minLength, front - back + 1);
                if (--valueToFrequency[input[back]] == 0) {
                    sumDistinctValues -= input[back];
                }
                ++back;
            }
        }

        return minLength != Integer.MAX_VALUE ? minLength : NOT_FOUND;
    }
}
