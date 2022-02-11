package org.assign1_temp;

import java.sql.Date;
import java.sql.Timestamp;

public class sqlResult2{
    public int actor_id;
    public String first_name;
    public String last_name;
    public String last_update;
//    public int getActor_id() {
//        return actor_id;
//    }
    public void setActor_id(int id) {
        this.actor_id = id;
    }
//    public String getfirst_name() {
//        return first_name;
//    }
    public void setfirst_name(String name) {
        this.first_name = name;
    }
//    public String getlast_name() {
//        return last_name;
//    }
    public void setlast_name(String name) {
        this.last_name = name;
    }
    public  void setLast_update(String last_update){
        this.last_update = last_update;
    }
//    public String getLast_update(){
//        return last_update;
//    }

//    @Override
//    public String toString() {
//        return 	"id: " + actor_id + "\n" +
//                "firstname: " + first_name + "\n"+
//                "lastname: " + last_name + "\n" +
//                "last_update: " + last_update.toString() + "\n\n";
//    }
}