import {readFileSync} from 'fs';
import {join} from 'path';

export type Coordinate = [number, number]

export class Grid {
    constructor(private grid: string[][]) {
    }

    valueAt(x, y): string | undefined {
        if (x < 0 || x >= this.grid[0].length) return undefined
        if (y < 0 || y >= this.grid.length) return undefined
        return this.grid[y][x]
    }

    getNeighbours(x, y): [number, number, string][] {
        return [
            [x - 1, y - 1, this.valueAt(x - 1, y - 1)],
            [x - 1, y, this.valueAt(x - 1, y)],
            [x - 1, y + 1, this.valueAt(x - 1, y + 1)],
            [x, y - 1, this.valueAt(x, y - 1)],
            [x, y + 1, this.valueAt(x, y + 1)],
            [x + 1, y - 1, this.valueAt(x + 1, y - 1)],
            [x + 1, y, this.valueAt(x + 1, y)],
            [x + 1, y + 1, this.valueAt(x + 1, y + 1)]
        ].filter((neighbour): neighbour is [number, number, string] => {
            return neighbour[2] !== undefined
        })
    }

    getMatching(character, x, y) {
        this.getNeighbours(x, y)
            .filter(neighbour => {
                neighbour[2]
                }
            )

    }

    doit1() {

        for (let y = 0; y < this.grid.length; y++) {
            for (let x = 0; x < this.grid[y].length; x++) {
                const value = this.valueAt(x, y);
                if (value === 'X') {
                    const neighbours = this.getNeighbours(x, y)
                }
            }
        }


    }

}


export function loadGrid(testInput: string[]) {
    return new Grid(testInput.map(line => {
        return line.split('')
    }))
}

export function doit2(testInput: string[]) {

}


const filePath = join(__dirname, 'day04.txt');
const fileContent = readFileSync(filePath, 'utf-8').split("\n")!;

// console.log(doit1(fileContent))
// console.log(doit2(fileContent))
