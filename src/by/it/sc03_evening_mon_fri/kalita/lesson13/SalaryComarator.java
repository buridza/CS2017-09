package by.it.sc03_evening_mon_fri.kalita.lesson13;

import java.util.Comparator;
import java.util.List;

public class SalaryComarator implements Comparator<Double> {
    @Override
    public int compare(Double o1, Double o2) {
        if(o1<o2){
            return -1;
        } else if(o1==o2){
            return 0;
        }else return 1;
    }
}
