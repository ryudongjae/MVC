package war.servlet.web.frontcontroller.v2.controller;

import war.servlet.domain.member.Member;
import war.servlet.domain.member.MemberRepository;
import war.servlet.web.frontcontroller.MyView;
import war.servlet.web.frontcontroller.v2.ControllerV2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberListControllerV2 implements ControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("MvcMemberListServlet.service");
        List<Member> members = memberRepository.findAll();

        //모델에 담는다
        request.setAttribute("members",members);


        return new MyView("/WEB-INF/view/members.jsp");
    }
}
