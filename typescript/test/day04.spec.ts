import {doit1, Grid} from '../src/day04';

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

    })


    xit('should find all xmas', () => {
        expect(doit1(testInput)).toEqual(18)
    })


})
