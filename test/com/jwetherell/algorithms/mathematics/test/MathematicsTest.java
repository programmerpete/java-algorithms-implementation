package com.jwetherell.algorithms.mathematics.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

import org.junit.jupiter.api.Test;

import com.jwetherell.algorithms.mathematics.Distance;
import com.jwetherell.algorithms.mathematics.Division;
import com.jwetherell.algorithms.mathematics.Knapsack;
import com.jwetherell.algorithms.mathematics.Multiplication;
import com.jwetherell.algorithms.mathematics.Primes;

public class MathematicsTest {

    private static final int MIN = 1;
    private static final int MAX = 1000;

    private static final Random RANDOM = new Random();

    private static int nextRandomInt(int min, int max) {
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        return RANDOM.nextInt((max - min) + 1) + min;
    }

    @Test
    public void multiplication() {
        int a = Math.abs(nextRandomInt(MIN, MAX));
        int b = Math.abs(nextRandomInt(MIN, MAX));
        // positive * positive
        {
            long result = Multiplication.multiplyUsingLoop(a, b);
            long check = Multiplication.multiplication(a, b);
            assertTrue((result == check), "Multiplication using a loop. a=" + a + " b=" + b + " result=" + result + " check=" + check);

            result = Multiplication.multiplyUsingRecursion(a, b);
            check = Multiplication.multiplication(a, b);
            assertTrue((result == check), "Multiplication using recursion. a=" + a + " b=" + b + " result=" + result + " check=" + check);

            result = Multiplication.multiplyUsingShift(a, b);
            check = Multiplication.multiplication(a, b);
            assertTrue((result == check), "Multiplication using shifts. a=" + a + " b=" + b + " result=" + result + " check=" + check);

            result = Multiplication.multiplyUsingLogs(a, b);
            check = Multiplication.multiplication(a, b);
            assertTrue((result == check), "Multiplication using logs. a=" + a + " b=" + b + " result=" + result + " check=" + check);

            result = Integer.parseInt(Multiplication.multiplyUsingFFT(Integer.toString(a), Integer.toString(b)));
            check = Multiplication.multiplication(a, b);
            assertTrue((result == check), "Multiplication using FFT. a=" + a + " b=" + b + " result=" + result + " check=" + check);

            result = Integer.parseInt(Multiplication.multiplyUsingLoopWithStringInput(Integer.toString(a), Integer.toString(b)));
            check = Multiplication.multiplication(a, b);
            assertTrue((result == check), "Multiplication using loop with string input. a=" + a + " b=" + b + " result=" + result + " check=" + check);

            result = Multiplication.multiplyUsingLoopWithIntegerInput(a, b);
            check = Multiplication.multiplication(a, b);
            assertTrue((result == check), "Multiplication using loop with int input. a=" + a + " b=" + b + " result=" + result + " check=" + check);
        }
        // negative * positive
        a *= -1;
        {
            long result = Multiplication.multiplyUsingLoop(a, b);
            long check = Multiplication.multiplication(a, b);
            assertTrue((result == check), "Multiplication using a loop. a=" + a + " b=" + b + " result=" + result + " check=" + check);

            result = Multiplication.multiplyUsingRecursion(a, b);
            check = Multiplication.multiplication(a, b);
            assertTrue((result == check), "Multiplication using recursion. a=" + a + " b=" + b + " result=" + result + " check=" + check);

            result = Multiplication.multiplyUsingShift(a, b);
            check = Multiplication.multiplication(a, b);
            assertTrue((result == check), "Multiplication using shifts. a=" + a + " b=" + b + " result=" + result + " check=" + check);

            result = Multiplication.multiplyUsingLogs(a, b);
            check = Multiplication.multiplication(a, b);
            assertTrue((result == check), "Multiplication using logs. a=" + a + " b=" + b + " result=" + result + " check=" + check);

            result = Integer.parseInt(Multiplication.multiplyUsingFFT(Integer.toString(a), Integer.toString(b)));
            check = Multiplication.multiplication(a, b);
            assertTrue((result == check), "Multiplication using FFT. a=" + a + " b=" + b + " result=" + result + " check=" + check);

            result = Integer.parseInt(Multiplication.multiplyUsingLoopWithStringInput(Integer.toString(a), Integer.toString(b)));
            check = Multiplication.multiplication(a, b);
            assertTrue((result == check), "Multiplication using loop with string input. a=" + a + " b=" + b + " result=" + result + " check=" + check);

            result = Multiplication.multiplyUsingLoopWithIntegerInput(a, b);
            check = Multiplication.multiplication(a, b);
            assertTrue((result == check), "Multiplication using loop with int input. a=" + a + " b=" + b + " result=" + result + " check=" + check);
        }
        // positive * negative
        a *= -1;
        b *= -1;
        {
            long result = Multiplication.multiplyUsingLoop(a, b);
            long check = Multiplication.multiplication(a, b);
            assertTrue((result == check), "Multiplication using a loop. a=" + a + " b=" + b + " result=" + result + " check=" + check);

            result = Multiplication.multiplyUsingRecursion(a, b);
            check = Multiplication.multiplication(a, b);
            assertTrue((result == check), "Multiplication using recursion. a=" + a + " b=" + b + " result=" + result + " check=" + check);

            result = Multiplication.multiplyUsingShift(a, b);
            check = Multiplication.multiplication(a, b);
            assertTrue((result == check), "Multiplication using shifts. a=" + a + " b=" + b + " result=" + result + " check=" + check);

            result = Multiplication.multiplyUsingLogs(a, b);
            check = Multiplication.multiplication(a, b);
            assertTrue((result == check), "Multiplication using logs. a=" + a + " b=" + b + " result=" + result + " check=" + check);

            result = Integer.parseInt(Multiplication.multiplyUsingFFT(Integer.toString(a), Integer.toString(b)));
            check = Multiplication.multiplication(a, b);
            assertTrue((result == check), "Multiplication using FFT. a=" + a + " b=" + b + " result=" + result + " check=" + check);

            result = Integer.parseInt(Multiplication.multiplyUsingLoopWithStringInput(Integer.toString(a), Integer.toString(b)));
            check = Multiplication.multiplication(a, b);
            assertTrue((result == check), "Multiplication using loop with string input. a=" + a + " b=" + b + " result=" + result + " check=" + check);

            result = Multiplication.multiplyUsingLoopWithIntegerInput(a, b);
            check = Multiplication.multiplication(a, b);
            assertTrue((result == check), "Multiplication using loop with int input. a=" + a + " b=" + b + " result=" + result + " check=" + check);
        }
        // negative * negative
        a *= -1;
        {
            long result = Multiplication.multiplyUsingLoop(a, b);
            long check = Multiplication.multiplication(a, b);
            assertTrue((result == check), "Multiplication using a loop. a=" + a + " b=" + b + " result=" + result + " check=" + check);

            result = Multiplication.multiplyUsingRecursion(a, b);
            check = Multiplication.multiplication(a, b);
            assertTrue((result == check), "Multiplication using recursion. a=" + a + " b=" + b + " result=" + result + " check=" + check);

            result = Multiplication.multiplyUsingShift(a, b);
            check = Multiplication.multiplication(a, b);
            assertTrue((result == check), "Multiplication using shifts. a=" + a + " b=" + b + " result=" + result + " check=" + check);

            result = Multiplication.multiplyUsingLogs(a, b);
            check = Multiplication.multiplication(a, b);
            assertTrue((result == check), "Multiplication using logs. a=" + a + " b=" + b + " result=" + result + " check=" + check);

            result = Integer.parseInt(Multiplication.multiplyUsingFFT(Integer.toString(a), Integer.toString(b)));
            check = Multiplication.multiplication(a, b);
            assertTrue((result == check), "Multiplication using FFT. a=" + a + " b=" + b + " result=" + result + " check=" + check);

            result = Integer.parseInt(Multiplication.multiplyUsingLoopWithStringInput(Integer.toString(a), Integer.toString(b)));
            check = Multiplication.multiplication(a, b);
            assertTrue((result == check), "Multiplication using loop with string input. a=" + a + " b=" + b + " result=" + result + " check=" + check);

            result = Multiplication.multiplyUsingLoopWithIntegerInput(a, b);
            check = Multiplication.multiplication(a, b);
            assertTrue((result == check), "Multiplication using loop with int input. a=" + a + " b=" + b + " result=" + result + " check=" + check);
        }
    }

    @Test
    public void division() {
        int a = nextRandomInt(MIN, MAX);
        int b = nextRandomInt(a, MAX);
        long result = Division.divisionUsingLoop(a, b);
        long check = Division.division(a, b);
        assertTrue((result == check), "Division using a loop. a=" + a + " b=" + b + " result=" + result + " check=" + check);

        result = Division.divisionUsingRecursion(a, b);
        check = Division.division(a, b);
        assertTrue((result == check), "Division using recursion. a=" + a + " b=" + b + " result=" + result + " check=" + check);

        result = Division.divisionUsingShift(a, b);
        check = Division.division(a, b);
        assertTrue((result == check), "Division using shifts. a=" + a + " b=" + b + " result=" + result + " check=" + check);

        result = Division.divisionUsingLogs(a, b);
        check = Division.division(a, b);
        assertTrue((result == check), "Division using logs. a=" + a + " b=" + b + " result=" + result + " check=" + check);

        result = Division.divisionUsingMultiplication(a, b);
        check = Division.division(a, b);
        assertTrue((result == check), "Division using multiplication. a=" + a + " b=" + b + " result=" + result + " check=" + check);
    }

    @Test
    public void knapsack() {
        int[] values = {7, 4, 8, 6, 2, 5};
        int[] weights = {2, 3, 5, 4, 2, 3};
        int capacity = 9;
        int[] result = Knapsack.zeroOneKnapsack(values, weights, capacity);
        int[] check = new int[]{5, 3, 0};
        for (int i = 0; i < result.length; i++) {
            int r = result[i];
            int c = check[i];
            assertTrue(r == c, "Knapsack problem. expected=" + c + " got=" + r);
        }
    }

    @Test
    public void chebyshevDistance() {
        long[] point1 = new long[]{1, 2};
        long[] point2 = new long[]{7, 8};
        long result = Distance.chebyshevDistance(point1, point2);
        long expected = 6;
        assertTrue((result == expected), "Chebyshev Distance error. expected=" + expected + " got=" + result);
    }

    @Test
    public void squaredDistance() {
        int x1 = 1;
        int y1 = 2;
        int x2 = 7;
        int y2 = 8;
        double result = Distance.squaredDistance(x1, y1, x2, y2);
        double expected = 72.0;
        assertTrue((result == expected), "squaredDistance error. expected=" + expected + " got=" + result);
    }

    @Test
    public void euclideanDistance() {
        int x1 = 1;
        int y1 = 2;
        int x2 = 7;
        int y2 = 8;
        double result = Distance.euclideanDistance(x1, y1, x2, y2);
        double expected = 8.48528137423857;
        assertTrue((result == expected), "squaredDistance error. expected=" + expected + " got=" + result);
    }

    @Test
    public void getPrimeFactorization() {
        int number = 234;
        Map<Long, Long> factorization = Primes.getPrimeFactorization(number);
        Map<Long, Long> check = new HashMap<Long, Long>();
        {
            check.put(2l, 1L);
            check.put(3l, 2L);
            check.put(13L, 1L);
        }
        for (Long k : factorization.keySet()) {
            Long f = factorization.get(k);
            Long c = check.get(k);
            assertTrue((c == f), "PrimeFactorization error. expected=" + c + " got=" + f);
        }
    }

    @Test
    public void isPrime() {
        int number = 1234;
        boolean isPrime = Primes.isPrime(number);
        assertFalse(isPrime, "isPrime error. isPrime=" + isPrime);

        number = 7919;
        isPrime = Primes.isPrime(number);
        assertTrue(isPrime, "isPrime error. isPrime=" + isPrime);
    }

    @Test
    public void sieveOfEratosthenes() {
        int number = 1;
        boolean isPrime = Primes.sieveOfEratosthenes(number);
        assertFalse(isPrime, "Sieve Of Eratosthenes error.");

        number = 31;
        isPrime = Primes.sieveOfEratosthenes(number);
        assertTrue(isPrime, "Sieve Of Eratosthenes error.");

        number = 64;
        isPrime = Primes.sieveOfEratosthenes(number);
        assertFalse(isPrime, "Sieve Of Eratosthenes error.");

        number = 4177;
        isPrime = Primes.sieveOfEratosthenes(number);
        assertTrue(isPrime, "Sieve Of Eratosthenes error.");

        number = 4178;
        isPrime = Primes.sieveOfEratosthenes(number);
        assertFalse(isPrime, "Sieve Of Eratosthenes error.");

        number = 7919;
        isPrime = Primes.sieveOfEratosthenes(number);
        assertTrue(isPrime, "Sieve Of Eratosthenes error.");

        number = 556;
        isPrime = Primes.sieveOfEratosthenes(number);
        assertFalse(isPrime, "Sieve Of Eratosthenes error.");

        number = 6091;
        isPrime = Primes.sieveOfEratosthenes(number);
        assertTrue(isPrime, "Sieve Of Eratosthenes error.");

        number = 6090;
        isPrime = Primes.sieveOfEratosthenes(number);
        assertFalse(isPrime, "Sieve Of Eratosthenes error.");

        number = 6089;
        isPrime = Primes.sieveOfEratosthenes(number);
        assertTrue(isPrime, "Sieve Of Eratosthenes error.");
    }

    @Test
    public void millerRabin() {
        final List<Integer> primeNumbers = Arrays.asList(2, 3, 7, 23, 2179, 25657, 34123);
        final List<Integer> compositeNumbers = Arrays.asList(4, 9, 27, 2457, 26575, 34121);

        for (int prime : primeNumbers)
            assertTrue(Primes.millerRabinTest(prime), "Miller-Rabin test error. " + prime);

        for (int composite : compositeNumbers)
            assertFalse(Primes.millerRabinTest(composite), "Miller-Rabin test error. " + composite);
    }
}

