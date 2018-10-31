package fi.academy.todomon;

import javax.persistence.*;
import java.util.List;


@Entity
public class Users {

    @Id
    private String username;
    @OneToMany(mappedBy = "users")

    public List<Tasks> tasks;

    private String password;
    private Integer level;
    private Integer mon; //todomonin type

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(List<Tasks> tasks) {
        this.tasks = tasks;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getMon() {
        return mon;
    }

    public void setMon(Integer mon) {
        this.mon = mon;
    }

    public Users() {
    }


}