package com.nirav.mvc.todo.model;

import javax.validation.constraints.Size;
import java.util.Date;

public class ToDoEntity {

    public ToDoEntity() {
    }

    private int id;
    private String user;

    @Size(min = 6, message = "Enter Minimum 6 Characters!!")
    private String description;
    private Date targetDate;
    private boolean isDone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public ToDoEntity(int id, String user, String description, Date targetDate, boolean isDone) {
        this.id = id;
        this.user = user;
        this.description = description;
        this.targetDate = targetDate;
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return "ToDoEntity{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                ", isDone=" + isDone +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ToDoEntity that = (ToDoEntity) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
