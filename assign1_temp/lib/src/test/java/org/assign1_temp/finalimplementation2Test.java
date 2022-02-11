package org.assign1_temp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.management.Query;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class finalImplementation2Test {
    private  finalImplementation2 sr = new finalImplementation2();
    @BeforeEach
    void setUp() {
        Connection con = null;
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String db = "sakila";
            String driver = "com.mysql.cj.jdbc.Driver";
            String user = "root";
            String pass = "mysql";
            Class.forName(driver);
            con = DriverManager.getConnection(url + db, user, pass);
        } catch(Exception e) {
            e.printStackTrace();
        }
        sr.con = con;
    }
    @AfterEach
    void tearDown() {
        try {
            sr.con.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    @Test
    void selectOne1() {
        sqlResult2 pojo = new sqlResult2();
        Object[] l = new Object[]{1, "PENELOPE"};
        pojo = sr.selectOne("selectActor1", l, sqlResult2.class);
        System.out.println(pojo.actor_id + " " + pojo.first_name + " " + pojo.last_name + " " + pojo.last_update);
        Object[] actual = new Object[]{1, "PENELOPE", "GUINESS", "2006-02-15 04:34:33.0"};
        Object[] got = new Object[]{pojo.actor_id, pojo.first_name, pojo.last_name, pojo.last_update};
        assertArrayEquals(got, actual);
    }
    @Test
    void selectOne2() {
        sqlResult2 pojo = new sqlResult2();
        pojo = sr.selectOne("selectActor2", 1, sqlResult2.class);
        System.out.println(pojo.actor_id + " " + pojo.first_name + " " + pojo.last_name + " " + pojo.last_update);
        Object[] actual = new Object[]{1, "PENELOPE", "GUINESS", "2006-02-15 04:34:33.0"};
        Object[] got = new Object[]{pojo.actor_id, pojo.first_name, pojo.last_name, pojo.last_update};
        assertArrayEquals(got, actual);
    }
    @Test
    void selectOne3() {
        sqlResult2 pojo = new sqlResult2();
        testclass2 inp = new testclass2();
        inp.actor_id = 1;
        inp.first_name = "PENELOPE";
        inp.last_name = "GUINESS";
        inp.last_update = "2006-02-15 04:34:33";
        pojo = sr.selectOne("selectActor3", inp, sqlResult2.class);
        System.out.println(pojo.actor_id + " " + pojo.first_name + " " + pojo.last_name + " " + pojo.last_update);
        Object[] actual = new Object[]{1, "PENELOPE", "GUINESS", "2006-02-15 04:34:33.0"};
        Object[] got = new Object[]{pojo.actor_id, pojo.first_name, pojo.last_name, pojo.last_update};
        assertArrayEquals(got, actual);
    }
    @Test
    void selectMany1() {
        sqlResult2 pojo1 = new sqlResult2();
        sqlResult2 pojo2 = new sqlResult2();
        sqlResult2 pojo3 = new sqlResult2();
        sqlResult2 pojo4 = new sqlResult2();
        sqlResult2 pojo5 = new sqlResult2();
        List<sqlResult2> lpojo;
        lpojo = sr.selectMany("selectActors1", "P%", sqlResult2.class);
        List<sqlResult2> lpojoDB = new ArrayList<sqlResult2>();
        pojo1.actor_id = 1;
        pojo1.first_name = "PENELOPE";
        pojo1.last_name = "GUINESS";
        pojo1.last_update = "2006-02-15 04:34:33.0";
        lpojoDB.add(pojo1);
        pojo2.actor_id = 46;
        pojo2.first_name = "PARKER";
        pojo2.last_name = "GOLDBERG";
        pojo2.last_update = "2006-02-15 04:34:33.0";
        lpojoDB.add(pojo2);
        pojo3.actor_id = 54;
        pojo3.first_name = "PENELOPE";
        pojo3.last_name = "PINKETT";
        pojo3.last_update = "2006-02-15 04:34:33.0";
        lpojoDB.add(pojo3);
        pojo4.actor_id = 104;
        pojo4.first_name = "PENELOPE";
        pojo4.last_name = "CRONYN";
        pojo4.last_update = "2006-02-15 04:34:33.0";
        lpojoDB.add(pojo4);
        pojo5.actor_id = 120;
        pojo5.first_name = "PENELOPE";
        pojo5.last_name = "MONROE";
        pojo5.last_update = "2006-02-15 04:34:33.0";
        lpojoDB.add(pojo5);
        for (int i=0;i<lpojo.size();i++) {
//            System.out.println(lpojoDB.get(i).actor_id + " " + lpojoDB.get(i).first_name + " " + lpojoDB.get(i).last_name + " " + lpojoDB.get(i).last_update);
//            System.out.println(lpojo.get(i).actor_id + " " + lpojo.get(i).first_name + " " + lpojo.get(i).last_name + " " + lpojo.get(i).last_update);
            assertEquals(lpojo.get(i).actor_id, lpojoDB.get(i).actor_id);
            assertEquals(lpojo.get(i).first_name, lpojoDB.get(i).first_name);
            assertEquals(lpojo.get(i).last_name, lpojoDB.get(i).last_name);
            assertEquals(lpojo.get(i).last_update, lpojoDB.get(i).last_update);
        }
    }
    @Test
    void selectMany2() {
        sqlResult2 pojo1 = new sqlResult2();
        sqlResult2 pojo2 = new sqlResult2();
        int[] ids = new int[]{1, 2};
        List<sqlResult2> lpojo;
        lpojo = sr.selectMany("selectActors2", ids, sqlResult2.class);
        List<sqlResult2> lpojoDB = new ArrayList<sqlResult2>();
        pojo1.actor_id = 1;
        pojo1.first_name = "PENELOPE";
        pojo1.last_name = "GUINESS";
        pojo1.last_update = "2006-02-15 04:34:33.0";
        lpojoDB.add(pojo1);
        pojo2.actor_id = 2;
        pojo2.first_name = "NICK";
        pojo2.last_name = "WAHLBERG";
        pojo2.last_update = "2006-02-15 04:34:33.0";
        lpojoDB.add(pojo2);
        for (int i=0;i<lpojo.size();i++) {
            assertEquals(lpojo.get(i).actor_id, lpojoDB.get(i).actor_id);
            assertEquals(lpojo.get(i).first_name, lpojoDB.get(i).first_name);
            assertEquals(lpojo.get(i).last_name, lpojoDB.get(i).last_name);
            assertEquals(lpojo.get(i).last_update, lpojoDB.get(i).last_update);
        }
    }
    @Test
    void insert1() {
        testclass2 haha = new testclass2();
        haha.actor_id = 206;
        haha.first_name = "abc";
        haha.last_name = "lastabc";
        haha.last_update = "2006-02-15 04:34:33";
        int a = sr.insert("insertIntoActor1", haha);
        assertEquals(a, 1);
    }
    @Test
    void insert2() {
        Object[] haha = new Object[]{207, "hi", "areYouOkay", "2006-02-15 04:35:33"};
        int a = sr.insert("insertIntoActor2", haha);
        assertEquals(a, 1);
    }
    @Test
    void update1() {
        testclass2 haha = new testclass2();
        haha.actor_id = 201;
        haha.first_name = "changed";
        haha.last_name="try";
        haha.last_update = "2006-02-15 04:35:33";
        int a = sr.update("updateActor1", haha);
        System.out.println(a);
        assertEquals(a, 1);
    }
    @Test
    void update2() {
        Object[] haha = new Object[]{"changedyetagain", 202};
        int a = sr.update("updateActor2", haha);
        System.out.println(a);
        assertEquals(a, 1);
    }
    @Test
    void delete1() {
        int a = sr.delete("deleteActor1", 203);
        assertEquals(a, 1);
    }
    @Test
    void delete2() {
        testclass2 haha = new testclass2();
        haha.actor_id = 204;
        haha.first_name = "name4";
        haha.last_name="try";
        haha.last_update = "2006-02-15 04:35:33";
        int a = sr.delete("deleteActor2", haha);
        assertEquals(a, 1);
    }
    @Test
    void delete3() {
        Object[] haha= new Object[]{205, "name5", "namelast5"};
        int a = sr.delete("deleteActor3", haha);
        assertEquals(a, 1);
    }
}