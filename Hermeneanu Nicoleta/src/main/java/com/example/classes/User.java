package com.example.classes;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(nullable = false, length = 10, name = "username")
    private String username;

    @Column(length = 10, nullable = false)
    private String password;

    @Column(name = "time_spent_watching")
    private int time_spent_watching;

    public Long getId() {
        return user_id;
    }

    public void setId(Long id) {
        this.user_id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTimeSpentWatching() {
        return time_spent_watching;
    }

    public void setTimeSpentWatching(int time_spent_watching) {
        this.time_spent_watching = time_spent_watching;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", time_spent_watching=" + time_spent_watching +
                '}';
    }
}