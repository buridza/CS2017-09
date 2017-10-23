package by.it.sc03_evening_mon_fri.kukobnikov_gleb.lesson09;

import java.math.BigInteger;

/*
 * Вам необходимо выполнить рекурсивный способ вычисления чисел Фибоначчи
 */

public class FiboA1 {

    private long startTime = System.currentTimeMillis();

    private long time() {
        long result=System.currentTimeMillis() - startTime;
        startTime = System.currentTimeMillis();
        return result;
    }

    public static void main(String[] args) {
        FiboA1 fibo = new FiboA1();
        int n = 33;
        System.out.printf("calc(%d)=%d \n\t time=%d \n\n", n, fibo.calc(n), fibo.time());

        //вычисление чисел фибоначчи медленным методом (рекурсией)
        fibo = new FiboA1();
        n = 33;
        System.out.printf("slowA(%d)=%d \n\t time=%d \n\n", n, fibo.slowA(n), fibo.time());
    }


    private int calc(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        if (n>1)  return calc(n-1)+calc(n-2);
        return 0;
    }


    BigInteger slowA(int n) {

        if (n==0) return BigInteger.ZERO;
        if (n==1) return BigInteger.ONE;

        BigInteger s1=slowA(n-1);
        BigInteger s2=slowA(n-2);
        BigInteger result=s1.add(s2);

        return result;
    }



}

