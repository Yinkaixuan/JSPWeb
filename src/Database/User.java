package Database;
import javax.print.DocFlavor;
import java.sql.*;
import bean.userBeans;
/**
 * Created by zhuch on 2017/11/20.
 */
public class User {
    public void getAllMember(String name, String password) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("�޷�����jdbc������");
            e.printStackTrace();
        }
        // ���ñ������ݿ�ķ���class_two
        String url = "jdbc:mysql://localhost:3306/test";
        // ���÷������������Ӷ���
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, "doubibobo", "12151618");
            Statement statement = connection.createStatement();
            System.out.println("�ɹ����ӵ����ݿ⣡");

            String sql = "select * from student";
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println("ѧ��"+"\t" + "\t" +"����");
            while(resultSet.next()) {
                System.out.println(resultSet.getString(1) + "\t");
                System.out.println(resultSet.getString(2) + "\t");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void checkTheUser(userBeans user) {
        if (user.username.equals("") || user.username != null) {

        }
    }
}
