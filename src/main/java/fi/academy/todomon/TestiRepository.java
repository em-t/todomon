package fi.academy.todomon;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TestiRepository extends CrudRepository<Testitable, Integer> {

    Iterable<Testitable> findByState(Integer state);
}
