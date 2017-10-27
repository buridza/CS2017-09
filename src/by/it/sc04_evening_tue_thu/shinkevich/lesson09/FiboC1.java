package by.it.sc04_evening_tue_thu.shinkevich.lesson09;

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
int a=0, b=1, c;
        for (int i = 0; i <n ; i++) {
         c=a; a=b; b=(c+a)%m; }
         return a;
        //решение практически невозможно найти интуитивно
        //вам потребуется дополнительный поиск информации
        //см. период Пизано
        /* private static ArrayList<Long> getSequencePeriod(long m){
            ArrayList<Long> s = new ArrayList();
            s.add((long)0);
            s.add((long)1);
            for(int i = 2; i < m * 6; i++){
                s.add((s.get(i - 1) + s.get(i - 2)) % m);
                if(s.get(i) == 1 && s.get(i-1) == 0){
                    break;
                }
           }
            return s;
/*
       private static long getFibonacciRest(long n, long m){
        ArrayList<Long> s = getSequencePeriod(m);
        long period = s.size() - 2; // находим период Пизано
        int val = (int)(n % period);
        return s.get(val);
    } }
       */
        //return 0L;
    }


}

