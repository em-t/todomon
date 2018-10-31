package fi.academy.todomon;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TasksRepository extends CrudRepository<Tasks, Integer> {

//    @Query("select t from Tasks t where t.username = ?1")
//    Iterable<Tasks> findAllByUsername(String username);
    Iterable<Tasks> findByUsers(Users user);
}
