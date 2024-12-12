import {join} from "path";
import {readFileSync} from "fs";

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
    return numbers.reduce(
        (accum, current, index) => {
            if (index === 0) return [current]
            const withPlus = accum.map(s => s + current)
            const withTimes = accum.map(s => s * current)
            return [...withPlus, ...withTimes]
        }, [0]);
};

export const isAbleToMakeTotal = (line: string): boolean => {
    const parsed = parseLine(line)

    return allTotals(parsed.numbers)
        .some(number => {
            return number === parsed.total;
        })
}

export const doit1 = (testInput: string[]): number => {
    return testInput
        .filter(isAbleToMakeTotal)
        .map(parseLine)
        .map(parsed => parsed.total)
        .reduce((accum, current) => {
            return accum + current
        }, 0)
};

export const isAbleToMakeTotalWithThreeOps = (line: string): boolean => {
    const parsed = parseLine(line)

    return allTotalsWithThreeOps(parsed.numbers)
        .some(number => {
            return number === parsed.total;
        })
}

const countOccurrences = (str, char) => str.split(char).length - 1;

export const allTotalsWithThreeOps = (numbers: number[]) => {
    return numbers.reduce(
        (accum, current, index) => {
            if (index === 0) return [current]
            const withPlus = accum.map(s => s + current)
            const withTimes = accum.map(s => s * current)
            const withCombine = accum.map(s => Number('' + s + current))

            return [...withPlus, ...withTimes, ...withCombine]

        }, [0]);

};

export const doit2 = (testInput: string[]): number => {
    return testInput
        .filter(isAbleToMakeTotalWithThreeOps)
        .map(parseLine)
        .map(parsed => parsed.total)
        .reduce((accum, current) => {
            return accum + current
        }, 0)
};

const filePath = join(__dirname, 'day07.txt');
const fileContents = readFileSync(filePath, 'utf-8');
const lines = fileContents.split("\n")!.slice(0, -1);

const total1 = doit1(lines)
console.log(total1)
const total2 = doit2(lines)
console.log(total2)


