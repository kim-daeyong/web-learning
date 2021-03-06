package my.examples.BootExam.controller;

import my.examples.BootExam.dto.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @GetMapping("/main")
    public String main(Model model
    , @RequestParam(name= "page", required = false, defaultValue = "1")int page){
        System.out.println(page);
        model.addAttribute("name", "kdy");
        List<Book> list = new ArrayList<>();
        list.add(new Book("1234", "title1", "author1",50));
        list.add(new Book("2424", "title2", "author2",150));
        list.add(new Book("2141", "title3", "author3",520));
        model.addAttribute("list", list);
        return "index";
    }
}
