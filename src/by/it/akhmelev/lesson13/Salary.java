package by.it.akhmelev.lesson13;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Salary {
    double[] salary;

    Salary() {
    }

    Salary(double[] salary) {
        this.salary = salary;
    }

    Salary(String[] salary) {
        this.salary=new double[salary.length];
        for (int i = 0; i < salary.length; i++)
            this.salary[i]=Double.parseDouble(salary[i]);
    }

    double getSum(){
        double res=0;
        for (double s : salary) {
            res+=s;
        }
        return res;
    }

    double getSum(double percent){
        return getSum()*(100+percent)/100;
    }

    double[] getSalary(){
        return salary;
    }

    double[] getSalary(double percent){
        double[] res=Arrays.copyOf(salary,salary.length);
        for (int i = 0; i < res.length; i++) {
            res[i]=res[i]*(100+percent)/100;
        }
        return res;
    }

    void sort(){
        Arrays.sort(salary);
    }

    @Override
    public String toString(){
        return Arrays.toString(salary);
    }
}
