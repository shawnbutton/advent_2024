import {
    allTotals,
    allTotalsWithThreeOps,
    doit1,
    doit2,
    isAbleToMakeTotal,
    isAbleToMakeTotalWithThreeOps,
    parseLine
} from "../src/day07";

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

    it('should get all totals for numbers', () => {
        const expected = [
            (2 + 3) + 4,
            (2 * 3) + 4,
            (2 + 3) * 4,
            (2 * 3) * 4
        ];
        expect(allTotals([2, 3, 4])).toEqual(expected)
    });

    it('should find if operators meet total', () => {
        expect(isAbleToMakeTotal(testInput[0])).toBe(true)
        expect(isAbleToMakeTotal(testInput[1])).toBe(true)
        expect(isAbleToMakeTotal(testInput[2])).toBe(false)
        expect(isAbleToMakeTotal(testInput[3])).toBe(false)
        expect(isAbleToMakeTotal(testInput[4])).toBe(false)
        expect(isAbleToMakeTotal(testInput[5])).toBe(false)
        expect(isAbleToMakeTotal(testInput[6])).toBe(false)
        expect(isAbleToMakeTotal(testInput[7])).toBe(false)
        expect(isAbleToMakeTotal(testInput[8])).toBe(true)
    });


    it('should run pass the example 1', () => {
        expect(doit1(testInput)).toEqual(3749);
    });


    describe('part 2', () => {
        it('should get all totals for numbers', () => {
            const expected = [
                (2 + 3) + 4,
                (2 * 3) + 4,
                (23) + 4,
                (2 + 3) * 4,
                (2 * 3) * 4,
                (23) * 4,
                (2 + 34),
                (2 * 34),
                234
            ];
            expect(allTotalsWithThreeOps([2, 3, 4])).toEqual(expected)
        });


        it('should find if operators meet total', () => {
            // expect(isAbleToMakeTotalWithThreeOps(testInput[0])).toBe(true)
            // expect(isAbleToMakeTotalWithThreeOps(testInput[1])).toBe(true)
            // expect(isAbleToMakeTotalWithThreeOps(testInput[2])).toBe(false)
            // expect(isAbleToMakeTotalWithThreeOps(testInput[3])).toBe(true)
            expect(isAbleToMakeTotalWithThreeOps(testInput[4])).toBe(true)
            // expect(isAbleToMakeTotalWithThreeOps(testInput[5])).toBe(false)
            // expect(isAbleToMakeTotalWithThreeOps(testInput[6])).toBe(true)
            // expect(isAbleToMakeTotalWithThreeOps(testInput[7])).toBe(false)
            // expect(isAbleToMakeTotalWithThreeOps(testInput[8])).toBe(true)
        });

        it('should run pass the example 2', () => {
            expect(doit2(testInput)).toEqual(11387);
        });
    });

})
