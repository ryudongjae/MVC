package war.servlet.web.servletmvc;

import war.servlet.domain.member.Member;
import war.servlet.domain.member.MemberRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "mvcMemberListServlet",urlPatterns ="/servlet-mvc/members" )
public class MvcMemberListServlet extends HttpServlet {

    private MemberRepository memberRepository =MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MvcMemberListServlet.service");
        List<Member> members = memberRepository.findAll();

        //모델에 담는다
        request.setAttribute("members",members);


        String viewPath = "/WEB-INF/view/members.jsp"; //뷰 위치
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);// 컨트롤러에서 뷰로 이동할때 사용
        dispatcher.forward(request,response);//서블릿에서 jsp호출


    }
}
