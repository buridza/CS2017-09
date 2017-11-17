package by.it.sc03_evening_mon_fri.kalita.lesson13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Salary {
    private List<Double> salary;

    public Salary() {
    }
    public Salary(String[] str){
        this.salary = new ArrayList<>();
        for (String s: str ) {
            salary.add(Double.parseDouble(s));
        }

    }
    public Salary(Double... d){
        this.salary = new ArrayList<>();
        for (Double iter: d) {
            salary.add(iter);
        }

    }
    public Salary(double[] arr) {
        List<Double> salary= new ArrayList<>();
        for (Double d: arr             ) {
            salary.add(d);
        }
        this.salary = salary;
    }

    public double getSum(){
        double sum=0;
        for (double d: salary) {
            sum+= d;
        }
        return sum;
    }
    public double getSum(double percent){
        return getSum()*percent;
    }
    public List<Double> getSalary(){
        return salary;
    }
    public List<Double> getSalary(double percent){
        List<Double> list = new ArrayList<Double>();
        for (double d: salary) {
            list.add(Double.parseDouble(String.format("%.1f", d*percent).replace(',','.')));
        }
        return list;
    }
    public void setSalary(double percent){
        for (int i = 0; i < salary.size(); i++) {
            salary.set(i,salary.get(i)*percent);
        }
    }
    public void sort(){
        salary.sort(new SalaryComarator());
    }

    @Override
    public String toString() {
        return "Salary{" +
                "salary=" + salary +
                '}';
    }
}
