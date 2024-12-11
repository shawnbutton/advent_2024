import {doit1, parseLine} from "../src/day07";

const testInput = [
    '190: 10 19',
    '3267: 81 40 27',
    '83: 17 5',
    '156: 15 6',
    '7290: 6 8 6 15',
    '161011: 16 10 13',
    '192: 17 8 14',
    '21037: 9 7 18 13',
    '292: 11 6 16 20'
]

describe('Day 07', () => {

    it('should parse a line', () => {
        expect(parseLine('3267: 81 40 27')).toEqual({
            total: 3267,
            numbers: [81, 40, 27]
        })
    });


    xit('should run pass the example', () => {
        expect(doit1(testInput)).toEqual(3749);
    });

})
