package fi.academy.todomon;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.security.core.context.SecurityContextHolder;
        import org.springframework.security.core.userdetails.UserDetails;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
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

//    @RequestMapping(value = "/user")
//    public String user() {
//        return "index";
//    }

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
        Iterable<Tasks> taskit;
        // hakee nyt kaikki taskit käyttäjästä riippumatta! muokkaa queryä
            taskit = taskRepo.findAll();
        model.addAttribute("newitem", new Tasks()); //paikka uudelle taskille, joka tulee formista
        model.addAttribute("todomonLista", taskit);
        return "index";
    }

    //uuden taskin lisäys listaan:
    //usernamen haku uudelle taskille kusee toistaiseksi
    @PostMapping("/luotaski")
    public String luoUusiTask(@ModelAttribute Tasks requestItem) {
        String username = null;
        Tasks taski = new Tasks(requestItem.getTask(), requestItem.getDescription(), requestItem.getCategory());
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        Optional<Users> optUser = usersRepo.findById(username);
        Users user = optUser.get();
        taski.setUsers(user);
        taskRepo.save(taski);
        return "redirect:/main";
    }

    /*taskin siirto toiseen lis taan. Tämän voisi tehdä myös booleanilla + checkbox?
    Uusi Query pääsivulle: TasksRepo findAllwithDone() tms.
    @PostMapping("/taskmove")
    @PostMapping
    public String siirraTaskia(@ModelAttribute JOTAIN){
    }
    */



}
