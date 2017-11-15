package by.it.sc02_morning.davydov.lesson13;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

@SuppressWarnings("all") //море warnings. всех прячем.

//поставьте курсор на следующую строку и нажмите Ctrl+Shift+F10
public class Testing13 {

    @Test(timeout = 1500)
    public void testTaskA1() throws Exception {
        run("12\n11\n10\n9\n8\n7\n6\n5\n4\n3\n2\n1").
                include("[12.0, 11.0, 10.0, 9.0, 8.0, 7.0, 6.0, 5.0, 4.0, 3.0, 2.0, 1.0]").
                include("78.0").
                include("[14.4, 13.2, 12.0, 10.8, 9.6, 8.4, 7.2, 6.0, 4.8, 3.6, 2.4, 1.2]").
                include("93.6").
                include("[1.5, 3.0, 4.5, 6.0, 7.5, 9.0, 10.5, 12.0, 13.5, 15.0, 16.5, 18.0]").
                include("117.0");
    }

    @Test(timeout = 1500)
    public void testTaskB1() throws Exception {
        Class<?> cl = findClass("Salary");
        if (cl == null) fail("Нет класса Salary");
        Constructor<?> c = findConstructor(cl, double[].class);
        findMethod(cl, "sort");
        findMethod(cl, "getSalary");
        Method m = findMethod(cl, "getSum");
        Object sum = m.invoke(c.newInstance(new double[]{1, 2, 3}));
        assertEquals("Сумма массива {1,2,3} считается некорректно", sum.toString(), "6.0");
        run("12\n11\n10\n9\n8\n7\n6\n5\n4\n3\n2\n1").
                include("[12.0, 11.0, 10.0, 9.0, 8.0, 7.0, 6.0, 5.0, 4.0, 3.0, 2.0, 1.0]").
                include("78.0").
                include("[14.4, 13.2, 12.0, 10.8, 9.6, 8.4, 7.2, 6.0, 4.8, 3.6, 2.4, 1.2]").
                include("93.6").
                include("[1.5, 3.0, 4.5, 6.0, 7.5, 9.0, 10.5, 12.0, 13.5, 15.0, 16.5, 18.0]").
                include("117.0");
    }


    @Test(timeout = 1500)
    public void testTaskC1() throws Exception {
        Class<?> cl = findClass("Salary");
        if (cl == null) fail("Нет класса Salary");
        Constructor<?> c = findConstructor(cl, double[].class);
        findMethod(cl, "sort");
        findMethod(cl, "getSalary");
        Method m = findMethod(cl, "getSum");
        Object sum = m.invoke(c.newInstance(new double[]{1, 2, 3}));
        assertEquals("Сумма массива {1,2,3} считается некорректно", sum.toString(), "6.0");
        findConstructor(cl, String[].class);
        run("12\n11\n10\n9\n8\n7\n6\n5\n4\n3\n2\n1").
                include("[12.0, 11.0, 10.0, 9.0, 8.0, 7.0, 6.0, 5.0, 4.0, 3.0, 2.0, 1.0]").
                include("78.0").
                include("[14.4, 13.2, 12.0, 10.8, 9.6, 8.4, 7.2, 6.0, 4.8, 3.6, 2.4, 1.2]").
                include("93.6").
                include("[1.5, 3.0, 4.5, 6.0, 7.5, 9.0, 10.5, 12.0, 13.5, 15.0, 16.5, 18.0]").
                include("117.0");
    }


    /*
    ===========================================================================================================
    НИЖЕ ВСПОМОГАТЕЛЬНЫЙ КОД ТЕСТОВ. НЕ МЕНЯЙТЕ В ЭТОМ ФАЙЛЕ НИЧЕГО.
    Но изучить как он работает - можно, это всегда будет полезно.
    ===========================================================================================================
     */

    private Class findClass(String SimpleName) {
        String full = this.getClass().getName();
        String dogPath = full.replace(this.getClass().getSimpleName(), SimpleName);
        try {
            return Class.forName(dogPath);
        } catch (ClassNotFoundException e) {
            fail("\nТест не пройден. Класс " + SimpleName + " не найден.");
        }
        return null;
    }

    private Method findMethod(Class<?> cl, String name, Class... param) {
        try {
            return cl.getDeclaredMethod(name, param);
        } catch (NoSuchMethodException e) {
            fail("\nТест не пройден. Метод " + cl.getName() + "." + name + " не найден");
        }
        return null;
    }

    private Constructor<?> findConstructor(Class<?> cl, Class<?>... param) {
        try {
            return cl.getDeclaredConstructor(param);
        } catch (NoSuchMethodException e) {
            fail("\nТест не пройден. Конструктор " + cl.getName() + " не найден (с числом параметров: " + param.length + ")");
        }
        return null;
    }

    private Object invoke(Method method, Object o, Object... value) {
        try {
            return method.invoke(o, value);
        } catch (Exception e) {
            fail("\nНе удалось вызвать метод " + method.getName());
        }
        return null;
    }

    //метод находит и создает класс для тестирования
    //по имени вызывающего его метода, testTaskA1 будет работать с TaskA1
    private static Testing13 run(String in) {
        Throwable t = new Throwable();
        StackTraceElement trace[] = t.getStackTrace();
        StackTraceElement element;
        int i = 0;
        do {
            element = trace[i++];
        }
        while (!element.getMethodName().contains("test"));

        String[] path = element.getClassName().split("\\.");
        String nameTestMethod = element.getMethodName();
        String clName = nameTestMethod.replace("test", "");
        clName = element.getClassName().replace(path[path.length - 1], clName);
        System.out.println("\n---------------------------------------------");
        System.out.println("Старт теста для " + clName + "\ninput:" + in);
        System.out.println("---------------------------------------------");
        return new Testing13(clName, in);
    }

    public Testing13() {
        //Конструктор тестов
    }

    //Конструктор тестов
    //    private Testing(String className) {
    //        this(className, "");
    //    }

    //Основной конструктор тестов
    private Testing13(String className, String in) {
        //this.className = className;
        Class<?> c = null;
        try {
            c = Class.forName(className);
        } catch (ClassNotFoundException e) {
            fail("Не найден класс " + className);
        }
        reader = new StringReader(in); //заполнение ввода
        InputStream inputStream = new InputStream() {
            @Override
            public int read() throws IOException {
                return reader.read();
            }
        };
        System.setIn(inputStream);   //перехват ввода

        System.setOut(newOut); //перехват стандартного вывода
        try {
            Class[] argTypes = new Class[]{String[].class};
            Method main = c.getDeclaredMethod("main", argTypes);
            main.invoke(null, (Object) new String[]{});

        } catch (Exception x) {
            x.printStackTrace();
        }
        System.setOut(oldOut); //возврат вывода
    }

    //проверка вывода
    private Testing13 is(String str) {
        assertTrue("Ожидается такой вывод:\n<---начало---->\n" + str + "<---конец--->",
                stringWriter.toString().equals(str));
        return this;
    }

    private Testing13 include(String str) {
        assertTrue("Строка не найдена: " + str + "\n", stringWriter.toString().contains(str));
        return this;
    }

    private Testing13 exclude(String str) {
        assertTrue("Лишние данные в выводе: " + str + "\n", !stringWriter.toString().contains(str));
        return this;
    }


    //переменные теста
    private StringWriter stringWriter = new StringWriter();
    private PrintStream oldOut = System.out;
    private StringReader reader;


    //поле для перехвата потока вывода
    private PrintStream newOut;

    {
        newOut = new PrintStream(new OutputStream() {
            private byte bytes[] = new byte[2];

            @Override
            public void write(int b) throws IOException {
                if (b < 0) { //ловим и собираем двухбайтовый UTF (первый код > 127, или в байте <0)
                    if (bytes[0] == 0) { //если это первый байт
                        bytes[0] = (byte) b; //то запомним его
                    } else {
                        bytes[1] = (byte) b; //иначе это второй байт
                        String s = new String(bytes); //соберем весь символ
                        stringWriter.append(s); //запомним вывод для теста
                        oldOut.append(s); //копию в обычный вывод
                        bytes[0] = 0; //забудем все.
                    }
                } else {
                    char c = (char) b; //ловим и собираем однобайтовый UTF
                    bytes[0] = 0;
                    if (c != '\r') {
                        stringWriter.write(c); //запомним вывод для теста
                    }
                    oldOut.write(c); //копию в обычный вывод
                }
            }
        });
    }

}
