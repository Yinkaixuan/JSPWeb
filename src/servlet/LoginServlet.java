package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

import Config.getConfig;
import Config.getEveryConfig;
import Config.keyValuePair;
import bean.userBeans;

/**
 * Created by zhuch on 2017/11/20.
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ����HTTP��Ӧ���ĵ����ͣ��˴�ΪText/html
        response.setContentType("text/html");
        // ������Ӧ�ı��뷽ʽ
        response.setCharacterEncoding("GB18030");
        // ȡ���û����������ֵ
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String forward = "";

        getEveryConfig everyConfig = new getEveryConfig();
        // �������ݿ��������Ϣ
        String[] allDbConfiger = everyConfig.getAllDbConfiger();
        // �������ݿ��ѧ������Ϣ
        String[][] allStudentConfig = everyConfig.getAllCol();

        userBeans theUser = new userBeans(allStudentConfig, allDbConfiger);
        theUser.setUsername(username);
        theUser.setPassword(password);
        log(username);
        log(password);

        // ���ݿ�������Ϣ
        int connectConfig = theUser.checkUser();
        if(connectConfig >= 0){
            forward = "main.jsp";
        } else {
            forward = "doubibobo.jsp";
        }
        // �����û���ר����sessionֵ
        request.getSession().setAttribute("userid", username);
        request.getSession().setAttribute("database", connectConfig);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(forward);
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
