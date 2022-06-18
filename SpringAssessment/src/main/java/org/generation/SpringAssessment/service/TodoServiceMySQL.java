package org.generation.SpringAssessment.service;

import org.generation.SpringAssessment.repository.entity.Todos;
import org.generation.SpringAssessment.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceMySQL implements TodoService {

    private final TodoRepository todoRepository;
    public TodoServiceMySQL(@Autowired TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todos> all() {
        List<Todos> result = new ArrayList<>();
        todoRepository.findAll().forEach(result :: add);
        return result;
    };

    public Todos save (Todos todos){
        return todoRepository.save(todos);
    }

    public void delete(int todoId) {
        todoRepository.deleteById(todoId);
    };

    public Todos findById(int todoId) {
        Optional<Todos> todos = todoRepository.findById(todoId); //Cannot be a null
        Todos todoResponse = todos.get();

        return todoResponse;
    };


}
