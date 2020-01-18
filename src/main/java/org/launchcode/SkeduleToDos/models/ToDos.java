package org.launchcode.SkeduleToDos.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class ToDos {
    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    private String title;

    @NotBlank
    private String day;

    @NotBlank
    private String time;

    @NotNull
    private String completed;

    @ManyToOne
    private Users users;

    public ToDos(String title, String day, String time, String completed) {
        this.title = title;
        this.day = day;
        this.time = time;
        this.completed = completed;
    }

    public ToDos() { }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }
}
