
import kotlin.math.min

class Solution {

    private companion object {
        const val NOT_FOUND = -1
    }

    fun minLength(input: IntArray, minSumDistinctValues: Int): Int {
        var back = 0
        var front = 0
        var sumDistinctValues: Long = 0
        var minLength = Integer.MAX_VALUE
        val valueToFrequency = IntArray(input.max() + 1)

        while (front < input.size && minLength > 1) {
            if (++valueToFrequency[input[front]] == 1) {
                sumDistinctValues += input[front]
            }

            while (back <= front && sumDistinctValues >= minSumDistinctValues) {
                minLength = min(minLength, front - back + 1)
                if (--valueToFrequency[input[back]] == 0) {
                    sumDistinctValues -= input[back]
                }
                ++back
            }
            ++front
        }

        return if (minLength != Integer.MAX_VALUE) minLength else NOT_FOUND
    }
}
