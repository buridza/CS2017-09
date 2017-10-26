package by.it.sc02_morning.opanovich.lesson09;

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
        int n = 55555;
        System.out.printf("fastB(%d)=%d \n\t time=%d \n\n", n, fibo.fastB(n), fibo.time());
    }

    BigInteger fastB(int n) {
        //здесь нужно реализовать вариант с временем O(n) и памятью O(n)
        if (n == 0) return BigInteger.ZERO;
        if (n == 1) return BigInteger.ONE;
        BigInteger num1 = fastB(0),
        num2 = fastB(1);
        BigInteger res = num2;
        for (int i = 2; i <= n; i++) {
            res = num1.add(num2);
            num1 = num2;
            num2 = res;
        }
        return res;
    }
}

