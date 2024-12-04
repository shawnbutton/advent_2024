import {doit1, evaluate, getExpressions, someFunction} from '../src/day03';

const testInput = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"


describe('Day 03 part 1', () => {
    it('should find all expressions', () => {
        expect(getExpressions(testInput))
            .toEqual([
                'mul(2,4)',
                'mul(5,5)',
                'mul(11,8)',
                'mul(8,5)'
            ])
    })

    it('should evaluate an expression', () => {
        expect(evaluate('mul(2,4)')).toEqual(8)
    })

    it('should do it', () => {
        expect(doit1(testInput)).toEqual(161)
    })


})
