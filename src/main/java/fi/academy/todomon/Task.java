package fi.academy.todomon;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String taskName;
    private String description;

    @ManyToOne
    @JoinColumn(name = "username")
    public User user;
    private Date due;
    private Integer rank; //taskin vaikeus
    private Integer state; //todo, doing, done, delete
    private String category;

    //constructor simple formille
    public Task(String taskName, String description, String category) {
        this.taskName = taskName;
        this.description = description;
        this.category = category;
    }

    public Task(String taskName, String description, User user, Date due, Integer rank, Integer state, String category) {
        this.taskName = taskName;
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
                taskName, description, category);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public User getUser() {
        return user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUser(User user) {
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