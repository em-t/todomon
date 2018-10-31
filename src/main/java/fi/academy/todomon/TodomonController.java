package fi.academy.todomon;

import fi.academy.todomon.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class TodomonController {


    private UsersRepository usersRepo;
    private TasksRepository tasksRepo;

    @Autowired
    public TodomonController(UsersRepository usersRepo, TasksRepository tasksRepo) {
        this.usersRepo = usersRepo;
        this.tasksRepo = tasksRepo;
    }

    // Käyttäjähallinta & autentikointi
    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/user")
    public String user() {
        return "annintesti";
    }

    @RequestMapping(value = "/admin")
    public String admin() {
        return "annintesti";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "customlogin";
    }
    
    @RequestMapping(value = "/403")
    public String Error403() {
        return "403";
    }
}






