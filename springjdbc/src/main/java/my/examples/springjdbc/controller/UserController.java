package my.examples.springjdbc.controller;

import my.examples.springjdbc.dto.User;
import my.examples.springjdbc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class UserController {
    UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    //  @RequestMapping(method=GET, path="/list") 와 같은 것
//    @GetMapping("/list")
//    public String main(Model model){
//        List<User> users = userService.getUsers();
//        model.addAttribute("users", users);
//        return "index"; // view name
//    }
    @GetMapping("/list")
    public String main(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            Model model){
        List<User> users = userService.getUsers(page);
        model.addAttribute("users", users);
        return "index"; // view name
    }
    @GetMapping("/joinform")
    public String joinform(){
        return "joinform";
    }


    @GetMapping("/join")
    public String join(@RequestParam(name = "nickname")String nickname,
                       @RequestParam(name = "email")String email,
                       @RequestParam(name = "passwd")String passwd,
                       HttpSession httpSession){

        Assert.hasLength(nickname, "닉네임을 2글자 이상 입력하세요");
            if(nickname == null || nickname.length() <= 1)
                throw new IllegalArgumentException("이름을 입력하세요.");


            User user = new User();
            user.setPasswd(passwd);
            user.setNickname(nickname);
            user.setEmail(email);

        userService.addUser(user);

        return "redirect:/list";


    }
}