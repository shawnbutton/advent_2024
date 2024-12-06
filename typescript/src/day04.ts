import {readFileSync} from 'fs';
import {join} from 'path';

export type Coordinate = [number, number]

export class Grid {
    constructor(private grid: string[][]) {
    }

    valueAt(x, y): string | null {
        if (x < 0 || x >= this.grid[0].length) return null
        if (y < 0 || y >= this.grid.length) return null
        return this.grid[y][x]
    }

    right(x, y) {
        return this.valueAt(x + 1, y)
    }

    left(x: number, y: number) {
        return this.valueAt(x - 1, y)
    }

    up(x: number, y: number) {
        return this.valueAt(x, y - 1)
    }

    down(x: number, y: number) {
        return this.valueAt(x, y + 1)
    }

    upleft(x: number, y: number) {
        return this.valueAt(x - 1, y - 1)
    }

    upright(x: number, y: number) {
        return this.valueAt(x + 1, y - 1)
    }

    downleft(x: number, y: number) {
        return this.valueAt(x - 1, y + 1)
    }

    downright(x: number, y: number) {
        return this.valueAt(x + 1, y + 1)
    }

    getNeighbours(x, y) {
        const neighbours = [
            [x - 1, y - 1, this.valueAt(x - 1, y - 1)],
            [x - 1, y, this.valueAt(x - 1, y)],
            [x - 1, y + 1, this.valueAt(x - 1, y + 1)],
            [x, y - 1, this.valueAt(x, y - 1)],
            [x, y + 1, this.valueAt(x, y + 1)],
            [x + 1, y - 1, this.valueAt(x + 1, y - 1)],
            [x + 1, y, this.valueAt(x + 1, y)],
            [x + 1, y + 1, this.valueAt(x + 1, y + 1)]
        ].filter( neighbour => {
            return neighbour[2] != null
        })

        return neighbours
    }

    doit1() {


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
