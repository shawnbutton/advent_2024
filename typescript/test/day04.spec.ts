import {doit1, doit2} from '../src/day04';

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


describe('Day 04', () => {
    it('should find all xmas', () => {
        expect(doit1(testInput)).toEqual(18)
    })


})
