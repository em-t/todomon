package fi.academy.todomon;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.ModelAttribute;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestMapping;
        import java.util.ArrayList;
        import java.util.Date;
        import java.security.Principal;

@Controller
public class TodomonController {

    private CustomizedAuthenticationSuccessHandler userhandler;
    private UsersRepository usersRepo;
    private TasksRepository taskRepo;

    @Autowired
    public TodomonController(UsersRepository usersRepo, TasksRepository taskRepo, CustomizedAuthenticationSuccessHandler userhandler) {
        this.usersRepo = usersRepo;
        this.taskRepo = taskRepo;
        this.userhandler = userhandler;
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
            Iterable<Tasks> taskipool;
            taskipool = taskRepo.findByStateEquals(0);
            Iterable <Tasks> tehdytTaskit;
            tehdytTaskit = taskRepo.findByStateEquals(3);
        model.addAttribute("newitem", new Tasks()); //paikka uudelle taskille, joka tulee formista
        model.addAttribute("todomonpool", taskipool);
        model.addAttribute("donelista", tehdytTaskit);
        return "index";
    }

    //uuden taskin lisäys listaan:
    //usernamen haku uudelle taskille kusee toistaiseksi
    @PostMapping("/luotaski")
    public String luoUusiTask(@ModelAttribute Tasks requestItem) {
        Tasks taski = new Tasks(requestItem.getTask(), requestItem.getDescription(), requestItem.getCategory());
        taskRepo.save(taski);
        return "redirect:/index";
    }

    /*taskin siirto toiseen lis taan. Tämän voisi tehdä myös booleanilla + checkbox?
    Uusi Query pääsivulle: TasksRepo findAllwithDone() tms.
    @PostMapping("/taskmove")
    @PostMapping
    public String siirraTaskia(@ModelAttribute JOTAIN){
    }
    */

    // Käyttäjähallinta & autentikointi

}
