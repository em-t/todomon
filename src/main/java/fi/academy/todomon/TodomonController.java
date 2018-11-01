package fi.academy.todomon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;


@Controller
public class TodomonController {

    private UsersRepository usersRepo;
    private TasksRepository taskRepo;

    @Autowired
    public TodomonController(UsersRepository usersRepo, TasksRepository taskRepo) {
        this.usersRepo = usersRepo;
        this.taskRepo = taskRepo;
    }

    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/user")
    public String user() {
        return "index";
    }

    @RequestMapping(value = "/admin")
    public String admin() {
        return "adminpage";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "customlogin";
    }

    @RequestMapping(value = "/403")
    public String Error403() {
        return "403";
    }

    @RequestMapping("/main")
    public String paasivu(Model model) {
        String username = getCurrentUsername();
        Optional<Users> optUser = usersRepo.findById(username);
        Users user = optUser.get();

        Iterable<Tasks> taskipool = taskRepo.findByStateAndUsers(0, user);
        Iterable<Tasks> toDo = taskRepo.findByStateAndUsers(1, user);
        Iterable<Tasks> inProgress = taskRepo.findByStateAndUsers(2, user);
        Iterable<Tasks> doneTasks = taskRepo.findByStateAndUsers(3, user);

        Iterable<Tasks> taskit;
        taskit = taskRepo.findByUsers(user);
        model.addAttribute("newitem", new Tasks()); //paikka uudelle taskille, joka tulee formista pooliin
        model.addAttribute("todomonpool0", taskipool);
        model.addAttribute("todo1", toDo);
        model.addAttribute("inprogress2", inProgress);
        model.addAttribute("donelista3", doneTasks);
        return "index";
    }

    @PostMapping("/luotaski")
    public String luoUusiTask(@ModelAttribute Tasks requestItem) {
        Tasks taski = new Tasks(requestItem.getTask(), requestItem.getDescription(), requestItem.getCategory());
        String username = getCurrentUsername();
        Optional<Users> optUser = usersRepo.findById(username);
        Users user = optUser.get();
        taski.setUsers(user);
        taski.setState(0);
        taskRepo.save(taski);
        return "redirect:/main";
    }

    @RequestMapping("/poistataski")
    public String poistaTaski(@ModelAttribute Tasks removeItem){
        taskRepo.removeByState(4);
        return "redirect:/main";
    }

    @PostMapping("/registration")
    public String luoUusiKayttaja(@ModelAttribute Users requestItem) {
        Users user = new Users(requestItem.getUsername(), requestItem.getPassword());
        usersRepo.save(user);
        return "home";
    }

    public String getCurrentUsername() {

        String username = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        return username;

    }


}
