package by.it.sc03_evening_mon_fri.liubimov_pavel.lesson09;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;

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
        ArrayList<BigInteger> memo = new ArrayList<>();
        if (n==0) return BigInteger.ZERO;
        if (n==1) return BigInteger.ONE;
        memo.add(BigInteger.ZERO);
        memo.add(BigInteger.ONE);
        for (int i=2; i<=n;i++){
            //memo.add(fastB(n-1).add(fastB(n-2)));
            BigInteger s1=memo.get(i-1);
            BigInteger s2=memo.get(i-2);
            BigInteger sum= s1.add(s2);
            memo.add(sum);
        }
        //здесь нужно реализовать вариант с временем O(n) и памятью O(n)
        return memo.get(n);
    }

}

