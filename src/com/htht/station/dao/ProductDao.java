package com.htht.station.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by WYL on 2022/6/4.
 */
public class ProductDao {
    //增加
    public void save(String productName, int salePrice) {
        System.out.println("----------我是增加方法----------");
        System.out.println("productName = "+productName+" , salePrice = "+salePrice);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/station_demo", "root", "root");
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into product(product_name,sale_price) values('小米手机',1000)");
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //删除
    public void delete(int id) {
        System.out.println("----------我是删除方法----------");
        System.out.println("--id="+id);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/station_demo", "root", "root");
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete from product where id="+id);
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //修改
    public void update(int id, String productName, int salePrice) {
        System.out.println("----------我是修改方法----------");
        System.out.println("productName = "+productName+" , id = "+id);
    }

    //查询
    public String query() {
        System.out.println("----------我是查询方法----------");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/station_demo", "root", "root");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from product where id = 1");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String productName = resultSet.getString("product_name");
                int salePrice = resultSet.getInt("sale_price");
                System.out.println(id + "\t" + productName + "\t" +salePrice);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "苹果手机";
    }
}
