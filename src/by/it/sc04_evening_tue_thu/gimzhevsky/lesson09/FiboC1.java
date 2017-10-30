package by.it.sc04_evening_tue_thu.gimzhevsky.lesson09;

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
        int n = 12;
        int m = 2;
//        System.out.printf("fasterC(%d)=%d \n\t time=%d \n\n", n, fibo.fasterC(10, 2), fibo.time());
//        System.out.printf("fasterC(%d)=%d \n\t time=%d \n\n", n, fibo.fasterC(1, 2), fibo.time());
//        System.out.printf("fasterC(%d)=%d \n\t time=%d \n\n", n, fibo.fasterC(999999999, 321), fibo.time());
        System.out.printf("fasterC(%d)=%d \n\t time=%d \n\n", n, fibo.fasterC(n, m), fibo.time());
    }

    long fasterC(long n, int m) {
        //решение практически невозможно найти интуитивно
        //вам потребуется дополнительный поиск информации
        //см. период Пизано
        ArrayList<BigInteger> fib = new ArrayList<>();
        fib.add(BigInteger.ZERO);
        fib.add(BigInteger.ONE);

        ArrayList<BigInteger> pizanoArray= new ArrayList<>();
        pizanoArray.add(BigInteger.ZERO);
        pizanoArray.add(BigInteger.ONE);
        BigInteger bm = BigInteger.valueOf(m);
        for (int i = 2; i<=n; i++) {
            BigInteger s1 = fib.get(i - 1);
            BigInteger s2 = fib.get(i - 2);
            BigInteger sum = s1.add(s2);
            BigInteger modul = sum.mod(bm);
            if (modul.equals(BigInteger.ONE) && pizanoArray.get(i-1).equals(BigInteger.ZERO)) {
                break;
            } else
                fib.add(sum);
                pizanoArray.add(modul);
        }
        /*for (int i = 0; i<fib.size(); i++){
            System.out.print(fib.get(i) + " ");
        }
        System.out.println();
        for (int i = 0; i<pizanoArray.size(); i++){
            System.out.print(pizanoArray.get(i) + " ");
        }
        System.out.println();*/
        long mod = n%(pizanoArray.size()-1);
        /*int
        result = (int)mod;
        else */
        if (n==0)return 0L;
        if (n==1) return 1L;
        return pizanoArray.get((int)mod).longValue();
    }


}

