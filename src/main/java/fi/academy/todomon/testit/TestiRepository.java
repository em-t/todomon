package fi.academy.todomon.testit;

import org.springframework.data.repository.CrudRepository;

public interface TestiRepository extends CrudRepository<Testitable, Integer> {

    Iterable<Testitable> findByState(Integer state);
}
