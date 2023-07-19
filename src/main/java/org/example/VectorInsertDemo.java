package org.example;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.*;
import java.util.stream.Collectors;

public class VectorInsertDemo {

    public void VectorDBInsert(){
    Connection conn = null;
    Statement stmt = null;
      try {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println(e);
        }
        conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ubc_test", "dipan", "XXXXXXXX");
        System.out.println("Connection is created successfully:");
        stmt = (Statement) conn.createStatement();
        String query1 = "";
        GenerateRandomNumber  generateRandomNumber = null;
        for(int i = 1 ; i <= 100 ; i++) {
            generateRandomNumber = new GenerateRandomNumber();
            List<Integer> randoms = generateRandomNumber.generateRandomNumbers();
            System.out.println("random == " + randoms.toString());
            System.out.println("Size []  " + randoms.size());
            String strRandoms = randoms.stream()
                    .map(x -> x.toString())
                    .collect(Collectors.joining(" | "));
            System.out.println("Inserted Data as BLOB: " + strRandoms);
            query1 = "INSERT INTO VectorDemo " + "VALUES ( " + i +" , " + strRandoms +" , 'UBPTest')";
            stmt.executeUpdate(query1);
        }
        System.out.println("Record is inserted in the table successfully..................");
    } catch (SQLException excep) {
        excep.printStackTrace();
    } catch (Exception excep) {
        excep.printStackTrace();
    } finally {
        try {
            if (stmt != null)
                conn.close();
        } catch (SQLException se) {}
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
      System.out.println("Please check it in the MySQL Table......... ……..");
}

    public Map<Integer,List<String>> readTable(String user, String password, String server)
    {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setServerName(server);
        try {
            Connection conn = dataSource.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ubc_test.VectorDemo");
            List<String> strList = null;
            Map<Integer,List<String>> mapVectors = null;
            while (rs.next()) {
                int vectorId = rs.getInt("VectorId");
                String vectors = rs.getString("VectorValues");
                System.out.println("vectorId ::" + vectorId);
                System.out.println("vectors :: " + vectors);
                String[] strSplit = vectors.split("|");
                strList = new ArrayList<String>(
                        Arrays.asList(strSplit));
                System.out.println("vectors :: " + strList);
                mapVectors = new HashMap<Integer, List<String>>();
                mapVectors.put(vectorId,strList);
            }
            rs.close();
            stmt.close();
            conn.close();
            return mapVectors;
        }catch (Exception e){
           e.printStackTrace();
        }

        return null;
    }

    }
