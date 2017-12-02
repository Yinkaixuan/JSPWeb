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

    public String database;

    public Conn[] thecontent;

    /**
     * ��ʼ�����캯��
     */
    public userBeans(String dataTable, String[] dataBase) {
        super();
        thecontent = new Conn[dataBase.length];
        System.out.println(dataBase.length);
        for (int i1 = 0; i1 < dataBase.length; i1++) {
            thecontent[i1] = new Conn(dataTable, dataBase[i1]);
        }
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
    public ResultSet selectAll(int which) {
        return thecontent[which].selectAll();
    }

    /**
     * �鿴������Ϣ
     * @return ���ظ�����Ϣ
     */
    public ResultSet selectOne(int which) {
        return thecontent[which].getOne(username, "id");
    }

    /**
     * ����¼��Ϣ���û����Լ����룩
     * @return true����false
     */
    public boolean checkUser() {
        ResultSet[] theResult = new ResultSet[thecontent.length];
        for (int i = 0; i < thecontent.length; i++) {
            theResult[i] = thecontent[i].getOne(username, "id");
        }
        try {
            for (int i = 0; i < theResult.length; i++) {
                System.out.println(theResult[i] != null);
                // ����ѯ�������ʱ��
                if(theResult[i] != null) {
                    while (theResult[i].next()){
                        // �õ��������ֶ�
                        String pwd = theResult[i].getString("password");
                        if(password.equals(pwd)){
                            return true;
                        } else {
                            continue;
                        }
                    }
                } else {
                    return false;
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
