package by.it.sc04_evening_tue_thu.makarevich.lesson09;

import java.math.BigInteger;

/*
 * Вам необходимо выполнить способ вычисления чисел Фибоначчи с вспомогательным массивом
 * без ограничений на размер результата (BigInteger)
 */

public class FiboB1 {

    private long startTime = System.currentTimeMillis();

    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {

        //вычисление чисел простым быстрым методом
        FiboB1 fibo = new FiboB1();
        int n = 47;
        System.out.printf("fastB(%d)=%d \n\t time=%d \n\n", n, fibo.fastB(n), fibo.time());
    }

    BigInteger fastB(int n) {
        //здесь нужно реализовать вариант с временем O(n) и памятью O(n)
        BigInteger[] fib = new BigInteger[n + 1];
        fib[0] = BigInteger.ZERO;
        fib[1] = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            BigInteger s1 = fib[i - 1];
            BigInteger s2 = fib[i - 2];
            BigInteger result = s1.add(s2);
            fib[i] = result;

        }
        return fib[n];
    }
}



