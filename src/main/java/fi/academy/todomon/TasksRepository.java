package fi.academy.todomon;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TasksRepository extends CrudRepository<Tasks, Integer> {

    List<Tasks> findByStateEquals(Integer state);
    List<Tasks> findAllByUsers(String username);
}
