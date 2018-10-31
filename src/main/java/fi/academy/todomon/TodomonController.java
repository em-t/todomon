package fi.academy.todomon;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.ModelAttribute;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestMapping;

        import java.util.ArrayList;
        import java.util.Date;

@Controller
public class TodomonController {

    private UsersRepository usersRepo;
    private TasksRepository taskRepo;

    @Autowired
    public TodomonController(UsersRepository usersRepo, TasksRepository taskRepo) {
        this.usersRepo = usersRepo;
        this.taskRepo = taskRepo;
    }

    //Tästä alkaa Päivin lisäykset

    @RequestMapping("/")
    public String paasivu(Model model) {
        Iterable<Tasks> taskit;
            taskit = taskRepo.findAll();
        model.addAttribute("newitem", new Tasks()); //paikka uudelle taskille, joka tulee formista
        model.addAttribute("todomonLista", taskit);
        return "index";
    }

    //uuden taskin lisäys listaan:
    //usernamen haku uudelle taskille kusee toistaiseksi
    @PostMapping("/luotaski")
    public String luoUusiTask(@ModelAttribute Tasks requestItem) {
        Tasks taski = new Tasks(requestItem.getTask(), requestItem.getDescription(), requestItem.getCategory());
        taskRepo.save(taski);
        return "redirect:/";
    }

    /*taskin siirto toiseen lis taan. Tämän voisi tehdä myös booleanilla + checkbox?
    Uusi Query pääsivulle: TasksRepo findAllwithDone() tms.
    @PostMapping("/taskmove")
    @PostMapping
    public String siirraTaskia(@ModelAttribute JOTAIN){
    }
    */


}

