package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

        userBeans theUser = new userBeans();
        theUser.setUsername(username);
        theUser.setPassword(password);
        log(username);
        log(password);

        if(theUser.checkUser()){
            forward = "index.jsp";
        } else {
            forward = "doubibobo.jsp";
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(forward);
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
