package spring.mvc1.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import spring.mvc1.basic.HelloData;

import java.io.IOException;
@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // content type을 json으로 지정
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        // 객체를 가지고 값을 써서 문자로 바꿔라,
        HelloData helloData = new HelloData();
        helloData.setUsername("heeju");
        helloData.setAge(23);

        // {username : ~, age ; ~} json형식으로
        //  이 객체의 메서드를 쓰면 객체를 JSON 문자로 바꿔줌
        String result = objectMapper.writeValueAsString(helloData);
        response.getWriter().write(result);



    }
}
