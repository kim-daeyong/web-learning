package my.examples.blog.controller;

import lombok.RequiredArgsConstructor;
import my.examples.blog.domain.Account;
import my.examples.blog.dto.JoinForm;
import my.examples.blog.service.AccountService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final AccountService accountService;

    @GetMapping("/login")
    public String login(
            @RequestParam(name = "fail",
                    required = false,
                    defaultValue = "false") String errorFlag){

        return "users/login"; // view name 을 리턴한다.
    }



    @GetMapping("/join")
    public String joinform() {return "users/joinform"; }


    @PostMapping("/join")
    public String join(@Valid JoinForm joinForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new IllegalArgumentException(bindingResult.toString());
        }
        if(!joinForm.getPassword1().equals(joinForm.getPassword2()))
            throw new IllegalArgumentException("암호가 일치하지 않습니다.");

        Account account = new Account();
        account.setEmail(joinForm.getEmail());
        account.setName(joinForm.getName());
        account.setNickName(joinForm.getNickName());
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        account.setPasswd(passwordEncoder.encode(joinForm.getPassword1()));

        Account result = accountService.join(account);

        return "redirect:/users/welcome";


    }
    @GetMapping("/welcome")
    public String welcome(){
        return "users/welcome";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id")Long id){
        accountService.deleteAccount(id);
        return "users/welcome";
    }




}
