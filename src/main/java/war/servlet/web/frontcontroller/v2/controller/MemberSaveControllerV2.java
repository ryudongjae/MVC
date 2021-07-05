package war.servlet.web.frontcontroller.v2.controller;

import war.servlet.domain.member.Member;
import war.servlet.domain.member.MemberRepository;
import war.servlet.web.frontcontroller.MyView;
import war.servlet.web.frontcontroller.v2.ControllerV2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSaveControllerV2 implements ControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        //Model에 데이터를 보관
        request.setAttribute("member",member);

        return new MyView("/WEB-INF/view/save-result.jsp");
    }
}
