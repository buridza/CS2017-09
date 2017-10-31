package by.it.sc04_evening_tue_thu.makarevich.lesson10;
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
        return start; }
    void setStart(int start){
        this.start=start; }

    int getStop(){
        return stop; }
    void setStop(int stop){
        this.stop=stop; }

    @Override
    public String toString() {
        return "(" + start + ":" + stop + ")";
    }


    @Override
    public int compareTo(Event otherEvent) {
        if (this.stop<otherEvent.stop) return -1;
        else if (this.stop>otherEvent.stop) return 1;
        return 0;
    }



    //сортировка по умолчанию не работает.
        //переопределите возвращаемое значение
        //используя this и otherEvent

        //подсказка, правильно написанный компаратор возвращает
        //1 если порядок следования в массиве или коллекции this и otherEvent правильный
        //0 если объекты равны
        //-1 если порядок следования в массиве  или коллекции this и otherEvent неправильный


}
