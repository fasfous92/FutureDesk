package fr.p2i.desk.data;

import fr.p2i.desk.util.SensorData;

public class BackData extends SensorData {

    private int d1;
    private int d2;
    private int d3;
    private int g1;
    private int g2;
    private int g3;
    private long timestamp;
    public BackData(int d1,int d2,int d3,int g1,int g2,int g3){
        timestamp=System.currentTimeMillis();
        this.type="back";
        this.d1=d1;
        this.d2=d2;
        this.d3=d3;
        this.g1=g1;
        this.g2=g2;
        this.g3=g3;
    }
    @Override
    public String toString() {
        return timestamp+";"+d1+";"+d2+";"+g1+";"+g2;
    }
}
