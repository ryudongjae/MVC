package war.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseJsonServlet",urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //content-type : application/json
        response.setHeader("content-type","application/json");
        response.setCharacterEncoding("utf-8");

        HelloData data = new HelloData();
        data.setAge(33);
        data.setUsername("Lee");

        //{"username": "Lee", "age":"33"}
        String result = objectMapper.writeValueAsString(data);

        response.getWriter().write(result);
    }
}
