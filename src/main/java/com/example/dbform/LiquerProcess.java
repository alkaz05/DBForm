package com.example.dbform;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.*;
import java.util.ArrayList;

public class LiquerProcess {
    static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://10.10.104.136:5432/alko_anya?user=postgres&password=123";
        Connection conn = DriverManager.getConnection(url);
        return conn;
    }
        static void saveLiq(Liquer otr) throws SQLException {
            Connection conn = getConnection();
            int id = 2;
            String a = otr.getLabel();
            float b = otr.getVolume();
            String c = String.valueOf(otr.getCategory());
            String d = otr.getSubcategory();
            String e = otr.getCountry();
            float f = otr.getStrength();
            float g = otr.getSugar();
            int h = otr.getYear();
            int j = otr.getAge();

            String query = "insert into \"liquer\" (id, label, volume, category, subcategory, country, strength, sugar, year, age) values ('"+id+"', '"+a+"', '"+b+"', '"+c+"', '"+d+"','"+e+"','"+f+"','"+g+"','"+h+"', '"+j+"');";
            Statement st = conn.createStatement();
            st.execute(query);
        }

        static ArrayList<Liquer> readLiq() throws SQLException {
            ArrayList<Liquer> trrrr=new ArrayList<>();
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            String query ="select * from \"liquer\" l ;";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                String a = rs.getString("label");
                float b = rs.getFloat("volume");
                String c = rs.getString("category");
                AlcoCategory ac = AlcoCategory.valueOf(c);
                String d = rs.getString("subcategory");
                String e = rs.getString("country");
                float f = rs.getFloat("strength");
                float g = rs.getFloat("sugar");
                int h = rs.getInt("year");
                int j = rs.getInt("age");
                int id = rs.getInt("id");
                Liquer l = new Liquer(id, a, b, ac, d, e, f, g, h, j);
                trrrr.add(l);
            }
            return trrrr;
        }
    }


