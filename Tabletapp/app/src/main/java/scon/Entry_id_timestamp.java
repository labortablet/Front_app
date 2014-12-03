package scon;

import java.util.Calendar;

public class Entry_id_timestamp{
    private Integer id;
    private Integer last_change;

    public Entry_id_timestamp(Integer id, Integer last_change){
        this.id = id;
        this.last_change = last_change;
    }

    public Integer getId(){
        return this.id;
    }

    public Integer getLast_change() {
        return this.last_change;
    }
}
