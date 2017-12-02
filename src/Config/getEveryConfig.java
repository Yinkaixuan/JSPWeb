package Config;

import java.util.ArrayList;

/**
 * Created by zhuch on 2017/12/2.
 */
public class getEveryConfig {
    private getConfig doGetConfig;
    private ArrayList<keyValuePair> list;
    private String[] allDbConfiger;
    public getEveryConfig(){
        // ʵ���������ļ���
        this.doGetConfig = new getConfig();
        // ��ȡ���黯�������ļ�
        this.list = doGetConfig.getKeyValue();
        this.allDbConfiger = null;
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
                this.allDbConfiger = doGetConfig.doSplit(pair.value, ",");
            }
        }
        return this.allDbConfiger;
    }
}
