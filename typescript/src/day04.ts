import {readFileSync} from 'fs';
import {join} from 'path';

export type Coordinate = [number, number]

export class Grid {
    constructor(private grid: string[][]) {
    }

    valueAt(x, y): string | '' {
        if (x < 0 || x >= this.grid[0].length) return ''
        if (y < 0 || y >= this.grid.length) return ''
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
        return this.getNeighbours(x, y)
            .filter(neighbour => {
                    return character === neighbour[2]
                }
            )
    }

    doit1
    () {
        let totalXmas = 0

        for (let y = 0; y < this.grid.length; y++) {
            for (let x = 0; x < this.grid[y].length; x++) {
                const value = this.valueAt(x, y);
                if (value === 'X') {
                    let allPossible = [
                        this.valueAt(x + 1, y) + this.valueAt(x + 2, y) + this.valueAt(x + 3, y), // right
                        this.valueAt(x - 1, y) + this.valueAt(x - 2, y) + this.valueAt(x - 3, y), // left
                        this.valueAt(x, y - 1) + this.valueAt(x, y - 2) + this.valueAt(x, y - 3), // up
                        this.valueAt(x, y + 1) + this.valueAt(x, y + 2) + this.valueAt(x, y + 3), // down
                        this.valueAt(x + 1, y + 1) + this.valueAt(x + 2, y + 2) + this.valueAt(x + 3, y + 3), // downright
                        this.valueAt(x - 1, y + 1) + this.valueAt(x - 2, y + 2) + this.valueAt(x - 3, y + 3), // downleft
                        this.valueAt(x + 1, y - 1) + this.valueAt(x + 2, y - 2) + this.valueAt(x + 3, y - 3), // upright
                        this.valueAt(x - 1, y - 1) + this.valueAt(x - 2, y - 2) + this.valueAt(x - 3, y - 3), // upleft
                    ];
                    const xmas = allPossible
                        .filter(possible => {
                        return possible === 'MAS'
                    } )

                    totalXmas += xmas.length
                }
            }
        }

        return totalXmas

    }

    doitTOOMUCH() {
        let totalXmas = 0

        for (let y = 0; y < this.grid.length; y++) {
            for (let x = 0; x < this.grid[y].length; x++) {
                const value = this.valueAt(x, y);
                if (value === 'X') {
                    const matchingM = this.getMatching("M", x, y)

                    const matchingA = matchingM.flatMap(match => {
                        const matching = this.getMatching("A", match[0], match[1]);
                        return matching
                    })

                    const matchingS = matchingA.flatMap(match => {
                        const matching = this.getMatching("S", match[0], match[1]);
                        return matching
                    })

                    totalXmas += matchingS.length
                }
            }
        }

        return totalXmas

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

const grid = loadGrid(fileContent)

console.log(grid.doit1())
// console.log(doit2(fileContent))
