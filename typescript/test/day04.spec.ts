import {Grid, loadGrid} from '../src/day04';

const testInput = [
    'MMMSXXMASM',
    'MSAMXMSMSA',
    'AMXSXMAAMM',
    'MSAMASMSMX',
    'XMASAMXAMM',
    'XXAMMXXAMA',
    'SMSMSASXSS',
    'SAXAMASAAA',
    'MAMMMXMMMM',
    'MXMXAXMASX'
]

const buildGrid = () => {
    const given = [
        ['A', 'B', 'C'],
        ['D', 'E', 'F'],
        ['G', 'H', 'I']
    ]
    return new Grid(given);
}
describe('Day 04', () => {
    describe('grid', () => {

        it('should get value', () => {
            const grid = buildGrid();
            expect(grid.valueAt(1, 1)).toEqual("E")
        })

        it('should get right', () => {
            const grid = buildGrid();
            expect(grid.right(1, 1)).toEqual("F")
        })

        it('should get left', () => {
            const grid = buildGrid();
            expect(grid.left(1, 1)).toEqual("D")
        })

        it('should get up', () => {
            const grid = buildGrid();
            expect(grid.up(1, 1)).toEqual("B")
        })

        it('should get down', () => {
            const grid = buildGrid();
            expect(grid.down(1, 1)).toEqual("H")
        })

        it('should get upleft', () => {
            const grid = buildGrid();
            expect(grid.upleft(1, 1)).toEqual("A")
        })

        it('should get upright', () => {
            const grid = buildGrid();
            expect(grid.upright(1, 1)).toEqual("C")
        })

        it('should get downleft', () => {
            const grid = buildGrid();
            expect(grid.downleft(1, 1)).toEqual("G")
        })

        it('should get downright', () => {
            const grid = buildGrid();
            expect(grid.downright(1, 1)).toEqual("I")
        })

        it('should return none if outside of grid', () => {
            const grid = buildGrid();
            expect(grid.up(0, 0)).toBeNull()
            expect(grid.down(0, 2)).toBeNull()
            expect(grid.left(0, 0)).toBeNull()
            expect(grid.right(2, 0)).toBeNull()
        });


        it('should get neighbours', () => {
            const grid = buildGrid();
            expect(grid.getNeighbours(1, 0)).toEqual([[0, 0, "A"], [0, 1, "D"], [1, 1, "E"], [2, 0, "C"], [2, 1, "F"]])
        })

    })


    it('should find all xmas', () => {
        const grid = loadGrid(testInput);
        // expect(grid.valueAt(1,1)).toEqual('S')
        expect(grid.doit1()).toEqual(18)
    })


})
