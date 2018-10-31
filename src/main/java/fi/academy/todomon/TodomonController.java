package fi.academy.todomon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodomonController {

    private int currentUserId;

    

    @Autowired
    private UsersRepository repo;


    // ============ emmun testausmetodit ============
    @GetMapping("/main")
    public String etusivuTestaus() {
        return "main";
    }

    @GetMapping("/add")
    public String lisaysTestaus() {
        return "add";
    }

    @GetMapping("/test")
    public String etusivu() {
        return "testindex";
    }
}

