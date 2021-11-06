package com.example.tp_chap6;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Logs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String date;
    private String content;
    @ManyToOne
    @JsonIgnoreProperties("logs")
    private User user;

    public Logs(String date, String content, User user) {
        this.date = date;
        this.content = content;
        this.user = user;
    }
}