package math;

import java.util.HashMap;
import java.util.Map;

/**
 * 1) 要注意判断符号;
 * 2) 要注意整数范围 Integer.MIN_VALUE;
 */
public class Leet166 {
    public String fractionToDecimal(int numerator, int denominator) {
        String result = "";
        if (denominator == 0) {
            return result;
        }

        long num = (long) numerator, den = (long) denominator;
        //判断两个数的积小于零
        if ((num * den < 0)) {
            result = "-" + result;
        }
        num = Math.abs(num);
        den = Math.abs(den);
        long value = num / den;
        result += value;
        long remainder = num - den * value;
        if (remainder == 0) {
            return result;
        }

        result += ".";
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        int recIndex = result.length();
        map.put(remainder, recIndex++);
        while (remainder != 0) {
            remainder *= 10;
            value = remainder / den;
            result += value;
            remainder = remainder - value * den;
            if (!map.containsKey(remainder)) {
                map.put(remainder, recIndex++);
            } else {
                result = new StringBuilder(result).insert(map.get(remainder), "(").append(")").toString();
                break;
            }
        }
        return result;
    }
}
