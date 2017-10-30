package by.it.sc02_morning.opanovich.lesson09;

/*
 * Даны целые числа 1<=n<=1E18 и 2<=m<=1E5,
 * необходимо найти остаток от деления n-го числа Фибоначчи на m.
 * время расчета должно быть не более 2 секунд
 */

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
        System.out.printf("fasterC(%d)=%d \n\t time=%d \n\n", n, fibo.fasterC(n, m), fibo.time());
    }

    long fasterC(long n, int m) {
        //решение практически невозможно найти интуитивно
        //вам потребуется дополнительный поиск информации
        //см. период Пизано
        ArrayList<Integer> list = getPeriod(m);
        int period = list.size() - 2;
        return list.get((int) n % period);
    }

    private static ArrayList<Integer> getPeriod(int m) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        for (int i = 2; i < m * 6; i++) {
            list.add((list.get(i-1) + list.get(i-2)) % m);
            if (list.get(i) == 1 && list.get(i - 1) == 0) {
                break;
            }
        }
        return list;
    }

}

