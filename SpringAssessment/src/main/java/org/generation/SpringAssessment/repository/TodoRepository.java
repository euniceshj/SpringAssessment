package org.generation.SpringAssessment.repository;

import org.generation.SpringAssessment.repository.entity.Todos;
import org.springframework.data.repository.*;

public interface TodoRepository extends CrudRepository<Todos, Integer> {

}
