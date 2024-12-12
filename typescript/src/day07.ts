export const doit1 = (testInput: string[]): number => {
    return -999;
};

export const parseLine = (line) => {
    const [first, rest] = line.split(":")

    const total = Number(first)
    const numbers = rest
        .split(" ")
        .slice(1)
        .map(Number)

    return {
        total,
        numbers
    }
}

export const allTotals = (numbers: number[]) => {
    let allFormulas = numbers.reduce(
        (accum, current, index) => {
            if (index === 0) return [current]
            const withPlus = accum.map(s => s + current)
            const withTimes = accum.map(s => s * current)
            return [...withPlus, ...withTimes]
        }, [0]);

    return allFormulas;
};

export const isAbleToMakeTotal = (line: string): boolean => {
    const parsed = parseLine(line)

    return allTotals(parsed.numbers)
        .some(number => {
            return number === parsed.total;
        })

}


