package fr.p2i.desk.util;

import java.util.ArrayList;
import java.util.List;

public class DataHandler<E extends SensorData> {

    private List<E> tempList = new ArrayList<E>();
    private List<E> list = new ArrayList<E>();
    public void add(E d){
        tempList.add(d);
    }

    public void clear(){
        for(E b : tempList) {
            list.add(b);
        }
        tempList.clear();
    }

    public List<E> getList() {
        return list;
    }

    public void push(){
        String statement = "INSERT INTO db.light";
    }
}
