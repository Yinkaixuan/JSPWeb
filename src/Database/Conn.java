package Database;

import java.sql.*;

/**
 * Created by zhuch on 2017/11/20.
 */
public class Conn {
    public static Connection connection;
    public static Statement statement;
    public static String driver;
    public static String url;
    public static String username;
    public static String password;
    public ResultSet resultSet;
    static {
        driver = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/test";
        username = "doubibobo";
        password = "12151618";
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            System.out.println("�ɹ����ӵ����ݿ⣡");
        } catch (ClassNotFoundException e) {
            System.out.println("�޷�����jdbc������");
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // �õ����Ӷ����ҷ���connection��static����ȷ��ֻ����һ�γ�ʼ��
    public Connection getConnection() {
        return connection;
    }

    // ���캯��
    public Conn() {
        this.connection = this.getConnection();
    }

    // ��ѯ���ݿ��е�������Ŀ
    public void doSelect(String sql) {
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
