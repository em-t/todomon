package fi.academy.todomon;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
    private Integer id;
    @Lob
    private String task;
    @Lob
    private String description;
    private Integer userId; //foreign key, lisää linkitys
    private Date due;
    private Integer rank; //taskin vaikeus
    private Integer state; //esim. todo, doing, done
    @Lob
    private String category;


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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Tasks(String task, String description, Integer userId, Date due, Integer rank, Integer state, String category) {
        this.task = task;
        this.description = description;
        this.userId = userId;
        this.due = due;
        this.rank = rank;
        this.state = state;
        this.category = category;
    }

    public Tasks() {
    }
}

