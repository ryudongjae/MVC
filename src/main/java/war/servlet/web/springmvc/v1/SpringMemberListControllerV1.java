package war.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import war.servlet.domain.member.Member;
import war.servlet.domain.member.MemberRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SpringMemberListControllerV1 {

    private MemberRepository memberepository = MemberRepository.getInstance();

    @RequestMapping("/springmvc/v1/members")
    public ModelAndView process(){

        List<Member> members =  memberepository.findAll();
        ModelAndView mv = new ModelAndView("members");
        mv.addObject("members",members);
        return mv;

    }

}
