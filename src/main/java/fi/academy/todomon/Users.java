package fi.academy.todomon;

import javax.persistence.*;


@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "users_id_seq")
//    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
    private Integer id;
    private String username;
    private String password;
    private Integer level;
    private Integer mon; //todomonin type

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Users(String username, String password, Integer level, Integer mon) {
        this.username = username;
        this.password = password;
        this.level = level;
        this.mon = mon;
    }

    public Users() {
    }
}