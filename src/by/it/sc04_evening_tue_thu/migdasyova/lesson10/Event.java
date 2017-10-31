package by.it.sc04_evening_tue_thu.migdasyova.lesson10;
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

    public int getStart(){
        return start;
    }

    public int getStop(){
        return stop;
    }

    @Override
    public String toString() {
        return "(" + start + ":" + stop + ")";
    }


    @Override
    public int compareTo(Event otherEvent) {
        //сортировка по умолчанию не работает.
        //переопределите возвращаемое значение
        //используя this и otherEvent

        //подсказка, правильно написанный компаратор возвращает
        //0 если объекты равны
        //-1 если порядок следования в массиве  или коллекции this и otherEvent неправильный
        return this.stop-otherEvent.stop;

    }
}
