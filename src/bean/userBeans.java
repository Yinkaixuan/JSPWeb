package bean;
import Database.Conn;

import java.sql.ResultSet;
import java.sql.SQLException

/**
 * Created by zhuch on 2017/11/20.
 */;
public class userBeans {
    public String username;
    public String password;

    public Conn thecontent;

    /**
     * ��ʼ�����캯��
     */
    public userBeans() {
        super();
        thecontent = new Conn("student");
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * ��ѯ���еİ༶��Ա
     * @return ���а༶��Ա����Ϣ
     */
    public ResultSet selectAll() {
        return thecontent.selectAll();
    }

    /**
     * �鿴������Ϣ
     * @return ���ظ�����Ϣ
     */
    public ResultSet selectOne() {
        return thecontent.getOne(username, "id");
    }

    /**
     * ����¼��Ϣ���û����Լ����룩
     * @return true����false
     */
    public boolean checkUser() {
        ResultSet theResult = thecontent.getOne(username, "id");
        try {
            System.out.println(theResult != null);
            // ����ѯ�������ʱ��
            if(theResult != null) {
                while (theResult.next()){
                    // �õ��������ֶ�
                    String pwd = theResult.getString("password");
                    if(password.equals(pwd)){
                        return true;
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
