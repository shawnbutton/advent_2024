import {readFileSync} from 'fs';
import {join} from 'path';


export function someFunction(): string {
    return 'expectation'
}

export function getExpressions(testInput: string) {
    const pattern = /mul\(\d+,\d+\)/g;
    return testInput.match(pattern);
}

export function getExpressionsWithEnablers(testInput: string) {
    const pattern = /mul\(\d+,\d+\)|do\(\)|don't\(\)/g;
    return testInput.match(pattern);
}

export function evaluate(testInput: string) {
    if (testInput === 'do()') return -1
    if (testInput === 'don\'t()') return -2

    const first = testInput.match(/mul\((\d+),/);
    const firstNumber = first ? parseInt(first[1], 10) : 0;
    const second = testInput.match(/,(\d+)\)/);
    const secondNumber = second ? parseInt(second[1], 10) : 0;

    return firstNumber * secondNumber
}

export function doit1(testInput: string) {
    return getExpressions(testInput)!
        .map(evaluate)
        .reduce((sum, current) => sum + current, 0)
}

export function doit2(testInput: string) {
    const expressions = getExpressionsWithEnablers(testInput)!

    let on = true

    return expressions
        .map(evaluate)
        .reduce((sum, current) => {
            if (current === -1) {
                on = true
                return sum
            }

            if (current === -2) {
                on = false
                return sum
            }

            if (on) return sum + current

            return sum
        }, 0)
}


const filePath = join(__dirname, 'day03.txt');
const fileContent = readFileSync(filePath, 'utf-8');

console.log(doit1(fileContent))
console.log(doit2(fileContent))
