package fi.academy.todomon;

import org.springframework.data.repository.CrudRepository;

public interface TasksRepository extends CrudRepository<Tasks, Integer> {


}
