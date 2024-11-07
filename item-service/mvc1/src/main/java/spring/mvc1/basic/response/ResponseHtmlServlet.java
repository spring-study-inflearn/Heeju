package spring.mvc1.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "responseHtmlServlet", urlPatterns = "/response-html")
public class ResponseHtmlServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Content-type 설정해주는 코드 : //Content-Type: text/html;charset=utf-8 => http 응답을 html로 해주려면 타입 이렇게 설정해야함!!
        response.setContentType("text/html");
        //response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");

        PrintWriter writer = response.getWriter();
        // servlet 랜더링 직접 해줘야함 html일때는??
        writer.println("<html>");
        writer.println("<body");
        writer.println("    <div>안녕 스프링?!</div>");
        writer.println("</body>");
        writer.println("</html>");

    }
}
