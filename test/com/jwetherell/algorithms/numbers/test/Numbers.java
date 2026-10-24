package com.jwetherell.algorithms.numbers.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.Test;

import com.jwetherell.algorithms.numbers.Integers;
import com.jwetherell.algorithms.numbers.Longs;

public class Numbers {

    private static final Random RANDOM = new Random();

    @Test
    public void testPowerOf2() {
        int is = 256;
        int isNot = 1673;

        boolean isPowOf2is = Integers.powerOfTwoUsingBits(is);
        boolean isPowOf2isNot = Integers.powerOfTwoUsingBits(isNot);
        assertTrue(isPowOf2is, "Is power of 2 using bits error");
        assertFalse(isPowOf2isNot, "Is power of 2 using bits error");

        isPowOf2is = Integers.powerOfTwoUsingLog(is);
        isPowOf2isNot = Integers.powerOfTwoUsingLog(isNot);
        assertTrue(isPowOf2is, "Is power of 2 using logarithm error");
        assertFalse(isPowOf2isNot, "Is power of 2 using logarithm error");

        isPowOf2is = Integers.powerOfTwoUsingLoop(is);
        isPowOf2isNot = Integers.powerOfTwoUsingLoop(isNot);
        assertTrue(isPowOf2is, "Is power of 2 using loops error");
        assertFalse(isPowOf2isNot, "Is power of 2 using loops error");

        isPowOf2is = Integers.powerOfTwoUsingRecursion(is);
        isPowOf2isNot = Integers.powerOfTwoUsingRecursion(isNot);
        assertTrue(isPowOf2is, "Is power of 2 using recursion error");
        assertFalse(isPowOf2isNot, "Is power of 2 using recursion error");
    }

    @Test
    public void testIntegerToBinaryString() {
        int a = Math.abs(RANDOM.nextInt());
        String check = Integer.toBinaryString(a);

        String result1 = Integers.toBinaryUsingBigDecimal(a);
        assertTrue((check.equals(result1)), "toBinary using BigDecimal error. random="+a+" expected=\n"+check+"\ngot=\n"+result1+"\n");

        String result2 = Integers.toBinaryUsingDivideAndDouble(a);
        assertTrue((check.equals(result2)), "toBinary using BigDecimal error. random="+a+" expected=\n"+check+"\ngot="+result2+"\n");

        String result3 = Integers.toBinaryUsingDivideAndModulus(a);
        assertTrue((check.equals(result3)), "toBinary using BigDecimal error. random="+a+" expected=\n"+check+"\ngot="+result3+"\n");

        String result4 = Integers.toBinaryUsingShiftsAndModulus(a);
        assertTrue((check.equals(result4)), "toBinary using BigDecimal error. random="+a+" expected=\n"+check+"\ngot="+result4+"\n");
    }

    @Test
    public void testLongToBinaryString() {
        long a = Math.abs(RANDOM.nextLong());
        String check = Long.toBinaryString(a);

        String result1 = Longs.toBinaryUsingBigDecimal(a);
        assertTrue((check.equals(result1)), "toBinary using BigDecimal error. random="+a+" expected=\n"+check+"\ngot=\n"+result1+"\n");

        String result2 = Longs.toBinaryUsingDivideAndModulus(a);
        assertTrue((check.equals(result2)), "toBinary using BigDecimal error. random="+a+" expected=\n"+check+"\ngot=\n"+result2+"\n");

        String result3 = Longs.toBinaryUsingShiftsAndModulus(a);
        assertTrue((check.equals(result3)), "toBinary using BigDecimal error. random="+a+" expected=\n"+check+"\ngot=\n"+result3+"\n");
    }

    @Test
    public void testToEnglish() {
        int a = -1001; 
        String check = "negative one-thousand one";
        String english = Integers.toEnglish(a);
        assertTrue((check.equals(english)), "toEnglish error. a="+a+" expected="+check+" got="+english);

        a = -1;
        check = "negative one";
        english = Integers.toEnglish(a);
        assertTrue((check.equals(english)), "toEnglish error. a="+a+" expected="+check+" got="+english);

        a = 0;
        check = "zero";
        english = Integers.toEnglish(a);
        assertTrue((check.equals(english)), "toEnglish error. a="+a+" expected="+check+" got="+english);

        a = 199;
        check = "one-hundred ninety-nine";
        english = Integers.toEnglish(a);
        assertTrue((check.equals(english)), "toEnglish error. a="+a+" expected="+check+" got="+english);

        a = Integer.MAX_VALUE; // 2,147,483,647
        check = "two-billion one-hundred forty-seven-million four-hundred eighty-three-thousand six-hundred forty-seven";
        english = Integers.toEnglish(a);
        assertTrue((check.equals(english)), "toEnglish error. a="+a+" expected="+check+" got="+english);

        a = Integer.MIN_VALUE+1; // -2,147,483,647
        check = "negative two-billion one-hundred forty-seven-million four-hundred eighty-three-thousand six-hundred forty-seven";
        english = Integers.toEnglish(a);
        assertTrue((check.equals(english)), "toEnglish error. a="+a+" expected="+check+" got="+english);
    }
}
