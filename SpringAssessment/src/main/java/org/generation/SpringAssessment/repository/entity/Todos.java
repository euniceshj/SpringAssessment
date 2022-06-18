package org.generation.SpringAssessment.repository.entity;

import org.generation.SpringAssessment.controller.dto.TodoDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Todos {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private Date targetDate;

    public Todos() {}

    public Todos(TodoDto todoDto) {
        this.title = todoDto.getTitle();
        this.description = todoDto.getDescription();
        this.targetDate = todoDto.getTargetDate();

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    @Override
    public String toString()
    {
        return "To-Do{" + "id=" + id + ", Title='" + title + '\'' + ", Description='" + description + '\'' + ", Target Date='"
                + targetDate + '}';
    }
}
