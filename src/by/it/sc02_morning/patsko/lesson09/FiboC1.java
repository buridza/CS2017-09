package by.it.sc02_morning.patsko.lesson09;

/*
 * Даны целые числа 1<=n<=1E18 и 2<=m<=1E5,
 * необходимо найти остаток от деления n-го числа Фибоначчи на m.
 * время расчета должно быть не более 2 секунд
 */

import java.math.BigInteger;
import java.util.ArrayList;

public class FiboC1 {

    private long startTime = System.currentTimeMillis();

    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {
        FiboC1 fibo = new FiboC1();
        int n = 10;
        int m = 2;
//        int n = 999999999;
//        int m = 321;

        System.out.printf("fasterC(%d)=%d \n\t time=%d \n\n", n, fibo.fasterC(n, m), fibo.time());
    }

    long fasterC(long n, int m) {
        //решение практически невозможно найти интуитивно
        //вам потребуется дополнительный поиск информации
        //см. период Пизано
        ArrayList<BigInteger> fib=new ArrayList<>();    //создаем список для чисел Фибоначи
        fib.add(BigInteger.ZERO);                       //первые два элемента списка фибоначи 0,1
        fib.add(BigInteger.ONE);
        for (int i = 2; true ; i++) {
            fib.add((fib.get(i - 1)).add(fib.get(i - 2)));                       //заполняем список Фибоначи элементами
            if(fib.get(i).mod(BigInteger.valueOf(m)).equals(BigInteger.ONE)&&    //по ходу цикла проверяем, если элемент i = 1
                    fib.get(i-1).mod(BigInteger.valueOf(m)).equals(BigInteger.ZERO)) {//а элемент i-1 = 0, то (i-1)-период Пизано
                //System.out.println(n+" "+(i - 1));

                if(n<(i-1)) return fib.get((int)n).mod(BigInteger.valueOf(m)).longValue();
                //если n меньше периода Пизано,то возвращаем приведенный к типу long
                //остаток от деления элемента n на переменную m
                else return fib.get((int)(n%(i-1))).mod(BigInteger.valueOf(m)).longValue();
                //в противном смысле возвращаем приведенный к типу long
                //остаток от деления элемента под номером "остаток от деления n на период Пизано" на переменную m
            }
        }
    }
}

