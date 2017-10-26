package by.it.sc02_morning.lutskevichm.lesson09;

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
        BigInteger [] f = new BigInteger[n+1];
        f[0]= BigInteger.ZERO;
        f [1] = BigInteger.ONE;
        for (int i=2; i<=n; i++) {
            f[i] = f[i-1].add(f[i-2]);
        }
        return f[n];
        //здесь нужно реализовать вариант с временем O(n) и памятью O(n)

    }

}

