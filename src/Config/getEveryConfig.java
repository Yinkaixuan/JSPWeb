package Config;

import Database.Conn;

import java.util.ArrayList;

/**
 * Created by zhuch on 2017/12/2.
 */
public class getEveryConfig {
    private getConfig doGetConfig;
    private ArrayList<keyValuePair> list;
    private String[] allDbConfiger;
    private String[] allStudentTable;
    private String[][] allCol;
    private String[] allCourseTable;
    private String[] allInterestTable;
    public getEveryConfig(){
        // ʵ���������ļ���
        this.doGetConfig = new getConfig();
        // ��ȡ���黯�������ļ�
        this.list = doGetConfig.getKeyValue();
        this.allDbConfiger = null;
        this.allStudentTable = null;
    }

    /**
     * ��ȡ���е����ݿ����ƣ�������ʹ��
     * @return ���е����ݿ�����
     */
    public String[] getAllDbConfiger() {
        for (keyValuePair pair:this.list) {
            if (pair.key.equals("\"dbConfiger\"")) {
                pair.value = pair.value.replace("{", "");
                pair.value = pair.value.replace("}", "");
                pair.value = pair.value.replace("\"", "");
                this.allDbConfiger = this.doGetConfig.doSplit(pair.value, ",");
            }
        }
        return this.allDbConfiger;
    }

    /**
     * �������ܣ���ȡ����ѧ������б���Ϣ
     */
    private void getAllStudentTable() {
        for (keyValuePair pair:this.list) {
            if (pair.key.equals("\"student\"")) {
                pair.value = pair.value.replace("{", "");
                this.allStudentTable = this.doGetConfig.doSplit(pair.value, "],");
            }
        }
    }

    /**
     * �õ�һ�����е���������Ϣ
     * @return  ����Ϣ
     */
    public String[][] getAllCol() {
        this.getAllStudentTable();
        this.allCol = new String[this.allStudentTable.length][2];
        for (int i = 0; i < this.allStudentTable.length; i++) {
            this.allStudentTable[i] =  this.allStudentTable[i].replace("[", "");
            this.allStudentTable[i] =  this.allStudentTable[i].replace("]", "");
            this.allCol[i] = this.doGetConfig.doSplit(this.allStudentTable[i], "=>");
            System.out.println(this.allCol[i]);
        }
        return this.allCol;
    }
}
