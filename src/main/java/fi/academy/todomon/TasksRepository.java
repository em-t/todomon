package fi.academy.todomon;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;


public interface TasksRepository extends CrudRepository<Tasks, Integer> {

    List<Tasks> findByStateAndUsers(Integer state, Users user);

    Iterable<Tasks> findByUsers(Users user);

    @Transactional
    List<Tasks> removeByState(Integer state);

}
