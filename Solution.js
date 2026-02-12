
/**
 * @param {number[]} input
 * @param {number} minSumDistinctValues
 * @return {number}
 */
var minLength = function (input, minSumDistinctValues) {
    let back = 0;
    let sumDistinctValues = 0;
    let minLength = Number.MAX_SAFE_INTEGER;

    const NOT_FOUND = -1;
    const valueToFrequency = new Array(Math.max(...input) + 1).fill(0);

    for (let front = 0; front < input.length && minLength > 1; ++front) {
        if (++valueToFrequency[input[front]] === 1) {
            sumDistinctValues += input[front];
        }

        while (back <= front && sumDistinctValues >= minSumDistinctValues) {
            minLength = Math.min(minLength, front - back + 1);
            if (--valueToFrequency[input[back]] === 0) {
                sumDistinctValues -= input[back];
            }
            ++back;
        }
    }

    return minLength !== Number.MAX_SAFE_INTEGER ? minLength : NOT_FOUND;
};
