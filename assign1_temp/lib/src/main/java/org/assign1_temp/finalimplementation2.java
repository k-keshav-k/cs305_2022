package org.assign1_temp;

import java.sql.*;
import java.util.List;
import java.util.*;
import java.util.Objects;
import java.util.regex.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.ArrayUtils;

class finalImplementation2 implements SqlRunner{
    List<Queries> que;
    Connection con;

    finalImplementation2() {
        xml_parser xmlToQuery = new xml_parser();
        this.que = xmlToQuery.parse_xml();
    }
    private <T> String substituteValueArray(String sqlQuery, T[] queryParam) {
        String res = sqlQuery;
        for(T x:queryParam){
            System.out.println(x);
            String pattern = "\\$\\{value}";
            if (Pattern.matches("\\d+", x.toString())) {
                res = res.replaceFirst(pattern, x + "");}
            else res = res.replaceFirst(pattern, "\"" + x + "\"");
        }
        System.out.println("Query after replacing values:"+res);
        return res;
    }
    private <T> String substituteValueObject(String sqlQuery, T queryParam)  {
        String res = sqlQuery;
        try {
            ObjectMapper om = new ObjectMapper();
            Map<String, Object> myObjectAsDict = om.convertValue(queryParam, Map.class);
            for (Map.Entry<String, Object> x : myObjectAsDict.entrySet()) {
                System.out.println(x.getKey() + "==" + x.getValue());
            }
            for (Map.Entry<String, Object> x : myObjectAsDict.entrySet()) {
                String pattern = "\\$\\{" + x.getKey() + "}";
                if (Pattern.matches("\\d+", x.getValue().toString())) {
                    res = res.replaceAll(pattern, x.getValue() + "");
                } else res = res.replaceFirst(pattern, "\"" + x.getValue() + "\"");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Query after replacing values:"+res);
        return res;
    }
    public <T, R> R selectOne(String queryId, T queryParam, Class<R> resultType){
        List<R> retObj = null;
        try {
            ResultSet res = null;
            Statement stmt = con.createStatement();
            String sql = null;
            String paramType = null;
            for (Queries queries : que) {
                if (Objects.equals(queries.ID, queryId)) {
                    sql = queries.sql_query;
                    paramType = queries.paramType;
                }
            }
            String objclass = queryParam.getClass().toString();
            //System.out.println(objclass);
            if (!objclass.equals(paramType)){throw new Exception("ParamType of xml and passed argument do not match");}
            String[] parts = objclass.split("\\.");
            //System.out.println(parts[0]);
            if (parts[0].equals("class [Ljava")){
                sql = substituteValueArray(sql, (T[]) queryParam);
            }
            else if (parts[0].equals("class [I")){sql = substituteValueArray(sql, ArrayUtils.toObject((int[]) queryParam));}
            else if (parts[0].equals("class [C")){sql = substituteValueArray(sql, ArrayUtils.toObject((char[]) queryParam));}
            else if (parts[0].matches("class java")){
                sql = substituteValueArray(sql, new Object[]{queryParam});
            }
            else sql = substituteValueObject(sql, queryParam);
            //System.out.println(sql.trim());
            res = stmt.executeQuery(sql.trim());
            ResultSetMapper<R> resultS = new ResultSetMapper<R>();
            retObj = resultS.mapRersultSetToObject(res, resultType);
            if (retObj.size() > 1){retObj = null;throw new Exception("More than 1 row as a result of query");}
            if (retObj.size() == 0){throw new Exception("Select query return 0 rows");}
        } catch(Exception e) {e.printStackTrace();}
        assert retObj != null;
        return retObj.get(0);
    }
    public <T, R> List<R> selectMany(String queryId, T queryParam, Class<R> resultType) {
        List<R> retObj = null;
        try {
            ResultSet res = null;
            Statement stmt = con.createStatement();
            String sql = null;
            String paramType = null;
            for (Queries queries : que) {
                if (Objects.equals(queries.ID, queryId)) {
                    sql = queries.sql_query;
                    paramType = queries.paramType;
                }
            }
            String objclass = queryParam.getClass().toString();
            //System.out.println(objclass);
            if (!objclass.equals(paramType)){throw new Exception("ParamType of xml and passed argument do not match");}
            //System.out.println(objclass);
            String[] parts = objclass.split("\\.");
            //System.out.println(parts[0]);
            if (parts[0].equals("class [Ljava")){sql = substituteValueArray(sql, (T[]) queryParam);}
            else if (parts[0].equals("class [I")){
                sql = substituteValueArray(sql, ArrayUtils.toObject((int[]) queryParam));
            }
            else if (parts[0].equals("class [C")){sql = substituteValueArray(sql, ArrayUtils.toObject((char[]) queryParam));}
            else if (parts[0].matches("class java")){
                sql = substituteValueArray(sql, new Object[]{queryParam});
            } else sql = substituteValueObject(sql, queryParam);
            //System.out.println(sql.trim());
            res = stmt.executeQuery(sql.trim());
            ResultSetMapper<R> resultS = new ResultSetMapper<R>();
            retObj = resultS.mapRersultSetToObject(res, resultType);
            if (retObj.size() == 0){throw new Exception("Select query return 0 rows");}
        } catch(Exception e){e.printStackTrace();}
        return retObj;
    }
    public <T> int insert(String queryId, T queryParam){
        int res = 0;
        try {
            Statement stmt = con.createStatement();
            String sql = null;
            String paramType = null;
            for (Queries queries : que) {
                if (Objects.equals(queries.ID, queryId)) {
                    sql = queries.sql_query;
                    paramType = queries.paramType;
                }
            }
            String objclass = queryParam.getClass().toString();
            //System.out.println(objclass);
            if (!objclass.equals(paramType)){throw new Exception("ParamType of xml and passed argument do not match");}
            //System.out.println(objclass);
            String[] parts = objclass.split("\\.");
            //System.out.println(parts[0]);
            if (parts[0].equals("class [Ljava")){
                sql = substituteValueArray(sql, (T[]) queryParam);
            }
            else if (parts[0].equals("class [I")){sql = substituteValueArray(sql, ArrayUtils.toObject((int[]) queryParam));}
            else if (parts[0].equals("class [C")){sql = substituteValueArray(sql, ArrayUtils.toObject((char[]) queryParam));}
            else if (parts[0].matches("class java")){sql = substituteValueArray(sql, new Object[]{queryParam});}
            else sql = substituteValueObject(sql, queryParam);
            //System.out.println(sql.trim());
            res = stmt.executeUpdate(sql.trim());
        } catch(Exception e){e.printStackTrace();}
        return res;
    }
    public <T> int delete(String queryId, T queryParam) {
        int res = 0;
        try {
            Statement stmt = con.createStatement();
            String sql = null;
            String paramType = null;
            for (Queries queries : que) {
                if (Objects.equals(queries.ID, queryId)) {
                    sql = queries.sql_query;
                    paramType = queries.paramType;
                }
            }
            //System.out.println(sql);
            String objclass = queryParam.getClass().toString();
            //System.out.println(objclass);
            if (!objclass.equals(paramType)){throw new Exception("ParamType of xml and passed argument do not match");}
            //System.out.println(objclass);
            String[] parts = objclass.split("\\.");
            //System.out.println(parts[0]);
            if (parts[0].equals("class [Ljava")){
                sql = substituteValueArray(sql, (T[]) queryParam);
            }
            else if (parts[0].equals("class [I")){sql = substituteValueArray(sql, ArrayUtils.toObject((int[]) queryParam));}
            else if (parts[0].equals("class [C")){sql = substituteValueArray(sql, ArrayUtils.toObject((char[]) queryParam));}
            else if (parts[0].matches("class java")){
                sql = substituteValueArray(sql, new Object[]{queryParam});
            }
            else sql = substituteValueObject(sql, queryParam);
            //System.out.println(sql.trim());
            res = stmt.executeUpdate(sql.trim());
        } catch(Exception e){e.printStackTrace();}
        return res;
    }
    public <T> int update(String queryId, T queryParam) {
        int res = 0;
        try {
            Statement stmt = con.createStatement();
            String sql = null;
            String paramType = null;
            for (Queries queries : que) {
                if (Objects.equals(queries.ID, queryId)) {
                    sql = queries.sql_query;
                    paramType = queries.paramType;
                }
            }
            String objclass = queryParam.getClass().toString();
            //System.out.println(objclass);
            if (!objclass.equals(paramType)){throw new Exception("ParamType of xml and passed argument do not match");}
            //System.out.println(objclass);
            String[] parts = objclass.split("\\.");
            //System.out.println(parts[0]);
            if (parts[0].equals("class [Ljava")){
                sql = substituteValueArray(sql, (T[]) queryParam);
            }
            else if (parts[0].equals("class [I")){sql = substituteValueArray(sql, ArrayUtils.toObject((int[]) queryParam));}
            else if (parts[0].equals("class [C")){sql = substituteValueArray(sql, ArrayUtils.toObject((char[]) queryParam));}
            else if (parts[0].matches("class java")){sql = substituteValueArray(sql, new Object[]{queryParam});}
            else sql = substituteValueObject(sql, queryParam);
            //System.out.println(sql.trim());
            res = stmt.executeUpdate(sql.trim());
        } catch (Exception e){e.printStackTrace();}
        return res;
    }
}