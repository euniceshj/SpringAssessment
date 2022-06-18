package org.generation.SpringAssessment.controller.dto;

import java.sql.Date;

public class TodoDto {

    private Integer id;     //need to pass the id to a class method findItemById()
    private String title;
    private String description;

    private Date targetDate;

    public TodoDto(String title, String description, Date targetDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.targetDate = targetDate;

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
}
