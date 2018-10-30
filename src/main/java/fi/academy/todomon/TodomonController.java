package fi.academy.todomon;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.RequestMapping;

        import java.util.ArrayList;

@Controller
public class TodomonController {

    private UsersRepository usersRepo;
    private TasksRepository taskRepo;

    @Autowired
    public TodomonController(UsersRepository usersRepo, TasksRepository taskRepo) {
        this.usersRepo = usersRepo;
        this.taskRepo = taskRepo;
    }

    @RequestMapping("/")
    public String paasivu(Model model) {
        Iterable<Tasks> taskit;
            taskit = taskRepo.findAll();
        model.addAttribute("todomonLista", taskit);
        return "index";
    }

}

