
package main

import (
    "math"
    "slices"
)

const NOT_FOUND = -1

func minLength(input []int, minSumDistinctValues int) int {
    back := 0
    front := 0
    var sumDistinctValues int64 = 0
    minLength := math.MaxInt
    valueToFrequency := make([]int, slices.Max(input) + 1)

    for front < len(input) && minLength > 1 {
        valueToFrequency[input[front]]++
        if valueToFrequency[input[front]] == 1 {
            sumDistinctValues += int64(input[front])
        }

        for back <= front && sumDistinctValues >= int64(minSumDistinctValues) {
            minLength = min(minLength, front-back + 1)
            valueToFrequency[input[back]]--
            if valueToFrequency[input[back]] == 0 {
                sumDistinctValues -= int64(input[back])
            }
            back++
        }
        front++
    }

    if minLength != math.MaxInt {
        return minLength
    }
    return NOT_FOUND
}
