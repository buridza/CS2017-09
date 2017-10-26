package by.it.sc04_evening_tue_thu.shinkevich.lesson07;
/*
Три массива
1.  Введите с клавиатуры 20 чисел, сохраните их в список и рассортируйте по трём другим спискам:
    Число делится на 3 (x%3==0), делится на 2 (x%2==0) и все остальные.
    Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
2.  Статический метод void printList(List<Integer> list) должен выводить на экран
    все элементы переданного ему списка list, каждый элемент - с новой строки.
3.  Используя метод printList выведите ваши три списка на экран.
    Сначала тот, который для x%3, потом тот, который для x%2, потом последний.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TaskC1 {
    public static void main(String[] args) throws Exception
    {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            ArrayList<Integer> bigList= new ArrayList<>();
            ArrayList<Integer> k3= new ArrayList<>();
            ArrayList<Integer> k2= new ArrayList<>();
            ArrayList<Integer> res= new ArrayList<>();
            for (int i=0;i<20;i++)
            {
                int x = Integer.parseInt(reader.readLine());
                bigList.add(x);
            }
        for (Integer aBigList : bigList) {
            if (aBigList % 3 == 0 && aBigList % 2 == 0) {
                k2.add(aBigList);
                k3.add(aBigList);
            } else if (aBigList % 3 == 0) {
                k3.add(aBigList);
            } else if (aBigList % 2 == 0) {
                k2.add(aBigList);
            } else {
                res.add(aBigList);
            }
        }
            printList(k3);
            printList(k2);
            printList(res);
        }
        private static void printList(List<Integer> list)
        {
            for (Integer aList : list) {
                System.out.println(aList);
            }
        }
    }

