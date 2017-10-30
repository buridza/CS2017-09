package by.it.sc02_morning.menchytsky.lesson10;
/*
вспомогательный класс.
событие у аудитории(два поля: начало и конец)

Обратите внимание на метод compareTo
*/
class Event implements Comparable<Event>{
    private int start;
    private int stop;

    Event(int start, int stop) {
        this.start = start;
        this.stop = stop;
    }

    int getStart(){
        return start;
    }

    int getStop(){
        return stop;
    }
    @Override
    public String toString() {
        return "(" + start + ":" + stop + ")";
    }


    @Override
    public int compareTo(Event otherEvent) {
        int result=0;
        if(this.stop < otherEvent.stop) result=-1;
        if(this.stop == otherEvent.stop) result=0;
        if(this.stop > otherEvent.stop) result=1;

        //сортировка по умолчанию не работает.
        //переопределите возвращаемое значение
        //используя this и otherEvent

        //подсказка, правильно написанный компаратор возвращает
        //1 если порядок следования в массиве или коллекции this и otherEvent правильный
        //0 если объекты равны
        //-1 если порядок следования в массиве  или коллекции this и otherEvent неправильныйк
        return result;
    }
}
