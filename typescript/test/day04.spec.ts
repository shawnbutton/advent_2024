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

        it('should return none if outside of grid', () => {
            const grid = buildGrid();
            expect(grid.valueAt(-1, 0)).toEqual('')
            expect(grid.valueAt(0, -1)).toEqual('')
            expect(grid.valueAt(3, 0)).toEqual('')
            expect(grid.valueAt(3, 0)).toEqual('')
        });


        xit('should get neighbours', () => {
            const grid = buildGrid();
            expect(grid.getNeighbours(1, 0)).toEqual([[0, 0, "A"], [0, 1, "D"], [1, 1, "E"], [2, 0, "C"], [2, 1, "F"]])
        })

    })

    it('should find all xmas', () => {
        const grid = loadGrid(testInput);
        // expect(grid.valueAt(1,1)).toEqual('S')
        expect(grid.doit1()).toEqual(18)
    })

    it('should find all x-mas', () => {
        const grid = loadGrid(testInput);
        // expect(grid.valueAt(1,1)).toEqual('S')
        expect(grid.doit2()).toEqual(9)
    })


})
