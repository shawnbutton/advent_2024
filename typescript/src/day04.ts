import {readFileSync} from 'fs';
import {join} from 'path';


export function someFunction(): string {
    return 'expectation'
}

export function doit1(testInput: string[]) {

}

export function doit2(testInput: string[]) {

}


const filePath = join(__dirname, 'day04.txt');
const fileContent = readFileSync(filePath, 'utf-8').split("\n")!;

console.log(doit1(fileContent))
console.log(doit2(fileContent))
