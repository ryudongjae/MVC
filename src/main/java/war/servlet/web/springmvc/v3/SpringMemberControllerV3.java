package war.servlet.web.springmvc.v3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import war.servlet.domain.member.Member;
import war.servlet.domain.member.MemberRepository;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @GetMapping("new-form")
    public String newForm(){
        return "new-form";
    }

    @PostMapping("/save")
    public String save(
            @RequestParam("username")String username,
            @RequestParam("age")int age,
            Model model){

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute(member);

        return "save-result";

    }


    @GetMapping
    public String  members(Model model){
        List<Member> members = memberRepository.findAll();

        model.addAttribute("members",members);

        return "members";
    }
}
