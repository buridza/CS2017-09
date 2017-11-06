package by.it.sc04_evening_tue_thu.yanushkevich.lesson09;

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
        //здесь нужно реализовать вариант с временем O(n) и памятью O(n)

        //MY-заполение ArrayList числами Фибоначи
        ArrayList <BigInteger> fib = new ArrayList<>();
            fib.add(BigInteger.ZERO); //здесь add добавление элемента в коллекцию
            fib.add(BigInteger.ONE);
            for (int i = 2; i <=n ; i++) {
                BigInteger s1 =fib.get(i-1);
                BigInteger s2 =fib.get(i-2);
                BigInteger sum = s1.add(s2); //add здесь сложение biginteger
                fib.add(sum);

            //fib(i)=fib(i-1).add(fib(n-2));

        }

        return fib.get(n);
      //  return BigInteger.ZERO;
    }

}

