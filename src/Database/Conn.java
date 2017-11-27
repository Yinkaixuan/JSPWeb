package Database;

import com.sun.org.apache.regexp.internal.RE;

import java.sql.*;
import java.io.*;

/**
 * Created by zhuch on 2017/11/20.
 */
public class Conn {
    public static String driver;
    public static String username;
    public static String password;

    public Connection connection;
    public Statement statement;
    public String url;

    public ResultSet resultSet;
    public String dataTable;
    static {
        driver = "com.mysql.jdbc.Driver";
        username = "doubibobo";
        password = "12151618";
    }
    // ���캯��
    public Conn(String dataTable) {
        url = "jdbc:mysql://localhost:3306/class_two";
        System.out.println(driver);
        System.out.println(url);
        System.out.println(username);
        System.out.println(password);
        try {
            Class.forName(driver);
            System.out.println("�ɹ�����������");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("��������ʧ�ܣ�");
        }
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            System.out.println("�ɹ����ӵ����ݿ⣡");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.dataTable = dataTable;
    }

    /**
     * ��ѯ���ݿ��е�������Ŀ
     * @return �������ݿ��е�������Ϣ
     */
    public ResultSet selectAll() {
        String sql = "select * from"+this.dataTable;
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    /**
     * ��ѯ���ݿ��е�һ����Ŀ
     * @param value
     * @param where
     * @return
     */
    public ResultSet getOne(String value, String where) {
        String sql = "select * from "+this.dataTable+" where "+ where + " = " + value;
        System.out.println(sql);
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
