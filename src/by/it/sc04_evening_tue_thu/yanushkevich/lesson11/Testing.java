package by.it.sc04_evening_tue_thu.yanushkevich.lesson11;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Testing {
    @Test(timeout = 2000)
    public void A() throws Exception {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/akhmelev/lesson11/dataA.txt");
        A_BinaryFind instance = new A_BinaryFind();
        //long startTime = System.currentTimeMillis();
        int[] result = instance.findIndex(stream);
        //long finishTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int index : result) {
            sb.append(index).append(" ");
        }
        boolean ok = sb.toString().trim().equals("3 1 -1 1 -1");
        assertTrue("A failed", ok);

        //проверим на куче разных массивов.
        //все готово, создадим потоки для тестирования.
        for (int num = 0; num < 10; num++) {
            int size = 1 + num*2;
            int[] mas = new int[size];
            int[] val = new int[size];
            int[] ind = new int[size];
            for (int i = 0; i < mas.length; i++) {
                mas[i] = 1 + (int) (Math.random() * 10);
                val[i] = 1 + (int) (Math.random() * 13);
            }
            Arrays.sort(mas);
            //перебираем всякие разные случайные values
            for (int i = 0; i < mas.length; i++) {
                ind[i] = Arrays.binarySearch(mas, val[i]);
                ind[i] = ind[i] < 0 ? -1 : ind[i] + 1;
            }
            System.out.println("\nTest #" + num);
            sb = new StringBuilder();
            sb.append(mas.length).append(" ");
            for (int m : mas) sb.append(m).append(" ");
            sb.append("\n");
            sb.append(val.length).append(" ");
            for (int v : val) sb.append(v).append(" ");
            sb.append("\n");
            InputStream input = new ByteArrayInputStream(sb.toString().getBytes());
            int[] index = instance.findIndex(input);
            System.out.println("mas=" + Arrays.toString(mas));
            System.out.println("values=" + Arrays.toString(val));
            System.out.println("\nexpected index=" + Arrays.toString(index));
            System.out.println("actual index=" + Arrays.toString(ind));
            assertEquals("Размер индекса рассчитан неверно", index.length, ind.length);
            for (int i = 0; i < index.length; i++) {
                if (ind[i] > 0 && index[i] > 0) {
                    String err = String.format(
                            "Ошибка в элементе index[%d].\n" +
                                    "Ожидалось значение %d\n" +
                                    "Получено значение %d\n", i, mas[ind[i] - 1], mas[index[i] - 1]);
                    assertEquals(err, mas[ind[i] - 1], mas[index[i] - 1]);
                } else
                    assertEquals("Неверное определение индекса", ind[i], index[i]);
            }
            System.out.println("-----------");
        }
    }


    @Test(timeout = 2000)
    public void B() throws Exception {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/akhmelev/lesson11/dataB.txt");
        B_MergeSort instance = new B_MergeSort();
        //long startTime = System.currentTimeMillis();
        int[] result = instance.getMergeSort(stream);
        //long finishTime = System.currentTimeMillis();
        boolean ok = result.length > 3;
        int test[] = new int[result.length];
        System.arraycopy(result, 0, test, 0, result.length);
        Arrays.sort(test);
        for (int i = 0; i < result.length; i++) {
            ok = ok && (result[i] == test[i]);
        }
        assertTrue("B failed", ok);
    }


    @Test(timeout = 2000)
    public void C() throws Exception {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/akhmelev/lesson11/dataC.txt");
        C_GetInversions instance = new C_GetInversions();
        //long startTime = System.currentTimeMillis();
        int result = instance.calc(stream);
        //long finishTime = System.currentTimeMillis();
        boolean ok = (2 == result);
        assertTrue("C failed", ok);
    }

}
