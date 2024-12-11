import {readFileSync} from 'fs';
import {join} from 'path';

export const doit1 = (testInput: string[]): number => {
    return -999;
};

export const parseLine = (line) => {
    const [first, rest] = line.split(":")

    const total = Number(first)
    const numbers = rest.split(" ")
        .slice(1)
        .map(Number)

    return {
        total,
        numbers
    }
};
