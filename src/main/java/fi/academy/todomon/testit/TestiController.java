package fi.academy.todomon.testit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestiController {

    private TestiRepository testirepo;

    @Autowired
    public TestiController(TestiRepository testirepo) {
        this.testirepo = testirepo;
    }

    @GetMapping("/testi")
    public String paskaaKusella(Model model) {
        Iterable<Testitable> t0 = testirepo.findByState(0);
        model.addAttribute("tasks0", t0);
        Iterable<Testitable> t1 = testirepo.findByState(1);
        model.addAttribute("tasks1", t1);
        Iterable<Testitable> t2 = testirepo.findByState(2);
        model.addAttribute("tasks2", t2);
        Iterable<Testitable> t3 = testirepo.findByState(3);
        model.addAttribute("tasks3", t3);
        System.out.println(t3);
        return "testindex";
    }

/*    @PutMapping("/put/{id}")
    public String haisevaPaska(Model model) {
        Optional<Testitable> opt = testirepo.findById(id);
        Testitable task = opt.get();

        return "testindex";
    }*/
}
