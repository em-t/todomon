package fi.academy.todomon;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String task;
    private String description;

    @ManyToOne
    @JoinColumn(name = "username")
    public User user;
    private Date due;
    private Integer rank; //taskin vaikeus
    private Integer state; //todo, doing, done, delete
    private String category;

    //constructor simple formille
    public Task(String task, String description, String category) {
        this.task = task;
        this.description = description;
        this.category = category;
    }

    public Task(String task, String description, User users, Date due, Integer rank, Integer state, String category) {
        this.task = task;
        this.description = description;
        this.user = user;
        this.due = due;
        this.rank = rank;
        this.state = state;
        this.category = category;
    }

    public Task() {
    }

    @Override
    public String toString() {
        return String.format(
                "Tasks[task=%d, description='%s', category='%s']",
                task, description, category);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUsers() {
        return user;
    }

    public void setUser(User users) {
        this.user = user;
    }

    public Date getDue() {
        return due;
    }

    public void setDue(Date due) {
        this.due = due;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


}