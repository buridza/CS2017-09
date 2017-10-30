package by.it.sc04_evening_tue_thu.bayramova.lesson09;

/*
 * Даны целые числа 1<=n<=1E18 и 2<=m<=1E5,
 * необходимо найти остаток от деления n-го числа Фибоначчи на m.
 * время расчета должно быть не более 2 секунд
 */

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
        long newn=n%pisano(m);
        int previous=0;
        int current=1;
        int tmp=0;
        if (newn<=1) {
            return newn;
        }
        for (int i=2; i<=newn; i++) {
            tmp=previous;
            previous=current;
            current=(previous+tmp)%m;
        }
        return current;
    }

    long pisano(int m) {
        int previous=0;
        int current=1;
        int length=1;
        int tmp;
        while (true) {
            tmp=previous;
            previous=current;
            current=(previous+tmp)%m;
            if (previous==0 && current==1){
                return length;
            }
            length+=1;
            }
        }
    }


