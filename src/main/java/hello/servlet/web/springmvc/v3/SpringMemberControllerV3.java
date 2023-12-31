package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller// 스프링 빈으로 등록
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @GetMapping(value = "/new-form")
    public String newForm(){
        return "new-form";
    }

    @GetMapping
    public String members(Model model){
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);

        return "members";
    }

    @PostMapping(value = "/save")
    public String save(@RequestParam("username") String username, @RequestParam("age") int age, Model model){

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member",member);

        return "save-result";
    }
}
