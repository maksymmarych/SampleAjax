package controller;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/logpasajax")
public class LogPassAjax extends HttpServlet {
    Map<String, String> list;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

        Map<String, String[]> parameterMap = request.getParameterMap();
        String login = parameterMap.get("login")[0];
        String password = parameterMap.get("password")[0];

        System.out.println("start");

        try {
            if (Auth(login, password)) {
                response.getWriter().println("Succes");
                System.out.println("Succes");
            } else {

                response.getWriter().println("Fail");
                System.out.println("fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public boolean Auth(String login, String password) {
        if (password.equals(list.get(login))) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void init(){
        list = new HashMap<>();

        list.put("Admin", "admin");
        System.out.println("init");
    }
}
