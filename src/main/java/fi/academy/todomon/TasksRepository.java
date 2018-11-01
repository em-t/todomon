package fi.academy.todomon;

import org.springframework.data.jpa.repository.Modifying;
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

    @Transactional
    List<Tasks> removeByUsersAndId(Users username, Integer id);

    @Transactional
    void removeById(Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Tasks t SET t.state = :state WHERE t.id = :id")
    void updateUserSetStateForId(@Param("state") Integer state, @Param("id") Integer id);

}
