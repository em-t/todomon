package fi.academy.todomon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
public class TodomonController {

    private UserRepository userRepo;
    private TaskRepository taskRepo;

    @Autowired
    public TodomonController(UserRepository userRepo, TaskRepository taskRepo) {
        this.userRepo = userRepo;
        this.taskRepo = taskRepo;
    }

    @RequestMapping(value = "/")
    public String home() {
        return "customlogin";
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

    @RequestMapping(value = "/main", method = { RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE})
    public String homepage(@RequestParam(value = "taskId", required = false) String currentId,
                           @RequestParam(value = "state", required = false) String newState, Model model) {
        String username = getCurrentUsername();
        Optional<User> optUser = userRepo.findById(username);
        User user = optUser.get();

        if (null != currentId && null != newState) {
            if ("4".equals(newState)) {
                try {
                    taskRepo.removeById(Integer.parseInt(currentId));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if ("0".equals(newState) || "1".equals(newState) || "2".equals(newState) || "3".equals(newState)) {
                try {
                    taskRepo.updateUserSetStateForId(Integer.parseInt(newState), Integer.parseInt(currentId));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        Iterable<Task> taskipool = taskRepo.findByStateAndUser(0, user);
        Iterable<Task> toDo = taskRepo.findByStateAndUser(1, user);
        Iterable<Task> inProgress = taskRepo.findByStateAndUser(2, user);
        Iterable<Task> doneTasks = taskRepo.findByStateAndUser(3, user);

        model.addAttribute("newitem", new Task());
        model.addAttribute("tasks0", taskipool);
        model.addAttribute("tasks1", toDo);
        model.addAttribute("tasks2", inProgress);
        model.addAttribute("tasks3", doneTasks);

        return "main";
    }

    @PostMapping("/luotaski")
    public String luoUusiTask(@ModelAttribute Task requestItem) {
        Task taski = new Task(requestItem.getTaskName(), requestItem.getDescription(), requestItem.getCategory());
        String username = getCurrentUsername();
        Optional<User> optUser = userRepo.findById(username);
        User user = optUser.get();
        taski.setUser(user);
        taski.setState(0);
        taskRepo.save(taski);
        return "redirect:/main";
    }

    @RequestMapping("/poistataski")
    public String poistaTaski(@ModelAttribute Task removeItem){
        taskRepo.removeByState(4);
        return "redirect:/main";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String luoUusiKayttaja(@ModelAttribute User requestItem) {
        User user = new User(requestItem.getUsername(), requestItem.getPassword());
        userRepo.save(user);
        return "customlogin";
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
