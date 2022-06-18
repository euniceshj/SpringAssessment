package org.generation.SpringAssessment.service;

import org.generation.SpringAssessment.repository.entity.Todos;

import java.util.List;

public interface TodoService {

    List<Todos> all();

    Todos save (Todos todos);

    void delete(int todoId);

    Todos findById(int todoId);
}
