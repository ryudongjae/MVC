package war.servlet.web.frontcontroller.v1.controller;

import war.servlet.domain.member.Member;
import war.servlet.domain.member.MemberRepository;
import war.servlet.web.frontcontroller.v1.ControllerV1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberListControllerV1 implements ControllerV1 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MvcMemberListServlet.service");
        List<Member> members = memberRepository.findAll();

        //모델에 담는다
        request.setAttribute("members",members);


        String viewPath = "/WEB-INF/view/members.jsp"; //뷰 위치
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);// 컨트롤러에서 뷰로 이동할때 사용
        dispatcher.forward(request,response);//서블릿에서 jsp호출
    }
}
