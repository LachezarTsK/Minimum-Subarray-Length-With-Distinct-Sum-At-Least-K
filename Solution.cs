
using System;
using System.Collections.Generic;

public class Solution
{
    static readonly int NOT_FOUND = -1;

    public int MinLength(int[] input, int minSumDistinctValues)
    {
        int back = 0;
        long sumDistinctValues = 0;
        int minLength = int.MaxValue;
        int[] valueToFrequency = new int[input.Max() + 1];

        for (int front = 0; front < input.Length && minLength > 1; ++front)
        {
            if (++valueToFrequency[input[front]] == 1)
            {
                sumDistinctValues += input[front];
            }

            while (back <= front && sumDistinctValues >= minSumDistinctValues)
            {
                minLength = Math.Min(minLength, front - back + 1);
                if (--valueToFrequency[input[back]] == 0)
                {
                    sumDistinctValues -= input[back];
                }
                ++back;
            }
        }

        return minLength != int.MaxValue ? minLength : NOT_FOUND;
    }
}
