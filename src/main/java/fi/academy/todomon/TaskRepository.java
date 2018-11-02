package fi.academy.todomon;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;


public interface TaskRepository extends CrudRepository<Task, Integer> {

    List<Task> findByStateAndUser(Integer state, User user);

    Iterable<Task> findByUser(User user);

    @Transactional
    List<Task> removeByState(Integer state);

    @Transactional
    void removeById(Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Task t SET t.state = :state WHERE t.id = :id")
    void updateUserSetStateForId(@Param("state") Integer state, @Param("id") Integer id);

}
