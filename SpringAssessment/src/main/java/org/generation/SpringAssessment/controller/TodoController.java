package org.generation.SpringAssessment.controller;

import org.generation.SpringAssessment.controller.dto.TodoDto;
import org.generation.SpringAssessment.repository.entity.Todos;
import org.generation.SpringAssessment.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.Date;


@RestController
@RequestMapping ("/todos")
public class TodoController {

    final TodoService todoService;
    public TodoController (@Autowired TodoService todoService) {
        this.todoService = todoService;
    }

    @CrossOrigin    //this annotation will be put on top of every API
    @GetMapping("/all")
    public Iterable<Todos> getItems() {
        return todoService.all();
    }

/*
    @CrossOrigin
    @PostMapping("/add")
    public void save
            (@RequestBody Todos todo) throws IOException {
            TodoDto todoDto = new TodoDto(todo.getTitle(), todo.getDescription(), todo.getTargetDate());
            todoService.save(new Todos(todoDto));
    }
]*/
    @CrossOrigin
    @PostMapping("/add")
    public void save(  @RequestParam(name="title", required = true) String title,
                       @RequestParam(name="description", required = true) String description,
                       @RequestParam(name="targetDate", required = true) Date targetDate)throws IOException {

        System.out.println(title);
        System.out.println(description);
        System.out.println(targetDate);


        TodoDto todoDto = new TodoDto(title, description, targetDate);
        todoService.save(new Todos(todoDto));
    }

}
